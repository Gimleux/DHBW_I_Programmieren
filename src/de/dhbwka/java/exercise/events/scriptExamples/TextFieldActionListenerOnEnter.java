package de.dhbwka.java.exercise.events.scriptExamples;

import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JTextField;
        import javax.swing.JOptionPane;
        import java.awt.FlowLayout;
        import java.awt.event.ActionListener;
        import java.awt.event.ActionEvent;

//ActionEvent on Enter

public class TextFieldActionListenerOnEnter {
    public static void main(String[] args) {
        new Frame();
    }
}

class Frame extends JFrame implements ActionListener{

    private JTextField jt1,jt2,jt3;

    Frame()
    {
        setTitle("JTextField");
        setLayout(new FlowLayout());
        setJTextFields();
        setAction();
        setSize(700, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setJTextFields()
    {
        JLabel     jl1 = new JLabel("JTextField01");
        add(jl1);
        jt1 = new JTextField(10);
        add(jt1);
        JLabel     jl2 = new JLabel("JTextField02");
        add(jl2);
        jt2 = new JTextField("Hajsof",10);
        add(jt2);
        JLabel     jl3 = new JLabel("JTextField03");
        add(jl3);
        jt3 = new JTextField("Saravan",10);
        jt3.setEditable(false);
        add(jt3);
    }

    private void setAction()
    {
        jt1.addActionListener(this);
        jt2.addActionListener(this);
        jt3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent eve)
    {
        JOptionPane.showMessageDialog(rootPane, eve.getActionCommand());
    }
}