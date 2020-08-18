package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;

public class PaintStringAlternative_InSecondClass extends JFrame {
    public PaintStringAlternative_InSecondClass(){
        this.setTitle("First Paint Alternative");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new PaintStringAlternative_InSecondClass_DrawComponent());
        this.setSize(300,200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PaintStringAlternative_InSecondClass();
    }
}
