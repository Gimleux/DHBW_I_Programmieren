package de.dhbwka.java.exercise.classes.abstr;

public class Car extends Vehicle {

    public Car(){
        this(0);
    }

    @Override
    protected void info() {
        System.out.println(toString());
    }

    public Car(double speed) {
        this(140, speed);
    }

    public Car(int vMax, double speed){
        super(4,vMax, speed);
    }

}