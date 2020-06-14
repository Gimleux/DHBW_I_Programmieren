package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Norm {
    public static void main(String[] args) {
        double[] vectorArray = getVectorArray();
        double norm = getAbsoluteValueOfVector(vectorArray);
        System.out.println("Der Betrag von x ist " + norm);
    }

    public static double[] getVectorArray(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        double[] vectorArray = new double[scan.nextInt()];
        for (int i = 0; i < vectorArray.length; i++) {
            System.out.print("Bitte x_" + i + " eingeben: ");
            vectorArray[i] = scan.nextDouble();
        }
        scan.close();
        return  vectorArray;
    }
    
    public static double getAbsoluteValueOfVector(double[] vectorArray){
        double sum = 0;
        for (double element : vectorArray){
            sum+=element*element;
        }
        return Math.sqrt(sum);
    }

    /*
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int number = scan.nextInt();
        double absoluteValue = getElementsToPowerOfTwo(scan, number);
        scan.close();
        System.out.println("Der Betrag von x ist " + Math.sqrt(absoluteValue));
    }

    public static double getElementsToPowerOfTwo(Scanner scan, int number){
        double absoluteValue = 0;
        for (int i = 0; i < number; i++) {
            System.out.print("Bitte x_" + i + " eingeben: ");
            absoluteValue += Math.pow(scan.nextDouble(),2);
        }
        return absoluteValue;
    }
     */
}
