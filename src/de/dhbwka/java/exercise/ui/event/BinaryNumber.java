package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryNumber extends JFrame implements ActionListener {
    private final int NUMBER_Of_BITS = 8;
    private int value = 0;
    private final JLabel resultLabel = new JLabel(Integer.toString(value));

    public BinaryNumber() {
        this.setTitle("Binary Number");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(getButtonContainer());
        this.add(getResultContainer(), BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton src = (JToggleButton) e.getSource();
        int buttonValue = Integer.parseInt(src.getName());
        if(src.isSelected()){
            this.value += buttonValue;
        } else {
            this.value -= buttonValue;
        }
        resultLabel.setText(Integer.toString(this.value));
    }

    private JPanel getButtonContainer() {
        ImageIcon imgOff = new ImageIcon("23_Events_Aufgaben-1_Icons/off.png");
        ImageIcon imgOn = new ImageIcon("23_Events_Aufgaben-1_Icons/on.png");

        JPanel toggleButtonsPanel = new JPanel(new GridLayout(2,NUMBER_Of_BITS, 5,5));
        //Buttons
        for (int i = NUMBER_Of_BITS-1; i >= 0; i--) {
            JToggleButton toggleButton = new JToggleButton();
            toggleButton.setIcon(imgOff);
            toggleButton.setSelectedIcon(imgOn);
            toggleButton.setName(Integer.toString((int)Math.pow(2,i)));
            toggleButton.addActionListener(this);

            toggleButtonsPanel.add(toggleButton);

        }
        //Zeilenumbruch durch Spaltenangabe bei GridLayout
        for (int i = NUMBER_Of_BITS-1; i>=0; i--){
            toggleButtonsPanel.add(new JLabel("2^" + i, SwingConstants.CENTER));
        }
        return toggleButtonsPanel;
    }

    private JPanel getResultContainer(){
        JPanel resultPanel = new JPanel();
        resultLabel.setFont(resultLabel.getFont().deriveFont(24f));
        resultPanel.add(resultLabel);
        return resultPanel;
    }

    public static void main(String[] args) {
        new BinaryNumber();
    }
}