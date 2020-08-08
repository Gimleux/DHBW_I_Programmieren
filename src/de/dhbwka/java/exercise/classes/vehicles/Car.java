package de.dhbwka.java.exercise.classes.vehicles;

public class Car extends Vehicle{

    public Car(){
        this(0);
    }

    public Car(double speed) {
        this(140, speed);
    }

    public Car(int vMax, double speed){
        super(4,vMax, speed);
    }

}