package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfEventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//mit Referenz auf Listener-Objekt der separaten Klasse das dann mehrfach nutzbar wäre

//^-- => Besonderheit bei dieser Umsetzung

public class WithReferenceToListenerObjectInSeparateClass_WhichCouldBeUsedMultipleTimes extends JFrame {
    ActionClass2 ac;
    //^--
    JButton button = new JButton("Click me!");

    public WithReferenceToListenerObjectInSeparateClass_WhichCouldBeUsedMultipleTimes(){
        this.add(button);

        //
        this.ac = new ActionClass2();
        button.addActionListener(this.ac);
        //^--

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200,150);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WithReferenceToListenerObjectInSeparateClass_WhichCouldBeUsedMultipleTimes();
    }
}

class ActionClass2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().beep();
    }
}
//^--
