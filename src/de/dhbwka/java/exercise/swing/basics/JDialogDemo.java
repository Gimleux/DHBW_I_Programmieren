package de.dhbwka.java.exercise.swing.basics;

import javax.swing.*;

public class JDialogDemo {
    public static void main(String[] args) {
        JFrame f1 = new JFrame("Frame 1");
        f1.add(new JTextField("Frame 1"));
        f1.setSize(170,60);
        f1.setVisible(true);

        JFrame f2 = new JFrame("Frame 2");
        f2.add(new JTextField("Frame 2"));
        f2.setSize(170,60);
        f2.setVisible(true);

        JDialog d1 = new JDialog(f1, "Dialog1", false);
        d1.add(new JTextField("not modal"));
        d1.setSize(176,60);
        d1.setVisible(true);

        JDialog d2 = new JDialog(f2, "Dialog 2", true);
        d2.add(new JTextField("modal"));
        d2.setSize(170,60);
        d2.setVisible(true);

        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
