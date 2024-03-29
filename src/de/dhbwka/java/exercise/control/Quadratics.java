package de.dhbwka.java.exercise.control;

import de.dhbwka.java.utilities.console.Console;

import java.util.Scanner;

public class Quadratics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = quadraticsGetVariableValue(scan, 'a');
        double b = quadraticsGetVariableValue(scan, 'b');
        double c = quadraticsGetVariableValue(scan, 'c');
        scan.close();

        solveQuadraticEquation(a, b, c);
    }

    public static double quadraticsGetVariableValue(Scanner scan, char variable){
        System.out.print("Bitte geben Sie den Wert von " + variable + " ein: ");
        return scan.nextDouble();
    }

    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            getXWithAIsZero(b, c);
        } else {
            getXWithAIsNotZero(a, b, c);
        }
    }

    public static void getXWithAIsZero(double b, double c) {
        if (b == 0) {
            System.out.println("Die Gleichung ist degeneriert.");
        } else {
            System.out.println("Die Nullstelle der Gleichung lautet " + Console.colorConsoleText("red") + (-c / b) + Console.colorConsoleText("default"));
        }
    }

    public static void getXWithAIsNotZero(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;
        if (discriminante < 0) {
            System.out.println("Die Lösung ist konjugiert komplex.");
        } else {
            System.out.println("Die Nullstellen der Gleichung lauten:");
            System.out.print(Console.colorConsoleText("red"));
            System.out.println("x1 = " + (-b + Math.sqrt(discriminante)) / (2 * a));
            System.out.println("x2 = " + (-b - Math.sqrt(discriminante)) / (2 * a));
            System.out.print(Console.colorConsoleText("default"));
        }
    }
}
