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

        printMatrix(matrixX, matrixY, subtractMatrix(matrixX, matrixY));
    }

    private static boolean randomInputs (Scanner scan){
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

    private static void fillMatrixRandom(double[][] matrix){
        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++){
                matrix[row][column] = Math.random()*100;
            }
        }
    }

    private static void fillMatrixManually(double[][] matrix, String nameOfMatrix){
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++){
                matrix[row][column] = SameLineInput.getDoubleValueOfDescription(sc, "Element der Matrix " + nameOfMatrix + " an Stelle row(n) = " + row + " und column(m) " + column);
            }
        }
    }

    private static double[][] subtractMatrix(double[][] matrixA, double[][] matrixB){
        double[][] resultMatrix = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++){
            System.arraycopy(matrixA[i], 0, resultMatrix[i], 0, matrixA[i].length);
        }

        for (int row = 0; row < resultMatrix.length; row++){
            for (int column = 0; column < resultMatrix[row].length; column++){
                resultMatrix[row][column] -= matrixB[row][column];
            }
            System.out.println();
        }

        return resultMatrix;
    }

    private static void printMatrix(double[][] matrixA, double[][] matrixB, double[][] matrixFinal){
        System.out.println("X:");
        PrintMatrix.printRectangleMatrix(matrixA);
        System.out.println("Y:");
        PrintMatrix.printRectangleMatrix(matrixB);
        System.out.println("X-Y:");
        PrintMatrix.printRectangleMatrix(matrixFinal);
    }
}
