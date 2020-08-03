package de.dhbwka.java.exercise.arrays;

import de.dhbwka.java.utilities.Input.SameLineInput;
import de.dhbwka.java.utilities.print.PrintMatrix;

import java.util.Scanner;

public class MatrixSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfRows = SameLineInput.getIntValueOfDescription(scan, "Anzahl der Zeilen n");
        int numberOfColumns = SameLineInput.getIntValueOfDescription(scan, "Anzahl der Spalten");
        double[][] matrixX = new double[numberOfRows][numberOfColumns], matrixY = new double[numberOfRows][numberOfColumns];

        if (randomInputs(scan)){
            fillMatrixRandom(matrixX);
            fillMatrixRandom(matrixY);
        } else {
            fillMatrixManually(matrixX, "X");
            fillMatrixManually(matrixY, "Y");
        }

        subtractAndPrint(matrixX, matrixY);
    }

    public static boolean randomInputs (Scanner scan){
        while (true){
            System.out.println("Sollen die Matrizen zufällig (0) oder selbst belegt werden (1): ");
            int input = scan.nextInt();
            if (input == 1) {
                return false;
            } else if (input == 0) {
                return true;
            }
        }
    }

    public static void fillMatrixRandom(double[][] matrix){
        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++){
                matrix[row][column] = Math.random()*100;
            }
        }
    }

    public static void fillMatrixManually(double[][] matrix, String nameOfMatrix){
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++){
                matrix[row][column] = SameLineInput.getDoubleValueOfDescription(sc, "Element der Matrix " + nameOfMatrix + " an Stelle row(n) = " + row + " und column(m) " + column);
            }
        }
    }

    public static void subtractAndPrint(double[][] matrixA, double[][] matrixB){
        System.out.println("X:");
        PrintMatrix.printRectangleMatrix(matrixA);
        System.out.println("Y:");
        PrintMatrix.printRectangleMatrix(matrixB);
        System.out.println("X-Y:");
        for (int row = 0; row < matrixA.length; row++){
            for (int column = 0; column < matrixA[row].length; column++){
                //System.out.println(matrixA[row][column] + "-" + matrixB[row][column] + "=" + (matrixA[row][column] - matrixB[row][column]));
                System.out.printf("    %5.2f", matrixA[row][column] - matrixB[row][column]);
            }
            System.out.println();
        }
    }
}
