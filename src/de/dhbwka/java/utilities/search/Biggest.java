package de.dhbwka.java.utilities.search;

public class Biggest {
    public static double getBiggestDigitInMatrix (double[][] matrix){
        double biggest = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                biggest = Math.max(Math.abs(matrix[row][column]), biggest);
            }
        }
        return biggest;
    }

    public static int getBiggestDigitInMatrix (int[][] matrix){
        int biggest = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                biggest = Math.max(Math.abs(matrix[row][column]), biggest);
            }
        }
        return biggest;
    }
}
