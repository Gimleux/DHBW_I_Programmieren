package de.dhbwka.java.exercise.arrays;

import de.dhbwka.java.utilities.print.PrintArray;

import java.util.Scanner;

public class Erastostenes {
    public static void main(String[] args) {
        int[] sieve = getArrayFilledWithNumbersUpTo(getAreaOfNumbersUpTo());
        int[] primes = findPrimes(sieve);
        PrintArray.printArrayWithoutZeroInRowsWithTextBeforeAndTextBehind("", primes, "");
    }

    public static int getAreaOfNumbersUpTo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bis zu welcher Zahl sollen Primzahlen ermittelt werden? ");
        int max = scan.nextInt() + 1;
        scan.close();
        return max;
    }

    public static int[] getArrayFilledWithNumbersUpTo(int max) {
        int[] array = new int[max];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] findPrimes(int[] sieve) {
        int[] primes = new int[sieve.length];
        boolean sieveIsNotEmpty;
        do {
            int min = getMinFromSortedArray(sieve);
            sieveIsNotEmpty = (min != 0);
            if (sieveIsNotEmpty) {
                addNumberToArray(primes, min);
                deleteMultipleOfNumberFromArray(sieve, min);
            }
        } while (sieveIsNotEmpty);
        return primes;
    }

    public static int getMinFromSortedArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] != 0) {
                return array[i];
            }
        }
        return 0;
    }

    public static void addNumberToArray(int[] array, int number) {
        int i = 1;
        while (i < array.length - 1 && array[i] != 0) {
            i++;
        }
        array[i] = number;
    }

    public static void deleteMultipleOfNumberFromArray(int[] array, int number) {
        if (number == 1) {
            array[1] = 0;
        } else {
            int i = 1;
            while (i * number <= array.length - 1) {
                array[i * number] = 0;
                i++;
            }
        }
    }
}
