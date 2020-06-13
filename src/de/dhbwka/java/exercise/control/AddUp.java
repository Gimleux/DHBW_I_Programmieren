package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUp {
    public static void main(String[] args) {
        int sum = addUpGetInput();
        System.out.println("Summe: " + sum);
    }

    public static int addUpGetInput() {
        Scanner scan = new Scanner(System.in);
        int number;
        int sum = 0;
        do {
            number = addUpOneInput(scan);
            sum += Math.max(number, 0);
        } while (number >= 0);
        scan.close();
        return sum;
    }

    public static int addUpOneInput(Scanner scan) {
        System.out.print("Zahl eingeben (<0 für Abbruch): ");
        return scan.nextInt();
    }
}
