package de.dhbwka.java.exercise.events.scriptExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventDemo implements ActionListener {
    JFrame frame = new JFrame("Event Frame");
    JTextField textField = new JTextField("enter text..");
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");

    public ButtonEventDemo(){
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setLayout(new FlowLayout());
        this.frame.add(this.textField);
        this.textField.addActionListener(this);
        this.frame.add(this.button1);
        this.button1.addActionListener(this);
        this.frame.add(button2);
        this.button2.addActionListener(this);
        this.frame.setSize(400,100);
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == this.textField) { //Geht nicht bei Änderungen im Textfeld?!
            System.out.println("Text changed");
        } else {
            System.out.println(((JButton) e.getSource()).getText() + " pressed." );
        }
    }

    public static void main(String[] args) {
        ButtonEventDemo demo = new ButtonEventDemo();
    }
}
