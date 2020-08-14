package de.dhbwka.java.exercise.events.scriptExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventsWithAnonymousClasses extends JFrame {
    JTextField text = new JTextField("Whatever");
    JButton button = new JButton("Button");

    EventsWithAnonymousClasses(){
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.text);
        this.add(this.button);
        //Innere Klasse:
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText(text.getText());
            }
        });
        this.setSize(400,300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EventsWithAnonymousClasses();
    }
}
