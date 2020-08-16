package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuess extends JFrame implements ActionListener {
    private final String[] BUTTON_LABELS = new String[]{"New Game", "OK", "BestPlayer", "Exit"};
    private String name;
    private int guess;
    private JTextField tfName = new JTextField("Name", 20);
    private JTextField tfGuess = new JTextField(10);
    private JTextField tfMessage = new JTextField(30);

    public NumberGuess() throws HeadlessException {
        super("NumberGuessingGame");
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(getHeaderComponents(), BorderLayout.NORTH);
        this.add(getCenterComponents());
        this.add(getFooterComponents(), BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton)e.getSource()).getText();
        if (text.equalsIgnoreCase(BUTTON_LABELS[0])){

        } else if (text.equalsIgnoreCase(BUTTON_LABELS[1])){

        } else if (text.equalsIgnoreCase(BUTTON_LABELS[2])){

        } else if (text.equalsIgnoreCase(BUTTON_LABELS[3])) {
            System.exit(0);
        }
    }

    private JPanel getHeaderComponents() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Player Name"));
        tfName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = ((JTextField) e.getSource()).getText();
            }
        });
        panel.add(tfName);
        return panel;
    }

    private JPanel getCenterComponents(){
        JPanel panel = new JPanel(new GridLayout(2,1));

        JPanel enterNumberPanel = new JPanel();
        enterNumberPanel.add(new JLabel("Enter number between 1 and 1000"));
        tfGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String input = tfGuess.getText();
                    guess = Integer.parseInt(input);
                } catch (Exception exc){
                    tfGuess.setText("Please enter a number");
                }
            }
        });
        enterNumberPanel.add(tfGuess);

        JPanel buttonsPanel = new JPanel();
        for (int i = 0; i<=3; i++){
            JButton button = new JButton(BUTTON_LABELS[i]);
            button.addActionListener(this);
            buttonsPanel.add(button);
        }

        panel.add(enterNumberPanel);
        panel.add(buttonsPanel);

        return panel;
    }

    private JPanel getFooterComponents(){
        JPanel panel = new JPanel();
        tfMessage.setEnabled(false);
        panel.add(tfMessage);
        return panel;
    }

    public static void main(String[] args) {
        new NumberGuess();
    }
}