package de.dhbwka.java.exercise.exam.jBay;

public class Gebot {
    private  double maxGebot;
    private Bieter maxBieter;

    public Gebot(double maxGebot, Bieter maxBieter) {
        this.maxGebot = maxGebot;
        this.maxBieter = maxBieter;
    }

    public double getMaxGebot() {
        return maxGebot;
    }

    public Bieter getMaxBieter() {
        return maxBieter;
    }
}