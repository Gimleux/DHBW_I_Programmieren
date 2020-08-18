package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfEventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Umsetzung in separater Klasse

//^-- => Besonderheit bei dieser Umsetzung

public class InSeparateClasse extends JFrame {
    JButton button = new JButton("Click me!");

    public InSeparateClasse(){
        this.add(button);

        button.addActionListener(new ActionClass());
        //^--

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200,150);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new InSeparateClasse();
    }
}

class ActionClass implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        Toolkit.getDefaultToolkit().beep();
    }
}
//^--
