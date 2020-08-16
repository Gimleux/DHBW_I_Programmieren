package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playAgain;
        do {
            playOneRound(scan);
            playAgain = wannaPlayAgain(scan);
        } while (playAgain);
    }

    public static void playOneRound(Scanner scan){
        int numberOfAttempts = 1;
        int number = (int) (Math.random() * 100 + 1);
        int min = 1, max = 100;
        int guess;
        String name = getPlayersName(scan);

        do {
            guess = guessANumber(scan, name, min, max);
            System.out.printf("Versuch %d: %d ist ", numberOfAttempts, guess);
            if (guess > number) {
                System.out.println("zu hoch.");
                max = Math.min(max, guess-1);
            } else if (guess < number) {
                System.out.println("zu niedrig.");
                min = Math.max(min, guess+1);
            } else {
                System.out.println("korrekt.");
                break;
            }
            numberOfAttempts++;
        } while (true);
    }

    public static String getPlayersName(Scanner scan) {
        System.out.print("Wie ist dein Name? ");
        return scan.next();
    }

    public static int guessANumber(Scanner scan, String name, int min, int max) {
        System.out.print(name + ", rate eine Zahl [" + min + "-" + max + "]: ");
        return scan.nextInt();
    }

    public static boolean wannaPlayAgain(Scanner scan){
        do {
            System.out.println("\nWas möchtest du tun?");
            System.out.println("0 - Das Spiel beenden");
            System.out.println("1 - Das Spiel fortsetzen");
            int input = scan.nextInt();
            switch (input){
                case 1: {
                    System.out.println("\n----------------------------\n");
                    return true;
                }
                case 0: return false;
            }
        } while (true);
    }
}
