package de.dhbwka.java.exercise.swing.basics;

import javax.swing.*;

public class JOptionPaneDialogDemo {
    public static void main(String[] args) {
        //Message dialog
        JOptionPane.showMessageDialog(null, "May the force be with you!");

        //Input dialog
        String input = JOptionPane.showInputDialog(null, "Please enter a number");
        System.out.println("Input = " + input);

        //Confirm dialog
        int result = JOptionPane.showConfirmDialog(null, "Are you OK?");
        System.out.println("Result = " + result);

        //Select dialog
        String[] options = {"to be", "not to be", "don't know"};
        String selection = (String) JOptionPane.showInputDialog(null, "Hamlet", "To be or not to be?", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        //Customized option dialog
        String[] opts = {"Yes", "No", "Cancel"};
        int n = JOptionPane.showOptionDialog(null, "Yes or no?", "Yes/No/Cancel", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
        if (n == JOptionPane.YES_OPTION){
            System.out.println("Yes");
        };

        //default title and icon
        JOptionPane.showMessageDialog(null, "Eggs aren't supposed to be green.");

        //custom title, warning icon
        JOptionPane.showMessageDialog(null, "Eggs aren't supposed to be green.", "Warning", JOptionPane.WARNING_MESSAGE);

        //custom title, error icon
        JOptionPane.showMessageDialog(null, "Eggs aren't supposed to be green.", "A plain message", JOptionPane.ERROR_MESSAGE);

        //custom title, no icon
        JOptionPane.showMessageDialog(null, "Eggs aren't supposed to be green.", "Another plain message", JOptionPane.PLAIN_MESSAGE);
    }
}
