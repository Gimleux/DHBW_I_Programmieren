package de.dhbwka.java.utilities.Input;

import java.util.Scanner;

public class OneLineInput {
    /**
     * Print an inputRequest and get the input in the same line
     * @param scan Scanner object
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static int getIntValueOfDescription(Scanner scan, String bitte_description_eingeben){
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        return scan.nextInt();
    }

    /**
     * Print an inputRequest and get the input in the same line. Can only used once in the code as it closes the input stream!
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static int getIntValueOfDescriptionOneWay(String bitte_description_eingeben){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        int input = scan.nextInt();
        scan.close();
        return input;
    }

    /**
     * Print an inputRequest and get the input in the same line
     * @param scan Scanner object
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static double getDoubleValueOfDescription(Scanner scan, String bitte_description_eingeben){
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        return scan.nextDouble();
    }

    /**
     * Print an inputRequest and get the input in the same line. Can only used once in the code as it closes the input stream!
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static double getDoubleValueOfDescriptionOneWay(String bitte_description_eingeben){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        double input = scan.nextDouble();
        scan.close();
        return input;
    }

    /**
     * Print an inputRequest and get the input in the same line
     * @param scan Scanner object
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static String getStringValueOfDescription(Scanner scan, String bitte_description_eingeben){
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        return scan.next();
    }

    /**
     * Print an inputRequest and get the input in the same line. Can only used once in the code as it closes the input stream!
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static String getStringValueOfDescriptionOneWay(String bitte_description_eingeben){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        String input = scan.next();
        scan.close();
        return input;
    }

    /**
     * Print an inputRequest and get the input in the same line
     * @param scan Scanner object
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static String getStringLineValueOfDescription(Scanner scan, String bitte_description_eingeben){
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        return scan.nextLine();
    }

    /**
     * Print an inputRequest and get the input in the same line. Can only used once in the code as it closes the input stream!
     * @param bitte_description_eingeben Thing that is requested (replaces the "description" when used)
     * @return returns the requested value
     */
    public static String getStringLineValueOfDescriptionOneWay(String bitte_description_eingeben){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte " + bitte_description_eingeben + " eingeben: ");
        String input = scan.nextLine();
        scan.close();
        return input;
    }
}
