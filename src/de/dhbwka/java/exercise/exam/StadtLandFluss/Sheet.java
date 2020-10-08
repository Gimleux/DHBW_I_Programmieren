package de.dhbwka.java.exercise.exam.StadtLandFluss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Sheet extends JFrame {

    private Player player;
    private Game game;

    public Player getPlayer() {
        return player;
    }

    private JLabel points;
    private JLabel seconds;
    private JLabel chara;

    private JButton start;

    private JButton stop;

    private Map<ColumnType,String> map=new HashMap<ColumnType,String>();
    private Map<ColumnType,JTextField> mapTextFileds=new HashMap<ColumnType,JTextField>();
    private Map<ColumnType,JLabel> mapJLabels=new HashMap<ColumnType,JLabel>();


    public Sheet(Player player, Game game) {
        this.player = player;
        this.game = game;


        setTitle(player.getName());


        JPanel top=new JPanel(new GridLayout( 3,2));

        top.add(new JLabel("punkte"));


        points=new JLabel("0");

        top.add(points);
        seconds=new JLabel("30");
        top.add(new JLabel("Zeit"));
        top.add(seconds);


        top.add(new JLabel("Buchstabe"));
        chara=new JLabel();
        top.add(chara);


        add(top,BorderLayout.NORTH);

        JPanel bttm=new JPanel();
        start=new JButton("start");
        stop=new JButton("stop");

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.stopGame();
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
            }
        });

        bttm.add(start);
        bttm.add(stop);

        stop.setEnabled(false);
        add(bttm,BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void stop(){
        mapTextFileds.forEach((key, value) -> {
            map.put(key,value.getText());
            value.setEnabled(false);
        });
        stop.setEnabled(false);
        start.setEnabled(false);
    }



    public void start(){
        System.out.println("start");
        stop.setEnabled(true);
        start.setEnabled(false);

        chara.setText(String.valueOf(game.getaChar()));


        JPanel center=new JPanel(new GridLayout(game.getColumnTypes().size(),3));

        for (ColumnType c:
                game.getColumnTypes()) {


            center.add(new JLabel(c.getTitle()));
            JTextField jTextField=new JTextField();
            mapTextFileds.put(c,jTextField);
            center.add(jTextField);

            JLabel jLabel=new JLabel();
            mapJLabels.put(c,jLabel);
            center.add(jLabel);
        }
        add(center,BorderLayout.CENTER);
        revalidate();
        pack();
    }



    public Map<ColumnType, String> getMap() {
        return map;
    }

    public void setResult(ColumnType c, int i){
        mapJLabels.get(c).setText(String.valueOf(i));
        points.setText(String.valueOf(player.getPoints()));
    }

    public JLabel getSeconds() {
        return seconds;
    }
}