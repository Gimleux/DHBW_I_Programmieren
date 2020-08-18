package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;
import java.awt.*;

public class DrawColoredOval extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        //The pink oval
        g.setColor(Color.PINK);
        g.fillOval(10,10,330,100);
        //The red border
        g.setColor(Color.RED);
        g.drawOval(10,10,330,100);
        g.drawOval(9,9,332,102);
        g.drawOval(8,8,334,104);
        g.drawOval(7,7,336,106);
        //The Text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Helvetica", Font.BOLD, 40));
        g.drawString("Hello World", 40,75);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Draw Colored Oval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new DrawColoredOval());

        frame.setSize(370,160);
        frame.setVisible(true);
    }
}
