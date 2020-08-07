package de.dhbwka.java.utilities.Input;

import java.util.Scanner;

public class OneLineInput {
    public static int getIntValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.nextInt();
    }

    public static int getIntValueOfDescriptionOneWay(String bitte_description_eingebenn){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        int input = scan.nextInt();
        scan.close();
        return input;
    }

    public static double getDoubleValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.nextDouble();
    }

    public static double getDoubleValueOfDescriptionOneWay(String bitte_description_eingebenn){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        double input = scan.nextDouble();
        scan.close();
        return input;
    }

    public static String getStringValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.next();
    }

    public static String getStringValueOfDescriptionOneWay(String bitte_description_eingebenn){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        String input = scan.next();
        scan.close();
        return input;
    }

    public static String getStringLineValueOfDescription(Scanner scan, String bitte_description_eingebenn){
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        return scan.nextLine();
    }

    public static String getStringLineValueOfDescriptionOneWay(String bitte_description_eingebenn){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingebenn + " eingeben: ");
        String input = scan.nextLine();
        scan.close();
        return input;
    }
}
