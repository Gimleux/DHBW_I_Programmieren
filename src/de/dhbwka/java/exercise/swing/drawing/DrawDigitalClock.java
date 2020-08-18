package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DrawDigitalClock extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(new Font("Consolas", Font.BOLD, 24));
        Date date = new Date();
        g.drawString(date.toString(), 50,50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Date and Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new DrawDigitalClock());

        frame.setSize(500,120);
        frame.setVisible(true);
    }
}
