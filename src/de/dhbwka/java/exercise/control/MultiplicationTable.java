package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        int magnitude = multiplicationTableInput();
        multiplicationTableOutput(magnitude);
    }

    public static int multiplicationTableInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie groß soll das Einmaleins ausgegeben werden?");
        int magnitude = scan.nextInt();
        scan.close();
        return  magnitude;
    }

    public static void multiplicationTableOutput(int magnitude){
        for (int column = 1; column<= magnitude; column++){
            for (int row = 1; row <= magnitude; row++){
                System.out.printf("%5d ", column*row);
            }
            System.out.println();
        }
    }
}
