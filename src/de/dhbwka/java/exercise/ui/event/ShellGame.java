package de.dhbwka.java.exercise.ui.event;

import de.dhbwka.java.utilities.files.read.dataFiles.DataFileToArray;
import de.dhbwka.java.utilities.files.write.append.AppendStringToFile;
import de.dhbwka.java.utilities.random.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShellGame implements ActionListener {
    private final JFrame frame = new JFrame("Shell game");
    private JTextField tfName;
    private JTextField tfMessage;
    private JButton bNewGame;
    private JButton bStats;
    private JPanel shells;
    private int rightShell;
    private int attempts;
    private String name;
    private boolean ongoingGame = false;
    private final String FILENAME = "shellScores.txt";

    public ShellGame() {
        frame.setLayout(new BorderLayout(0, 5));
        frame.add(getHeader(), BorderLayout.NORTH);
        frame.add(getMainContent());
        frame.add(getFooter(), BorderLayout.SOUTH);

        setIsInGame(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    ///////////////////////////////////////////////////////////////////////////
    // action Performed Methods
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ongoingGame){
            tfMessage.setText("Please start a game first.");
        } else {
            JButton src = ((JButton) e.getSource());
            int shellNumber = Integer.parseInt(src.getName());
            attempts++;
            checkAndHandleGuess(shellNumber==rightShell, shellNumber);
        }
    }

    private void checkAndHandleGuess(boolean won, int shellNumber){
        if (won) {
            tfMessage.setText(name + ": Attempt " + attempts +" wins; Ball was below shell " + shellNumber);
            printStatsToFile(name, attempts);
            ongoingGame = false;
            setIsInGame(false);
        } else {
            tfMessage.setText(name + ": " + attempts + " attempt" + (attempts==1?"":"s") + "; Ball was not below shell " + shellNumber);
            setBall();
        }
    }

    private void handleNewButtonClick(){
        if (tfName.getText().isEmpty()){
            tfMessage.setText("Please enter a name first.");
        } else {
            ongoingGame = true;
            setIsInGame(true);
            tfMessage.setText("");
            name = tfName.getText();
            attempts = 0;
            setBall();
        }
    }

    private void handleStatsButtonClick(){
        if(ongoingGame){
            tfMessage.setText("Please finish your game first.");
        } else {
            String[][] data = DataFileToArray.getStringArrayOfDataFileWithDelimiter(FILENAME, ';');
            try {
                int sumOfAttempts = 0;
                for (int i = 0; i < data.length; i++) {
                    sumOfAttempts+=Integer.parseInt(data[i][1]);
                }
                tfMessage.setText("Average number of attempts required: " + (sumOfAttempts/(double)data.length));
            } catch (Exception e){
                tfMessage.setText("Error: Missing or corrupted file " + FILENAME);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Frame Components
    ///////////////////////////////////////////////////////////////////////////
    //-------------Frame Content------------------
    private JPanel getHeader() {
        JPanel headerPanel = new JPanel();
        JLabel label = new JLabel("Player Name");
        tfName = new JTextField(19);
        headerPanel.add(label);
        headerPanel.add(tfName);
        return headerPanel;
    }

    private JPanel getMainContent() {
        JPanel contentPanel = new JPanel(new GridLayout(2, 1, 0, 5));

        shells = new JPanel();
        //////////////////////////////
        for (int i = 1; i <= 3; i++) {
            JButton button = new JButton("Shell " + i);
            button.setName(Integer.toString(i));
            button.addActionListener(this);
            button.setEnabled(false);
            shells.add(button);
        }
        contentPanel.add(shells);

        JPanel tools = new JPanel();
        ////////////////////////////
        bNewGame = new JButton("New Game");
        bNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNewButtonClick();
            }
        });
        bStats = new JButton("Statistics");
        bStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleStatsButtonClick();
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        tools.add(bNewGame);
        tools.add(bStats);
        tools.add(exit);
        contentPanel.add(tools);

        return contentPanel;
    }

    private JPanel getFooter() {
        JPanel footerPanel = new JPanel();
        tfMessage = new JTextField(25);
        tfMessage.setEnabled(false);
        tfMessage.setDisabledTextColor(Color.decode("#000000"));
        footerPanel.add(tfMessage);
        return footerPanel;
    }
    //---------End-Frame Content------------------

    ///////////////////////////////////////////////////////////////////////////
    // Standalone Methods
    ///////////////////////////////////////////////////////////////////////////
    private void setBall() {
        rightShell = Random.RandomIntIncMinIncMax(1, 3);
    }

    private void printStatsToFile(String name, int attempts){
        AppendStringToFile.appendStringToFile_WithErrorDescription(FILENAME, name+";"+attempts);
    }

    private void setIsInGame(boolean active){
        for (int i = 0; i<3; i++){
            shells.getComponent(i).setEnabled(active);
        }
        bNewGame.setEnabled(!active);
        bStats.setEnabled(!active);
    }



    public static void main(String[] args) {
        new ShellGame();
    }
}