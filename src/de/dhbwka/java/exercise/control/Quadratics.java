package de.dhbwka.java.exercise.control;

import de.dhbwka.java.utilities.console.Console;

import java.util.Scanner;

public class Quadratics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben Sie den Wert von a ein: ");
        double a = scan.nextDouble();
        System.out.print("Bitte geben Sie den Wert von b ein: ");
        double b = scan.nextDouble();
        System.out.print("Bitte geben Sie den Wert von c ein: ");
        double c = scan.nextDouble();
        scan.close();

        solveQuadraticEquation(a, b, c);
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
            System.out.println("Die Nullstelle der Gleichung lautet " + Console.ColorConsoleText("red") + (-c / b) + Console.ColorConsoleText("default"));
        }
    }

    public static void getXWithAIsNotZero(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;
        if (discriminante < 0) {
            System.out.println("Die Lösung ist konjugiert komplex.");
        } else {
            System.out.println("Die Nullstellen der Gleichung lauten:");
            System.out.print(Console.ColorConsoleText("red"));
            System.out.println("x1 = " + (-b+Math.sqrt(discriminante))/(2*a));
            System.out.println("x2 = " + (-b-Math.sqrt(discriminante))/(2*a));
            System.out.print(Console.ColorConsoleText("default"));
        }
    }
}
