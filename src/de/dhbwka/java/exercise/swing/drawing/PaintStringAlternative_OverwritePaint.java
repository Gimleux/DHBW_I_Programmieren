package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;
import java.awt.*;

public class
PaintStringAlternative_OverwritePaint extends JFrame {
    public PaintStringAlternative_OverwritePaint(){
        this.setTitle("First Paint Overwrite Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setVisible(true);
    }

    //Zeichnen direkt in JFrame (Nicht in hinzugefügte Komponente)
    //daher direktes Überschreiben der Methoe paint
    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,this.getWidth(), this.getHeight());
        g.drawString("Hello World",25,50);
    }

    public static void main(String[] args) {
        new PaintStringAlternative_OverwritePaint();
    }
}