package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfGettingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Nur anwendbar, falss sinnvolle Command-Namen vorhanden

public class GetDataByActionCommand extends JFrame {
    private JButton button1 = new JButton("OK");
    private JButton button2 = new JButton("OK");

    public GetDataByActionCommand() {
        this.setLayout(new GridLayout(1,2));

        //
        button1.setActionCommand("Button 1");
        button2.setActionCommand("Button 2");
        //^--

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                                //^--
                System.out.println(cmd);
            }
        };

        this.button1.addActionListener(listener);
        this.button2.addActionListener(listener);

        this.add(button1);
        this.add(button2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GetDataByActionCommand();
    }
}
