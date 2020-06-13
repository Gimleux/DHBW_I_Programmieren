package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Babylon {
    public static void main(String[] args) {
        double input = babylonInput();
        double sqrt = calculateBabylon(0, input, 1);
        System.out.printf("\nDie Wurzel aus %.3f ist %.3f.", input, sqrt);
    }

    public static int babylonInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen? ");
        int number = scan.nextInt();
        scan.close();
        return number;
    }

    public static double calculateBabylon(int i, double input, double xn) { //input = a
        printBabylon(i, xn);
        double xnPlus1 = (xn + (input / xn)) / 2.0;
        if (Math.abs(xnPlus1 - xn) < 10e-6) {
            return xn;
        } else {
            return calculateBabylon(++i, input, xnPlus1);
        }
    }

    public static void printBabylon(int i, double xnPlus1) {
        System.out.println("x" + i + ": " + xnPlus1);
    }
}
