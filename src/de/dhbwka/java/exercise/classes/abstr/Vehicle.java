package de.dhbwka.java.exercise.classes.abstr;

public abstract class Vehicle {
    protected int numberOfWheels = 0;
    protected int vMax = 0;
    protected double position = 0;
    protected double speed = 0; // km/h

    protected Vehicle() {
        this(4,100);
    }

    protected Vehicle(int numberOfWheels, int vMax) {
        this(numberOfWheels, vMax, 0);
    }

    protected Vehicle(int numberOfWheels, int vMax, double speed) {
        this.numberOfWheels = numberOfWheels;
        this.vMax = vMax;
        setSpeed(speed);
    }

    protected void drive(double minutes){
        position += minutes*(speed/60.0);
    }

    protected void setSpeed(double speed){
        this.speed = (speed>vMax? vMax : speed);
    }

    protected abstract void info();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " at" +
                " position " + position +
                " with " + numberOfWheels + " wheels" +
                " at speed " + speed + "km/h" +
                " of max. " + vMax + "km/h.";
    }
}
