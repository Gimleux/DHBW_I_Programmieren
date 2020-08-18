package de.dhbwka.java.exercise.events.scriptExamples.differentKindsOfGettingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetDataBy_Inheritance extends JFrame{
    private JButton button1 = new MyJButton("OK", 1);
    private JButton button2 = new MyJButton("OK", 2);
                                                      //^--
    public GetDataBy_Inheritance() {
        this.setLayout(new GridLayout(1,2));
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = ((MyJButton) e.getSource()).getMyNumber();
                //^--
                System.out.println(num);
            }
        };

        this.button1.addActionListener(listener);
        this.button2.addActionListener(listener);

        this.add(button1);
        this.add(button2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GetDataBy_Inheritance();
    }
}

class MyJButton extends JButton{
    private int myNumber;

    public MyJButton(String text, int myNumber){
        super(text);
        this.myNumber = myNumber;
    }

    public int getMyNumber(){
        return myNumber;
    }

    public void setMyNumber(int myNumber){
        this.myNumber = myNumber;
    }
}