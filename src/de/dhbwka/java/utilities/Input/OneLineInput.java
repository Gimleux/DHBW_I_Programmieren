package de.dhbwka.java.utilities.Input;

import java.util.Scanner;

public class OneLineInput {
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
    public static String getStringLineValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.nextLine();
    }
}
