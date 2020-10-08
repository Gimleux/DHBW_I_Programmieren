package de.dhbwka.java.utilities.print;

import de.dhbwka.java.utilities.search.Biggest;

public class PrintMatrix {
    /**
     * Prints two dimensional Matrix/Array into the console -> matrix[row][column]
     * @param matrix array that shall be printed
     */
    public static void printRectangleMatrix (int[][] matrix){
        int biggest = Biggest.getBiggestDigitInMatrix(matrix);

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                System.out.printf("%" + (String.valueOf(biggest).length()+2) + "d", matrix[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * Prints two dimensional Matrix/Array into the console -> matrix[row][column] (prints only two decimals)
     * @param matrix array that shall be printed
     */
    public static void printRectangleMatrix (double[][] matrix){
        double biggest = Biggest.getBiggestDigitInMatrix(matrix);
        //Auf 2 Dezimalstellen fuer Laenge abschneiden
        biggest = Math.floor(biggest*100)/100;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                System.out.printf("%" + (String.valueOf(biggest).length()+2) + ".2f", matrix[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * Prints two dimensional Matrix/Array into the console -> matrix[row][column]
     * @param matrix array that shall be printed
     */
    public static void printRectangleMatrix (String[][] matrix){
        //TODO Format anpassen
        for (String[] strings : matrix) {
            for (int column = 0; column < strings.length; column++) {
                System.out.print(strings[column] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Prints two dimensional Matrix/Array into the console -> matrix[row][column]
     * @param matrix array that shall be printed
     * @param decimals how many decimals shall be printed
     */
    public static void printRectangleMatrix (double[][] matrix, int decimals){
        double biggest = Biggest.getBiggestDigitInMatrix(matrix);
        //Auf decimals Dezimalstellen fuer Laenge abschneiden
        biggest = Math.floor(biggest*(Math.pow(10, decimals)))/Math.pow(10, decimals);

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                System.out.printf("%" + (String.valueOf(biggest).length()+2) + "." + decimals + "f", matrix[row][column]);
            }
            System.out.println();
        }
    }
}
