package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfGettingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Nur anwendbar, falls sinnvolle Namen vorhanden
//Nutzt von Component geerbte Methoden
    // void setname (String name)
    // &
    // String getName()

public class GetDataByName extends JFrame {
    private JButton button1 = new JButton("OK");
    private JButton button2 = new JButton("OK");

    public GetDataByName() {
        this.setLayout(new GridLayout(1,2));

        //
        button1.setName("Button 1");
        button2.setName("Button 2");
        //^--

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = ((JButton) e.getSource()).getName();
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
        new GetDataByName();
    }
}
