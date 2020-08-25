package de.dhbwka.java.exercise.enums;

public class SimpleColorExample {
    public static void main(String[] args) {

        // Farbe aufgrund ihres Wertes bestimmen
        SimpleColor col = SimpleColor.valueOf("BLACK");
        System.out.println("Color: " + col);

        // Nummern (Reihenfolge, Zählung beginnt bei 0) bestimmten
        System.out.println("#" + col + ": " + col.ordinal());
        System.out.println("#" + SimpleColor.RED + ": " + SimpleColor.RED.ordinal());
        System.out.println("#" + SimpleColor.BLUE + ": " + SimpleColor.BLUE.ordinal());
    }
}
