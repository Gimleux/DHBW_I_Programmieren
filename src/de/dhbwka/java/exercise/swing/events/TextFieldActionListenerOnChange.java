package de.dhbwka.java.exercise.events.scriptExamples;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ActionEvent on Change
//Sollte vermieden werden, da schwierig an Auslöser zu kommen

//Unten kleine Vereinfachung

public class TextFieldActionListenerOnChange {
    public static void main(String[] args) {
        new Frame2();
    }
}

class Frame2 extends JFrame implements DocumentListener {

    private JTextField jt1, jt2, jt3;

    Frame2() {
        setTitle("JTextField");
        setLayout(new FlowLayout());
        setJTextFields();
        setAction();
        setSize(700, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setJTextFields() {
        JLabel jl1 = new JLabel("JTextField01");
        add(jl1);
        jt1 = new JTextField(10);
        add(jt1);
        JLabel jl2 = new JLabel("JTextField02");
        add(jl2);
        jt2 = new JTextField("Hajsof", 10);
        add(jt2);
        JLabel jl3 = new JLabel("JTextField03");
        add(jl3);
        jt3 = new JTextField("Saravan", 10);
        jt3.setEditable(false);
        add(jt3);
    }

    private void setAction() {
        jt1.getDocument().addDocumentListener(this);
        jt2.getDocument().addDocumentListener(this);
        jt3.getDocument().addDocumentListener(this);
    }

    public void actionPerformed(ActionEvent eve) {
        JOptionPane.showMessageDialog(rootPane, eve.getActionCommand());
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        JOptionPane.showMessageDialog(rootPane, e.toString());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        JOptionPane.showMessageDialog(rootPane, e.getDocument());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        JOptionPane.showMessageDialog(rootPane, e.getDocument());
    }
}

///////////////////////////////////////////////////////////////////////////
// Vereinfachung using interface
///////////////////////////////////////////////////////////////////////////
class ExampleWithInterface extends JFrame {
    JTextField textField = new JTextField();

    public ExampleWithInterface() throws HeadlessException {
        textField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                // Your code here
            }
        });
    }

    @FunctionalInterface
    public interface SimpleDocumentListener extends DocumentListener {
        void update(DocumentEvent e);

        @Override
        default void insertUpdate(DocumentEvent e) {
            update(e);
        }

        @Override
        default void removeUpdate(DocumentEvent e) {
            update(e);
        }

        @Override
        default void changedUpdate(DocumentEvent e) {
            update(e);
        }
    }
}