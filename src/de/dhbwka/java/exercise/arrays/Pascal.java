package de.dhbwka.java.exercise.arrays;

import de.dhbwka.java.utilities.Input.SameLineInput;
import de.dhbwka.java.utilities.print.PrintMatrix;

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] pascal = new int[SameLineInput.getIntValueOfDescription(scan, "Anzahl der Zeilen")][];
        scan.close();

        initPascal(pascal);
        fillPascal(pascal);
        PrintMatrix.printRectangleMatrix(pascal);
    }

    public static void initPascal(int[][] array){
        for (int i = 0; i < array.length; i++){
            array[i] = new int[i+1];
        }
    }

    public static void fillPascal(int[][] array){
        for (int i = 0; i < array.length; i++){
            array[i][0] = 1;
        }
        for (int row = 1; row < array.length; row++){
            for (int column = 1; column < array[row].length; column++){
                if (column+1 < array[row].length){
                    array[row][column] = array[row-1][column-1] + array[row-1][column];
                } else {
                    array[row][column] = 1;
                }
            }
        }
    }
}
