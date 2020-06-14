package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int[] arrayOfFibonaccis = new int[getNumberOfNumbers()];
        calculateFibonaccis(arrayOfFibonaccis);
        printFibonaccis(arrayOfFibonaccis);
    }
    
    public static int getNumberOfNumbers(){
        System.out.print("Bitte geben Sie die Anzahl der zu berechnenden Fibonacci-Zahlen ein: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.close();
        return number;
    }

    public static void calculateFibonaccis(int[] array){
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2];
        }
    }

    public static void printFibonaccis(int[] array){
        for (int element : array){
            System.out.println(element);
        }
    }


}
