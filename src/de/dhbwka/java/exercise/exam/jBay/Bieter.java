package de.dhbwka.java.exercise.exam.jBay;

public class Bieter {
    private String prename;
    private String name;

    public Bieter(String prename, String name) {
        this.prename = prename;
        this.name = name;
    }

    public String getFullName() {
        return prename + " "+ name;
    }
}