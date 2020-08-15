package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculator implements ActionListener{
    private final String[] buttonTexts = new String[]{"EUR -> USD", "USD -> EUR", "Cancel"};
    private final double FACTOR = 1.09;

    JTextField textField = new JTextField("Please enter amount to convert!");

    public CurrencyCalculator() {
        JFrame frame = new JFrame("Currency converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(getFrameContent());

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = ((JButton) e.getSource()).getName();
        switch (name) {
            case "button#1":
                textField.setText(multOrDiv(textField.getText(), true));
                break;
            case "button#2":
                textField.setText(multOrDiv(textField.getText(), false));
                break;
            case "button#3":
            default:
                System.exit(0);
        }
    }

    private String multOrDiv(String input, boolean shouldMult){
        double number;
        try {
            number = Double.parseDouble(input);
        } catch (Exception e){
            return "Bitte eine Zahl eintragen";
        }
        if (shouldMult){
            number*=FACTOR;
        } else number/= FACTOR;
        return Double.toString(number);
    }

    private JPanel getFrameContent() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(textField, BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        for (int i = 0; i < 3; i++){
            JButton button = new JButton(buttonTexts[i]);
            button.setName("button#" + (i+1));
            button.addActionListener(this);
            buttons.add(button);
        }

        panel.add(buttons, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
