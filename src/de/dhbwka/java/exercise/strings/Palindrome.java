package de.dhbwka.java.exercise.strings;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.util.Scanner;

public class Palindrome {
    private String word;

    public void printTurnedAround(){
        System.out.println("Umgekehrt: " + turnAround(word));
    }

    public void printIsPalindrom(){
        System.out.println(word + " ist "+ (isPalindrom(word)?"":"k") + "ein Palindrom.");
    }

    private String turnAround(String text){
        StringBuilder help = new StringBuilder();
        return help.append(text).reverse().toString();
    }

    private boolean isPalindrom(String text){
        return text.equalsIgnoreCase(turnAround(text));
    }

    public void getWord(){
        Scanner scan = new Scanner(System.in);
        setWord(OneLineInput.getStringValueOfDescription(scan, "Wort"));
    }

    public void setWord(String word) {
        this.word = word;
    }

    public static void main(String[] args) {
        Palindrome palindrom = new Palindrome();
        palindrom.getWord();
        palindrom.printTurnedAround();
        palindrom.printIsPalindrom();
    }
}
