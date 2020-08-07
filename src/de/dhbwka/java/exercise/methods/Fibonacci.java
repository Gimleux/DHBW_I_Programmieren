package de.dhbwka.java.exercise.methods;

import de.dhbwka.java.utilities.Input.OneLineInput;

public class Fibonacci {

    public static int calcFibonacci(int pos) {
        if (pos == 1 || pos == 2) {
            return 1;
        } else {
            return calcFibonacci(pos - 1) + calcFibonacci(pos - 2);
        }
    }

    public static void printFibonacci(int anz) {
        for (int i = 1; i <= anz; i++) {
            System.out.println("F(" + i + ") = " + calcFibonacci(i));
        }
    }

    public static void main(String[] args) {
        int anz;
        do {
            anz = OneLineInput.getIntValueOfDescriptionOneWay("Anzahl der zu berechnenden Fibonacci-Zahlen");
        } while (anz <= 0);
        printFibonacci(anz);
    }
}
