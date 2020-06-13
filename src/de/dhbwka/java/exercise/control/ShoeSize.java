package de.dhbwka.java.exercise.control;

public class ShoeSize {
    public static void main(String[] args) {
        printShoeSizeTable();
    }

    public static void printShoeSizeTable() {
        System.out.printf("%14s|%6s%n", "Zentimeter ", "Größe");
        System.out.println("--------------|------");
        double oldCentimeters = getCentimetersFromShoeSize(29);
        double newCentimeters;
        for (int i = 30; i < 50; i++) {
            newCentimeters = getCentimetersFromShoeSize(i);
            System.out.printf("%4.2f - %4.2f |%6d\n", oldCentimeters, newCentimeters, i);
            oldCentimeters = newCentimeters;
        }
    }

    public static double getCentimetersFromShoeSize(int size) {
        return size / 1.5;
    }
}
