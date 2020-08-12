package de.dhbwka.java.exercise.swing.scriptExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JColorChooserDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Change Color");
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent component = (JComponent) e.getSource();
                Color newColor = JColorChooser.showDialog(null, "Choose a new color", Color.RED);
                component.setBackground(newColor);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
