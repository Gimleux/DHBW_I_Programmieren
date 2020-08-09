package de.dhbwka.java.exercise.io.primesfile;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrimesFileTest {

    private int number;

    public PrimesFileTest() {
        this.number = input();
    }

    public PrimesFileTest(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        boolean isPrime = false;
        try (BufferedReader br = new BufferedReader(new FileReader(PrimesFile.PATH));) {
            while (br.ready()) {
                int readNumber = Integer.parseInt(br.readLine());
                if (readNumber == number) {
                    isPrime = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isPrime;
    }

    public void printIsPrime() {
        File file =  new File(PrimesFile.PATH);
        if (file.exists()){
            System.out.println("Die Zahl " + number + " ist " + (isPrime() ? "" : "k") + "eine Primzahl.");
        } else {
            new PrimesFile(100000);
            if (file.exists()){
                System.out.println("Die Zahl " + number + " ist " + (isPrime() ? "" : "k") + "eine Primzahl.");
            } else System.out.println(PrimesFile.PATH + " nicht gefunden. Bitte führen Sie zuerst PrimesFile mit dem Parameter 100.000 aus!");
        }
    }

    private int input() {
        Scanner scan = new Scanner(System.in);
        int number;
        do {
            number = OneLineInput.getIntValueOfDescription(scan, "Zahl bis 100.000, die auf 'prim' zu prüfen ist");
        } while (number > 100000 || number < 0);
        return number;
    }

    public static void main(String[] args) {
        PrimesFileTest primesFileTest = new PrimesFileTest();
        primesFileTest.printIsPrime();
    }

}