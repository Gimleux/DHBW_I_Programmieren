package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TrafficLight extends JFrame implements Runnable {
    TrafficLightComponent trafficLightComponent;
    Thread runner;


    TrafficLight() {
        this.setTitle("Ampel");
        this.setSize(350, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trafficLightComponent = new TrafficLightComponent();
        add(trafficLightComponent);
        setVisible(true);
        this.runner = new Thread(this);
        runner.start();
    }


    @Override
    public void run() {
        Random random = new Random();
        int i = 0;

        while (true) {
            try {
                trafficLightComponent.setColors(trafficLightComponent.phases[i]);

                i++;
                if (i == 3) {
                    i = 0;
                }
                trafficLightComponent.repaint();
                Thread.sleep(random.nextInt(4) * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}

class TrafficLightComponent extends JComponent {

    Color[] colors = {Color.BLACK, Color.BLACK, Color.BLACK};
    public Color[][] phases = {{Color.red, Color.WHITE, Color.WHITE}, {Color.red, Color.YELLOW, Color.WHITE}, {Color.WHITE, Color.WHITE, Color.GREEN}, {Color.WHITE, Color.YELLOW, Color.WHITE}};

    @Override
    protected synchronized void paintComponent(Graphics g) {
        g.fillRect(100, 25, 150, 400);
        g.setColor(colors[0]);
        g.fillOval(125, 50, 100, 100);
        g.setColor(colors[1]);
        g.fillOval(125, 170, 100, 100);
        g.setColor(colors[2]);
        g.fillOval(125, 295, 100, 100);
    }

    public synchronized void setColors(Color[] colors) {
        this.colors = colors;
    }
}