package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfEventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Umsetzung in anonymer innerer Klasse

//^-- => Besonderheit bei dieser Umsetzung

public class InAnonymousInnerClass extends JFrame {
    JButton button = new JButton("Click me!");

    public InAnonymousInnerClass(){
        this.add(button);

        //
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
            }
        });
        //^--

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200,150);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new InAnonymousInnerClass();
    }
}
