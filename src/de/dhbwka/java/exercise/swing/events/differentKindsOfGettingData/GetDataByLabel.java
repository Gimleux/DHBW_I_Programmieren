package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfGettingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Nur geeignet wenn Texte/Labels unterschiedlich sind

public class GetDataByLabel extends JFrame {
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
                                       //^--

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = ((JButton) e.getSource()).getText();
                                                    //^--
            System.out.println(text);
        }
    };

    public GetDataByLabel(){
        this.setLayout(new GridLayout(1,2, 0, 0));
        this.add(button1);
        button1.addActionListener(listener);
        this.add(button2);
        button2.addActionListener(listener);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GetDataByLabel();
    }
}
