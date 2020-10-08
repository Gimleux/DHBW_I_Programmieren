package de.dhbwka.java.exercise.exam.SoederMemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Thread.sleep;

public class MemoryGameTerm implements  Runnable{
    private MemoryGame game;

    private ArrayList<JToggleButton> toggleButtons;
    private ActionListener actionListener;
    private JToggleButton selected=null;
    private int foundcount=0;
    private int roundcount=0;
    private JFrame frame;
    private JPanel north;
    private JPanel center;
    private boolean running=true;
    private Thread runner;

    public MemoryGameTerm(MemoryGame game) {
        this.game = game;
        runner=new Thread(this);



        actionListener= e -> cardSelected(e);
        startGame();
        drawUI();

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        runner.start();


    }

    private void cardSelected(ActionEvent e) {

        if (selected==null){
            selected= (JToggleButton) e.getSource();
            roundcount++;
        }
        else if (selected.getName().equals(((JToggleButton)e.getSource()).getName())){
            game.getActivePlayer().addPoint();
            selected.setEnabled(false);
            ((JToggleButton)e.getSource()).setEnabled(false);
            foundcount++;


            if (foundcount==Math.floor(toggleButtons.size()/2)){
                for (Player p:game.getPlayers()
                ) {
                    p.setStatus(Player.PlayerStatus.FINISHED);
                }
                endgame();
            }
            selected=null;

        }
        else {
            JOptionPane.showMessageDialog(null,"Sorry falsch");
            selected.setSelected(false);
            ((JToggleButton)e.getSource()).setSelected(false);
            game.nextPlayer();
            selected=null;
        }
        drawUsers();
    }

    private void endgame() {
        running=false;
        StringBuilder stringBuilder=new StringBuilder("Game fertig nach "+roundcount+" Runden   ");
        game.getPlayers().sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Integer.compare(o2.getPoints(),o1.getPoints());
            }
        });
        for (Player p:
                game.getPlayers()) {
            stringBuilder.append(p.getName()+" "+p.getPoints()+" ");
        }
        StringBuilder sb=new StringBuilder("\nLast Games:\n\n");
        final String filename= "memory.txt";
        File newFile = new File(filename);
        File parent = newFile.getParentFile();
        try {
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                System.out.println("Ordner konnten nicht erstellt werden: " + filename);
                return;
            }
            if (!newFile.exists() && !newFile.createNewFile()) {
                System.out.println("Datei existiert schon, oder konnt nicht erstellt werden: " + filename);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(filename));
             BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filename,true))) {

            while (bufferedReader.ready()){
                sb.append(bufferedReader.readLine()+"\n");
            }

            bufferedWriter.write(stringBuilder.toString()+"\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,stringBuilder.append(sb));
    }

    private void drawUI() {
        frame=new JFrame("Soeder Memory");
        north=new JPanel(new GridLayout(game.getPlayers().size(),1));
        center=new JPanel(new GridLayout(game.getRows(),game.getCols()));
        frame.add(north,BorderLayout.NORTH);
        frame.add(center,BorderLayout.CENTER);

        drawUsers();


        toggleButtons=new ArrayList<>();

        for (MemoryImages.MemoryImage memoryImage:game.getMemoryImages()
        ) {

            JToggleButton btn = new JToggleButton();
            btn.setName( memoryImage.getId() ); // Could be used to check if two buttons have the same image
            btn.setIcon( MemoryImages.getBackside() ); // Bavarian flag for UNSELECTED JToggleButton
            btn.setSelectedIcon( memoryImage.getImage() ); // Set the icon for SELECTED JToggleButton
            btn.setDisabledSelectedIcon( memoryImage.getImage() ); // Set the icon for SELECTED and DISABLED JToggleButton (keeps color)
            btn.addActionListener(actionListener);

            toggleButtons.add(btn);
            btn = new JToggleButton();
            btn.setName( memoryImage.getId() ); // Could be used to check if two buttons have the same image
            btn.setIcon( MemoryImages.getBackside() ); // Bavarian flag for UNSELECTED JToggleButton
            btn.setSelectedIcon( memoryImage.getImage() ); // Set the icon for SELECTED JToggleButton
            btn.setDisabledSelectedIcon( memoryImage.getImage() ); // Set the icon for SELECTED and DISABLED JToggleButton (keeps color)
            btn.addActionListener(actionListener);

            toggleButtons.add(btn);
        }

        if (game.isBlankRequired()){
            JToggleButton btn = new JToggleButton();
            btn.setName( "falsch");
            btn.setIcon( MemoryImages.getBackside() ); // Bavarian flag for UNSELECTED JToggleButton
            btn.setSelectedIcon( MemoryImages.getBlank() ); // Set the icon for SELECTED JToggleButton
            btn.setDisabledSelectedIcon( MemoryImages.getBlank() ); // Set the icon for SELECTED and DISABLED JToggleButton (keeps color)
            btn.addActionListener(actionListener);

            toggleButtons.add(btn);
        }

        Collections.shuffle(toggleButtons);

        for (JToggleButton b:
                toggleButtons) {
            center.add(b);
        }


    }

    private void drawUsers(){
        System.out.println("d");
        north.removeAll();
        JLabel label;
        for (Player p:
                game.getPlayers()) {
            System.out.println(p.getStatus().color);
            label=new JLabel(p.getName()+":"+p.getPoints());
            label.setForeground(p.getStatus().color);
            north.add(label);
        }
        north.revalidate();
    }

    private void startGame(){
        game.nextPlayer();
    }


    @Override
    public void run() {
        int second=0;
        frame.setTitle("Soeder Memory ("+second+")");

        while (running){
            try {
                sleep(1000);
                second++;
                frame.setTitle("Soeder Memory ("+second+")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}