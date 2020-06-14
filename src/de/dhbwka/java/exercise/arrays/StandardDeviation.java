package de.dhbwka.java.exercise.arrays;


import java.util.Scanner;

public class StandardDeviation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[getSizeOfArrayName(scan)];

        fillArray(array);
        double median = calculateMedianOfArray(array);
        double standardDeviation = calculateStandardDeviationOfArray(array, median);

        output(median, standardDeviation);
    }

    public static int getSizeOfArrayName(Scanner scan) {
        System.out.print("Bitte geben Sie die Anzahl der Einträge an: ");
        return scan.nextInt();
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            array[i] = (int) (Math.random() * 10);
        }
    }

    public static double calculateMedianOfArray(int[] array) {
        int sumOfElements = 0;
        for (int element : array) {
            sumOfElements += element;
        }
        return sumOfElements * (1. / array.length);
    }

    public static double calculateStandardDeviationOfArray(int[] array, double median) {
        int sumOfElementDeviation = 0;
        for (int element : array) {
            sumOfElementDeviation += Math.pow(element - median, 2);
        }
        return Math.sqrt(1. / (array.length - 1) * sumOfElementDeviation);
    }

    public static void output(double median, double standardDeviation) {
        System.out.println("Mittelwert: " + median);
        System.out.println("Standardabweichung: " + standardDeviation);
    }
}
