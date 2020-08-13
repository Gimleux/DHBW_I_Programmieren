package de.dhbwka.java.exercise.classes.abstr;

public class RacingCar extends Car {

    public RacingCar(){
        this(0);
    }

    public RacingCar(double speed) {
        super(220, speed);
    }
}