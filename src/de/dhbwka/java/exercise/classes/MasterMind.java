package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.utilities.Input.SameLineInput;
import de.dhbwka.java.utilities.console.Console;
import de.dhbwka.java.utilities.random.Random;

import java.util.Scanner;

public class MasterMind {
    private char[] letters;
    private String[] tries;
    private int rightPosition = 0;
    private int wrongPositionRightLetter = 0;
    private int timesTried = 1;
    private final int MAX_TRIES;

    public MasterMind() {
        this(20, 5);
    }

    public MasterMind(int max_tries, int positions) {
        MAX_TRIES = max_tries;
        letters = new char[positions];
        tries = new String[max_tries];
    }

    public void start() {
        initLetters();
        Console.printlnColoredText("'help' für bisherige Statistik\n", "orange");
        game();
    }

    private void initLetters() {
        for (int i = 0; i < letters.length; ++i) {
            letters[i] = (char) (Random.RandomIntIncMinIncMax(65, 72));
        }
    }

    private boolean wantsHelp(String tip) {
        if (tip.toLowerCase().equals("help")) {
            System.out.println(toString());
            return true;
        }
        return false;
    }

    private boolean charIsInLetters(char chr) {
        for (char element : letters) {
            if (chr == element) return true;
        }
        return false;
    }

    private int incIfCharIsInLetters(char chr, int number) {
        if (charIsInLetters(chr)) {
            return ++number;
        } else {
            return number;
        }
    }

    private String adapt(String tip){
        tip = tip.trim();
        if (tip.length() > letters.length) {
            tip = tip.substring(0, letters.length - 1);
        }
        return tip.toUpperCase();
    }

    private void verify(String tip) {
        rightPosition = 0;
        wrongPositionRightLetter = 0;

        for (int i = 0; i < tip.length(); ++i) {
            if (tip.charAt(i) == letters[i]) {
                rightPosition++;
            } else {
                wrongPositionRightLetter = incIfCharIsInLetters(tip.charAt(i), wrongPositionRightLetter);
            }
        }
    }

    private void addTipToTries(String tip) {
        int i = 0;
        while (i < tries.length && tries[i] != null) {
            ++i;
        }
        if (tries[i] != null) {
            Console.printlnColoredText("Fehler: Maximale Versuchsanzahl überschritten", "red");
            System.exit(418);
        }
        tries[i] = tip;
    }

    private boolean won() {
        return (rightPosition == letters.length);
    }

    private String getColor(char chr) {
        switch (Character.toLowerCase(chr)) {
            case 'a':
                return "green";
            case 'b':
                return "orange bright";
            case 'c':
                return "red";
            case 'd':
                return "blue";
            case 'e':
                return "gray";
            case 'f':
                return "white";
            case 'g':
                return "purple";
            case 'h':
                return "cyan";
            default:
                return "default";
        }
    }

    private void printColoredTry(String oneTry) {
        for (int i = 0; i < oneTry.length(); ++i) {
            char chr = oneTry.charAt(i);
            Console.printColoredText(chr, getColor(chr));
        }
    }

    private void printTries() {
        System.out.println(timesTried + " bisherige" + (timesTried == 0 ? "r" : "") + "Versuch" + (timesTried > 0 ? "e" : "") + ":");
        for (String triedString : tries) {
            if (triedString == null) {
                return;
            } else {
                printColoredTry(triedString);
                Console.printColoredText(" " + rightPosition, "green");
                Console.printlnColoredText(" " + wrongPositionRightLetter + "\n", "orange");
            }
        }
    }

    private boolean oneTry(Scanner scan) {
        String tip = SameLineInput.getStringValueOfDescription(scan, "Tipp");

        if (wantsHelp(tip)) {
            return false;
        }
        tip = adapt(tip);
        verify(tip);
        addTipToTries(tip);
        boolean won = won();
        if (won) {
            Console.printlnColoredText("Mit " + timesTried + " Versuchen gewonnen!", "green");
        } else {
            printTries();
        }
        return won;
    }

    private void game() {
        Scanner scan = new Scanner(System.in);
        boolean won;
        do {
            won = oneTry(scan);
        } while (!won && timesTried < MAX_TRIES);
    }

    @Override
    public String toString() {
        return "MasterMind\n" +
                "Versuche: " + timesTried +
                "/" + MAX_TRIES + "\n" +
                Console.colorConsoleText("green") + "Richtige Position: " + rightPosition + "\n" +
                Console.colorConsoleText("orange") + "Falsche Position, richtige Letter" + wrongPositionRightLetter +
                Console.colorConsoleText("default") + "\n";
    }

    public static void main(String[] args) {
        MasterMind game = new MasterMind();
        game.start();
    }

}
