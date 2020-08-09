package de.dhbwka.java.exercise.io.primesfile;

import de.dhbwka.java.utilities.console.Console;
import de.dhbwka.java.utilities.print.PrintArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrimesFile {
    /**
     * Contains primes - length = primesUpTo+1 - primes[0] = #primes
     */
    public static String PATH = "primes.txt";
    private int[] primes;
    private int max;

    public PrimesFile() {
    }

    public PrimesFile(int max) {
        generatePrimesFile(max);
    }

    public void getAreaOfNumbersUpTo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bis zu welcher Zahl sollen Primzahlen ermittelt werden? ");
        this.max = scan.nextInt() + 1;
        scan.close();
    }

    public void calcPrimesUpTo() {
        findPrimes(getArrayFilledWithNumbersUpTo());
    }

    public void printPrimesInFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            for (int i = 1; i < primes.length; i++) {
                if (primes[i] != 0) {
                    bw.write(Integer.toString(primes[i]));
                    bw.newLine();
                }
            }
            Console.printlnColoredText(primes[0] + " Primzahlen bis zur Zahl " + max + " in Datei " + PATH + " geschrieben.", "orange");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generatePrimesFile(int max){
        this.max = max;
        calcPrimesUpTo();
        printPrimesInFile();
    }

    private int[] getArrayFilledWithNumbersUpTo() {
        int[] array = new int[max];
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    private void findPrimes(int[] sieve) {
        primes = new int[sieve.length];
        boolean sieveIsNotEmpty;
        do {
            int min = getMinFromSortedArray(sieve);
            sieveIsNotEmpty = (min != 0);
            if (sieveIsNotEmpty) {
                primes[0]++;
                addNumberToArray(min);
                deleteMultipleOfNumberFromArray(sieve, min);
            }
        } while (sieveIsNotEmpty);
    }

    private int getMinFromSortedArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] != 0) {
                return array[i];
            }
        }
        return 0;
    }

    private void addNumberToArray(int number) {
        int i = 1;
        while (i < primes.length - 1 && primes[i] != 0) {
            i++;
        }
        primes[i] = number;
    }

    private void deleteMultipleOfNumberFromArray(int[] array, int number) {
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

    public int[] getPrimes() {
        int[] onlyPrimes = new int[primes.length - 1];
        if (primes.length - 1 >= 0) {
            System.arraycopy(primes, 1, onlyPrimes, 0, primes.length - 1);
        }
        return onlyPrimes;
    }

    public static void main(String[] args) {
        PrimesFile primesFile = new PrimesFile();
        primesFile.getAreaOfNumbersUpTo();
        primesFile.calcPrimesUpTo();
        int[] primes = primesFile.getPrimes();
        PrintArray.printArrayWithoutZeroInRowsWithTextBeforeAndTextBehind("", primes, "");
        primesFile.printPrimesInFile();
    }
}
