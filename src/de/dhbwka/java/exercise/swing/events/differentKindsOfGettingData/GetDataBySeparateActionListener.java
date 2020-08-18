package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfGettingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Meistens anwendbar
// - bläht Code auf
// - kann leicht zu redundantem Code führen

public class GetDataBySeparateActionListener extends JFrame {
    private JButton button1 = new JButton("OK");
    private JButton button2 = new JButton("OK");

    public GetDataBySeparateActionListener() {
        this.setLayout(new GridLayout(1,2));

        //
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2");
            }
        });
        //^--

        this.add(button1);
        this.add(button2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GetDataBySeparateActionListener();
    }
}
