package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DancingText extends JFrame implements Runnable {
    DancingTextComponent dancingTextComponent;
    Thread runner;

    public DancingText() {
        this.setTitle("Dancing Text");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dancingTextComponent = new DancingTextComponent();
        this.add(dancingTextComponent);
        this.setVisible(true);
        this.runner = new Thread(this);
        runner.start();
    }


    @Override
    public void run() {
        System.out.println("running");
        int i = 20;
        boolean decrease = false;
        while (true) {
            try {
                dancingTextComponent.setFontSize(i);
                if (decrease) {
                    i--;
                } else {
                    i++;
                }
                if (i > 60) {
                    decrease = true;
                } else if (i < 20) {
                    decrease = false;
                }
                dancingTextComponent.repaint();
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DancingText();
    }
}

class DancingTextComponent extends JComponent {
    int fontSize = 20;

    @Override
    protected void paintComponent(Graphics g) {
        Random rand = new Random();
        float r = rand.nextFloat();
        float gr = rand.nextFloat();
        float b = rand.nextFloat();
        g.setColor(new Color(r, gr, b));
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.drawString("TEST", 25, 100);
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}