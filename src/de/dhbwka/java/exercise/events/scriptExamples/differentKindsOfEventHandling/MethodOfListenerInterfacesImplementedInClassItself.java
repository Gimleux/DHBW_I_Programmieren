package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfEventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Methode des Listener-Interfaces in der Klasse selbst implementiert

//^-- => Besonderheit bei dieser Umsetzung

public class MethodOfListenerInterfacesImplementedInClassItself extends JFrame
        implements ActionListener {
        //^--

    JButton button = new JButton("Click me!");

    public MethodOfListenerInterfacesImplementedInClassItself() {
        this.add(button);
        button.addActionListener(this);
        //^--
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200,150);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Toolkit.getDefaultToolkit().beep();
    }
    //^--

    public static void main(String[] args) {
        new MethodOfListenerInterfacesImplementedInClassItself();
    }
}
