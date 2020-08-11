package de.dhbwka.java.exercise.swing.scriptExamples;

import javax.swing.*;

public class WindowWithLabelAlternative2 extends JFrame {
    public WindowWithLabelAlternative2(){
        this.setTitle("Swing frame with label");
        this.add(new JLabel("            Hello!"));
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WindowWithLabelAlternative2();
    }
}
