package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car{

    boolean blueLightIsOn;

    public Ambulance(){
        this(0);
    }

    public Ambulance(double speed) {
        this(speed, false);
    }

    public Ambulance(double speed, boolean blueLightIsOn) {
        super(speed);
        this.blueLightIsOn = blueLightIsOn;
    }

    public void turnOnBlueLight(){
        this.blueLightIsOn = true;
    }

    public void turnOffBlueLight(){
        this.blueLightIsOn = false;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Signal " + (blueLightIsOn?"on":"off") + ".";
    }
}