package de.dhbwka.java.exercise.classes.abstr;

public class Bicycle extends Vehicle {

    public Bicycle(){
        this(0);
    }

    @Override
    protected void info() {
        System.out.println(toString());
    }

    public Bicycle(double speed) {
        super(2, 30, speed);
    }
}