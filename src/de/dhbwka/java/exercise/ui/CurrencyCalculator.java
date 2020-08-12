package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator {
    public CurrencyCalculator() {
        JFrame frame = new JFrame("Currency converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(getFrameContent());

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel getFrameContent(){
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(new JTextField("Please enter amount to convert!"), BorderLayout.NORTH);

        //Eigene Lösung
        JPanel buttons = new JPanel();
        buttons.add(new JButton("EUR -> USD"));
        buttons.add(new JButton("USD -> EUR"));
        buttons.add(new JButton("Cancel"));

        panel.add(buttons, BorderLayout.CENTER);
        //Lösung nach Musterlösung
//        panel.add(new JButton("EUR -> USD"), BorderLayout.WEST);
//        panel.add(new JButton("USD -> EUR"), BorderLayout.CENTER);
//        panel.add(new JButton("Cancel"), BorderLayout.EAST);
        return panel;
    }

    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
