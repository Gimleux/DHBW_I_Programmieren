package de.dhbwka.java.utilities.print;

public class PrintMatrix {
    public static void printRectangleMatrix (int[][] matrix){
        for (int row = 0; row <= matrix.length; row++) {
            for (int column = 0; column <= matrix[row].length; column++){
                System.out.printf("%5.2d", matrix[row][column]);
            }
            System.out.println();
        }
    }

    public static void printRectangleMatrix (double[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                System.out.printf("   %5.2f", matrix[row][column]);
            }
            System.out.println();
        }
    }
}
