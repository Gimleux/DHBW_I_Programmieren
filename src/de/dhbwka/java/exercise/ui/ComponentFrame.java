package de.dhbwka.java.exercise.ui;

import de.dhbwka.java.exercise.classes.Radio;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame extends JFrame {
    public ComponentFrame(String title) {
        super(title);
        //FlowLayout bricht nach Zeilenende um anstatt zu überschreiben
        this.setLayout(new FlowLayout());

        this.add(new JLabel("JLabel"));
        this.add(new JTextField("JText Field"));
        this.add(new JPasswordField("JPasswordField"));
        this.add(new JButton("JButton"));
        this.add(new JToggleButton("JToggleButton"));
        this.add(new JCheckBox("JCheckBox"));
        this.add(new JComboBox(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 1; i<=3; i++){
            JRadioButton radioButton = new JRadioButton("Radio-Button-" + i);
            buttonGroup.add(radioButton);
            this.add(radioButton);
        }

        this.setSize(640, 100);
        //this.pack(); Alternative zu setSize -> Groesse passend zu Komponenten in Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentFrame("Some UI Example");
    }
}
