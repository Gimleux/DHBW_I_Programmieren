package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;

public class TrafficLightMuster extends JComponent implements Runnable {
    private final static long DELAY = 500;

    private LightPhase currentPhase;
    // Possible alternative: list of phases and current phase index
    // private List<LightPhase> phases = new ArrayList<>();
    // private int currentPhase = 0;

    public TrafficLightMuster() {
        // LightPhase stores successor, like an endless, round robin, linked list
        LightPhase redYellow = new LightPhase("Rotgelb", true, true, false, 1);
        LightPhase red = new LightPhase("Rot", true, false, false, 10, redYellow);
        LightPhase yellow = new LightPhase("Gelb", false, true, false, 2, red);
        LightPhase green = new LightPhase("Gr\u00FCn", false, false, true, 10, yellow);
        redYellow.setNext(green);
        this.currentPhase = green; // start with green
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.repaint();
                Thread.sleep(this.currentPhase.getDuration() * TrafficLightMuster.DELAY);
                // get next phase via getNext
                this.currentPhase = this.currentPhase.getNext();
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // traffic light box
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 80, 195);
        // 3 x empty light
        g.setColor(Color.WHITE);
        g.fillOval(23, 23, 54, 54);
        g.fillOval(23, 83, 54, 54);
        g.fillOval(23, 143, 54, 54);
        // draw colored lights, if active
        if (this.currentPhase.isRed()) {
            g.setColor(Color.RED);
            g.fillOval(25, 25, 50, 50);
        }
        if (this.currentPhase.isYellow()) {
            g.setColor(Color.YELLOW);
            g.fillOval(25, 85, 50, 50);
        }
        if (this.currentPhase.isGreen()) {
            g.setColor(Color.GREEN);
            g.fillOval(25, 145, 50, 50);
        }
    }

    public static void main(String[] args) {
        // Create frame and add TrafficLight component
        JFrame f = new JFrame("Traffic Light");
        f.add(new TrafficLightMuster());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(100, 260);
        f.setVisible(true);
    }
}

class LightPhase {
    private String name;
    private boolean red;
    private boolean yellow;
    private boolean green;
    private int duration;
    private LightPhase next;

    public LightPhase(String name, boolean red, boolean yellow, boolean green, int duration, LightPhase next) {
        this.name = name;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
        this.next = next;
    }

    public LightPhase(String name, boolean red, boolean yellow, boolean green, int duration) {
        this(name, red, yellow, green, duration, null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRed() {
        return this.red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isYellow() {
        return this.yellow;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public boolean isGreen() {
        return this.green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LightPhase getNext() {
        return this.next;
    }

    public void setNext(LightPhase next) {
        this.next = next;
    }
}
