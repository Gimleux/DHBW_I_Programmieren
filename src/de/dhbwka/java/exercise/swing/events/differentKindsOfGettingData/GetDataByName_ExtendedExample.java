package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfGettingData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetDataByName_ExtendedExample {
    public GetDataByName_ExtendedExample(){
        JFrame frame = new JFrame();
        JPanel jp = new JPanel();
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonName = ((JButton) e.getSource()).getName();
                System.out.println(buttonName);
            }
        };
        for (int i = 1; i <= 3; i++){
            final JButton button = new JButton("Button");
            jp.add(button);
            button.setName("#" + i);
            button.addActionListener(listener);
        }
        frame.add(jp);
        frame.setTitle("Frame with buttons");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GetDataByName_ExtendedExample();
    }
}
