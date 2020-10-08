package de.dhbwka.java.exercise.exam.SoederMemory;

import java.awt.*;

public class Player {
    private String name;
    private int points;
    private PlayerStatus status;


    public Player(String name) {
        this.name = name;
        points=0;
        status=PlayerStatus.WAITING;
    }

    void addPoint(){
        points++;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    enum PlayerStatus{
        ACTIVE(Color.ORANGE),
        WAITING(Color.BLACK),
        FINISHED(Color.GRAY);

        Color color;
        PlayerStatus(Color c){
            color=c;
        }
    }
}