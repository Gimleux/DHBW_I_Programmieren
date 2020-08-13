package de.dhbwka.java.exercise.swing.scriptExamples.layoutDemo;

import javax.swing.*;
import java.awt.*;

public class NestedLayoutExample {

    public NestedLayoutExample() {
        JFrame frame = new JFrame("Book Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4,2,2,2));

        top.add(new JLabel("Author"));
        top.add(new JTextField());

        top.add(new JLabel("Title"));
        top.add(new JTextField());

        top.add(new JLabel("Year"));
        top.add(new JTextField());

        top.add(new JLabel("Publisher"));
        top.add(new JTextField());

        frame.add(top, BorderLayout.NORTH);
        JPanel mid = new JPanel();
        mid.add(new JButton("Save Entry"));
        frame.add(mid, BorderLayout.CENTER);
        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.add(new JLabel("Output sortet by:"));
        bot.add(new JButton("Author"));
        bot.add(new JButton("Title"));
        bot.add(new JButton("Year"));
        frame.add(bot, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NestedLayoutExample();
    }
}
