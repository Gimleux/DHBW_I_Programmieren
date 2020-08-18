package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;
import java.awt.*;

public class PaintString extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hello World", 25,50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("First Painting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new PaintString());

        frame.setSize(300,200);
        frame.setVisible(true);
    }
}
