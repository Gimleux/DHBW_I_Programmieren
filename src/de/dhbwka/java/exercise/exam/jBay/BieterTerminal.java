package de.dhbwka.java.exercise.exam.jBay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class BieterTerminal implements Runnable {
    JFrame frame;
    JPanel panel=new JPanel(new BorderLayout(16,8));
    Bieter bieter; Auktionshaus ah;
    JTextField date;
    Thread runner;

    BieterTerminal(Bieter bieter, Auktionshaus ah){
        this.bieter = bieter;
        this.ah = ah;

        frame=new JFrame(bieter.getFullName());
        date= new JTextField(java.util.Calendar.getInstance().getTime().toString());
        panel.add(date,BorderLayout.NORTH);


        updateBT();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        runner=new Thread(this);
        runner.start();

    }


    void updateBT(){
        JPanel centerpanel=new JPanel(new GridLayout(ah.getAuktionen().size(),5));

        for (Auktion a:
                ah.getAuktionen()) {
            centerpanel.add(new TextField(a.getWare().getBeschreibung()));
            centerpanel.add(new TextField(Double.toString(a.getPrice())));
            System.out.println(Double.toString(a.getPrice()));
            try {
                System.out.println(a.getGebot().getMaxBieter().getFullName());
                centerpanel.add(new TextField(a.getGebot().getMaxBieter().getFullName()));
            }
            catch (Exception e){
                centerpanel.add(new TextField("--"));
            }

            centerpanel.add(new TextField(a.getEnd().getTime().toString()));
            JButton button = new JButton("Gebot abgeben");
            button.addActionListener((ActionListener) actionEvent -> {
                double value=0.0;
                try {
                    value = Double.valueOf((String)JOptionPane.showInputDialog("Please enter a number",a.getPrice()+Auktion.getIncrement()));

                }
                catch (Exception e) {}


                if ((a.getEnd().before(Calendar.getInstance()))){
                    JOptionPane.showMessageDialog(null,"zu spät");
                }
                else {
                    boolean result = a.gebotAbgeben(new Gebot(value,bieter),a);
                    if (result){
                        JOptionPane.showMessageDialog(null,"gebot abgegeben");

                    }
                    else   JOptionPane.showMessageDialog(null,"gebot nicht abgegeben, zu gering");
                    ah.updateTerminals();
                }
            });
            centerpanel.add(button);

        }
        System.out.println("add");
        try {
            panel.remove(1);
        }
        catch (Exception e){}

        panel.add(centerpanel);


        frame.revalidate();
        frame.repaint();



    }


    public  void run(){
        while (true){
            try {
                date.setText(java.util.Calendar.getInstance().getTime().toString());

                Thread.sleep(1000);
            }
            catch (Exception e){}

        }
    }
}