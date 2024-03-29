package de.dhbwka.java.exercise.swing.basics;

import javax.swing.*;

public class JPanelWithButtons {
    public JPanelWithButtons(){
        JFrame frame = new JFrame();
        JPanel jp = new JPanel();
        for(int i = 1; i<=3; i++){
            jp.add(new JButton("Button " + i));
        }
        frame.add(jp);
        frame.setTitle("Frame with multiple buttons");
        frame.setSize(350,100);
        frame. setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JPanelWithButtons();
    }
}
