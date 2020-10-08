package de.dhbwka.java.exercise.exam.StadtLandFluss;

public class Player {
    private String name;
    private int points=0;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}