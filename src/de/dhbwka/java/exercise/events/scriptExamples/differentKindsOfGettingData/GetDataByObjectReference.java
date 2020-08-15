package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfGettingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Nur anwendbar, wenn Referenzen gespeichert werden (bspw in Instanzvariablen (!static)

public class GetDataByObjectReference extends JFrame{
    private JButton button1 = new JButton("OK");
    private JButton button2 = new JButton("OK");
    //^--

    public GetDataByObjectReference() {
        this.setLayout(new GridLayout(1,2));

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1){
                    //^--
                    System.out.println("First OK");
                } else if (e.getSource() == button2){
                            //^--
                    System.out.println("Second OK");
                }
            }
        };

        button1.addActionListener(listener);
        button2.addActionListener(listener);
        this.add(button1);
        this.add(button2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GetDataByObjectReference();
    }
}
