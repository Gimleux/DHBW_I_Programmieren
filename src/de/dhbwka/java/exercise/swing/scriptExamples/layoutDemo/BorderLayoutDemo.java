package de.dhbwka.java.exercise.swing.scriptExamples.layoutDemo;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5,5));
        frame.add(new JButton("Naughty"), BorderLayout.NORTH);
        frame.add(new JButton("Elephants"), BorderLayout.EAST);
        frame.add(new JButton("Spray"), BorderLayout.SOUTH);
        frame.add(new JButton("Water"), BorderLayout.WEST);
        frame.add(new JButton("Center"));
        frame.setSize(400,150);
        frame.setVisible(true);
    }
}
