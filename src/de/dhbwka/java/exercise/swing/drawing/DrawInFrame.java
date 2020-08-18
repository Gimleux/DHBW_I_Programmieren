package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawInFrame extends JFrame implements MouseListener, MouseMotionListener {
    private int lastX, lastY;
    Graphics g;

    public DrawInFrame(){
        this.setTitle("Scribble");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.setSize(200,200);
        this.setVisible(true);
        this.g = this.getGraphics();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.lastX = e.getX();
        this.lastY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.g.drawLine(this.lastX, this.lastY, x, y);
        this.lastX = x;
        this.lastY = y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {
        new DrawInFrame();
    }
}
