package de.dhbwka.java.utilities.Input;

import java.util.Scanner;

public class SameLineInput {
    public static int getIntValueOfDescription(Scanner scan, String description){
        System.out.print("Bitte " + description + " eingeben: ");
        return scan.nextInt();
    }

    public static double getDoubleValueOfDescription(Scanner scan, String description){
        System.out.print("Bitte " + description + " eingeben: ");
        return scan.nextDouble();
    }

    public static String getStringValueOfDescription(Scanner scan, String description){
        System.out.print("Bitte " + description + " eingeben: ");
        return scan.next();
    }
}
