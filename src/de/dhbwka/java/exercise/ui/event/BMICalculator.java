package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame implements ActionListener {
    JTextField tf_weight = new JTextField(10);
    JTextField tf_height = new JTextField(10);
    JRadioButton rb_male = new JRadioButton("male", true);
    JRadioButton rb_female = new JRadioButton("female", false);
    JTextField tf_bmi = new JTextField(15);
    JTextField tf_result = new JTextField(20);

    public BMICalculator() throws HeadlessException {
        this.setTitle("BMI Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(getFrameContent());

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double weight = Double.parseDouble(tf_weight.getText());
            double height = Double.parseDouble(tf_height.getText());
            boolean isFemale = rb_female.isSelected();

            double bmi = getBMI(weight, height);
            tf_bmi.setText(Double.toString(bmi));
            tf_result.setText(getResult(bmi, isFemale));
        } catch (Exception exc) {
            tf_bmi.setText("Please set weight and height");
        }
    }

    private JPanel getFrameContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel weightPanel = new JPanel();
        weightPanel.add(new JLabel("Weight [kg]:"));
        weightPanel.add(tf_weight);
        panel.add(weightPanel);

        JPanel heightPanel = new JPanel();
        heightPanel.add(new JLabel("Body height [m]:"));
        heightPanel.add(tf_height);
        panel.add(heightPanel);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rb_male);
        buttonGroup.add(rb_female);
        panel.add(rb_male);
        panel.add(rb_female);

        JButton button = new JButton("Calculate");
        button.addActionListener(this);
        panel.add(button);

        JPanel bmiPanel = new JPanel();
        bmiPanel.add(new JLabel("BMI:"));
        bmiPanel.add(tf_bmi);
        panel.add(bmiPanel);

        panel.add(tf_result);

        return panel;
    }

    private double getBMI(double weight, double height) {
        return weight / (Math.pow(height, 2));
    }

    private String getResult(double bmi, boolean isFemale) {
        String result;
        if (isFemale) {
            if (bmi < 19) {
                result = "Short weight";
            } else if (bmi < 24) {
                result = "Normal weight";
            } else if (bmi < 30) {
                result = "Overweight";
            } else if (bmi < 40) {
                result = "Adiposity";
            } else {
                result = "Massive Adiposity";
            }
        } else {
            if (bmi < 20) {
                result = "Short weight";
            } else if (bmi < 25) {
                result = "Normal weight";
            } else if (bmi < 30) {
                result = "Overweight";
            } else if (bmi < 40) {
                result = "Adiposity";
            } else {
                result = "Massive Adiposity";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}