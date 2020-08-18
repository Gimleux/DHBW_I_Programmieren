package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;
import java.awt.*;

public class DrawShapes extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawRect(30,30,80,40);
        g.drawOval(120,30,50,50);
        g.setColor(Color.BLACK);
        g.fillRect(30,100,80,40);
        g.fillOval(120,100,50,50);
        g.drawLine(30,160,130,170);
        g.drawArc(30,180,50,50,60,40);
        g.fillArc(120,180,50,50,60,40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Draw Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new DrawShapes());

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
