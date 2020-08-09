package de.dhbwka.java.exercise.io;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.io.*;
import java.util.Scanner;

public class PalindromeFile {
    private String word;

    public void printTurnedAround() {
        System.out.println("Umgekehrt: " + turnAround(word));
    }

    public void saveInFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("palindrome.txt", true))) {
            if (isPalindrom(word)) {
                bw.write(word);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllPalindroms() {
        String path = "palindrome.txt";
        File palFile = new File(path);
        if (palFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                System.out.println("Alle bisher gefundenen Palindrome:");
                while (br.ready()) {
                    String line = br.readLine();
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printIsPalindrom() {
        System.out.println(word + " ist " + (isPalindrom(word) ? "" : "k") + "ein Palindrom.");
    }

    private String turnAround(String text) {
        StringBuilder help = new StringBuilder();
        return help.append(text).reverse().toString();
    }

    private boolean isPalindrom(String text) {
        return text.equalsIgnoreCase(turnAround(text));
    }

    public void getWord() {
        Scanner scan = new Scanner(System.in);
        setWord(OneLineInput.getStringValueOfDescription(scan, "Wort"));
    }

    public void setWord(String word) {
        this.word = word;
    }

    public static void main(String[] args) {
        PalindromeFile palindromeFile = new PalindromeFile();
        palindromeFile.getWord();
        palindromeFile.printTurnedAround();
        palindromeFile.printIsPalindrom();
        palindromeFile.saveInFile();
        palindromeFile.printAllPalindroms();
    }
}
