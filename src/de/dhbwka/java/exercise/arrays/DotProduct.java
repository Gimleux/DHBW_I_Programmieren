package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfVectors = getValueOfDescription(scan, "Anzahl der Vektoren");
        int numberOfElements = getValueOfDescription(scan, "Anzahl der Elemente");
        double[] arrayWithTermProducts = getTermProductsOfXVectors(scan, numberOfElements, numberOfVectors);
        System.out.println("Das Skalarprodukt der Vektoren ist " + getSumOfArray(arrayWithTermProducts));
    }

    public static double[] getTermProductsOfXVectors(Scanner scan, int numberOfElements, int numberOfVectors){
        double[] arrayWithScalarElements = initArray(numberOfElements);
        for (int vector = 0; vector < numberOfVectors; vector++) {
            for (int vectorElement = 0; vectorElement < numberOfElements; vectorElement++) {
                arrayWithScalarElements[vectorElement] *= getValueOfDescription(scan, (" Vektor " + (vector+1) + "_" + vectorElement));
            }
        }
        return arrayWithScalarElements;
    }

    public static double getSumOfArray(double[] array){
        double sum=0;
        for(double element:array){
            sum+=element;
        }
        return sum;
    }

    public static int getValueOfDescription(Scanner scan, String description){
        System.out.print("Bitte " + description + " eingeben: ");
        return scan.nextInt();
    }

    public static double[] initArray(int numberOfElements){
        double[] array = new double[numberOfElements];
        Arrays.fill(array, 1);
        return array;
    }
}
