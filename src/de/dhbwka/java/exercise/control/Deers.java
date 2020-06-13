package de.dhbwka.java.exercise.control;

public class Deers {
    public static void main(String[] args) {
        int deers = 200;
        int year = 0;
        do {
            printDeers(year, deers);
            year++;
            deers = (int) (deers * 1.1 - 15);
        } while (deers < 300);
        printDeers(year, deers);
    }

    public static void printDeers(int year, int deers) {
        System.out.printf("%3d: %3d %s %n", year, deers, "Hirsche");
    }
}
