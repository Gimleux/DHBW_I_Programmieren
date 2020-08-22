package de.dhbwka.java.exercise.swing.swingVsJavaFX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld_Swing extends JFrame {
    public HelloWorld_Swing(String title){
        super(title);
        this.setLayout(new BorderLayout());
        JButton button = new JButton("Say Hello World");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World");
            }
        });
        this.add(button);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,250);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloWorld_Swing("Hello World");
    }
}
