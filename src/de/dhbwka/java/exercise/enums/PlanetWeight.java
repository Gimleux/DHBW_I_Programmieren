package de.dhbwka.java.exercise.enums;

public class PlanetWeight {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java PlanetWeight <weight>");
            System.exit(-1);
        }

        // Gewicht an Erdoberfläche in Newton
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();

        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f%n",p, p.surfaceWeight(mass));
        }
    }
}
