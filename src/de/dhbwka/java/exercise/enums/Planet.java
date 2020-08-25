package de.dhbwka.java.exercise.enums;

public enum Planet { // Beachte: enum statt class

    MERCURY(3.303e+23, 2.4397e6), // Konstantendeklarationen mit Parametern
    VENUS(4.869e+24, 6.0518e6), // für den Konstruktor (Masse, Radius)
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7); // Nach der letzten Konstante

    public double mass; // Planetenmasse in Kilogramm
    private double radius; // Radius in Meter
    public static final double G = 6.67300E-11; // Gravitationskonstante

    Planet(double mass, double radius) { // Darf NICHT public sein!
        this.mass = mass;
        this.radius = radius;
    }

    double surfaceGravity() { // Gravitation an der Oberfläche eines Planeten
        return G * this.mass / (this.radius * this.radius);
    }

    double surfaceWeight(double otherMass) { // Gewicht an der Oberfläche
        return otherMass * this.surfaceGravity(); // eines anderen Planeten (N)
    }

}
