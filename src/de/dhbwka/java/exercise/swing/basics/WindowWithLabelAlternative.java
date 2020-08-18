package de.dhbwka.java.exercise.swing.scriptExamples;

import javax.swing.*;

public class WindowWithLabelAlternative {
    JFrame frame;

    public WindowWithLabelAlternative(){
        this.frame = new JFrame();
        this.frame.setTitle("Swing frame with label");
        this.frame.add(new JLabel("            Hello!"));
        this.frame.setSize(300, 150);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WindowWithLabelAlternative();
    }
}
