package de.dhbwka.java.exercise.swing.scriptExamples.layoutDemo;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class GridLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3, 2, 6, 3));
        f.add(new JLabel("What's your name?"));
        f.add(new JTextField());
        f.add(new JLabel("Year you were born?"));
        f.add(new JFormattedTextField(NumberFormat.getIntegerInstance()));
        f.add(new JLabel("Enter your password:"));
        f.add(new JPasswordField());
        f.pack();
        f.setVisible(true);
    }
}