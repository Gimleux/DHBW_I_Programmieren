package de.dhbwka.java.exercise.arrays;

import de.dhbwka.java.utilities.Input.SameLineInput;
import de.dhbwka.java.utilities.print.PrintArray;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfElements = SameLineInput.getIntValueOfDescription(scan, "Anzahl der Elemente");
        double[] arrayWithElements = getArray(scan, numberOfElements);
        bubbleSort(arrayWithElements);
        PrintArray.printArrayInColumnsWithDelimiter(arrayWithElements, " ");
    }

    public static double[] getArray(Scanner scan, int numberOfElements) {
        double[] array = new double[numberOfElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = SameLineInput.getDoubleValueOfDescription(scan, "Zahl " + i);
        }
        return array;
    }

    public static void bubbleSort(double[] array) {
        if (array.length > 1) {
            boolean notSorted;
            int i = 0;
            do {
                notSorted = sort(array, i);
                if (notSorted){
                    i++;
                }
            } while (notSorted);
        }
    }

    public static boolean sort(double[] array, int numberOfDoneIterations){
        boolean notSorted = false;
        for (int i = 0; i < array.length-1-numberOfDoneIterations; i++) {
            if (array[i]>array[i+1]) {
                double help = array[i+1];
                array[i+1] = array[i];
                array[i] = help;
                notSorted = true;
            }
        }
        return notSorted;
    }
}