package de.dhbwka.java.utilities.Input;

import java.util.Scanner;

public class SameLineInput {
    public static int getIntValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.nextInt();
    }

    public static double getDoubleValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.nextDouble();
    }

    public static String getStringValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.next();
    }
}
