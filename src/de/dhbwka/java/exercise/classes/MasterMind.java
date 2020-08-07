package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.utilities.Input.OneLineInput;
import de.dhbwka.java.utilities.console.Console;
import de.dhbwka.java.utilities.random.Random;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
    private char[] letters;
    //      [rightPosition][wrongPositionRightLetter]
    private int[][] triesPositions;
    private String[] tries;
    private boolean[] checkedCharsInTip;
    private int rightPosition = 0;
    private int wrongPositionRightLetter = 0;
    private int timesTried = 0;
    private final int MAX_TRIES;

    public MasterMind() {
        this(20, 5);
    }

    public MasterMind(int max_tries, int positions) {
        MAX_TRIES = max_tries;
        letters = new char[positions];
        tries = new String[max_tries];
        triesPositions = new int[2][max_tries];
        checkedCharsInTip = new boolean[positions];
    }

    public void start() {
        initLetters();
        System.out.println(Console.colorConsoleTextAndBackground("white bright", "red") + "MasterMind" + Console.colorConsoleTextAndBackground("default", "default"));
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

    private boolean charIsInLetters(String tip, int position) {
        for (int i = 0; i < letters.length; ++i) {
            // nicht bereits betrachtet && zu pruefender Char steht in letters && stelle an der er in letters steht ist nicht schon richtiger char zugeordnet
            if (!checkedCharsInTip[i] && tip.charAt(position) == letters[i] && tip.charAt(i) != letters[i]) {
                checkedCharsInTip[i] = true;
                return true;
            }
        }
        return false;
    }

    private int incIfCharIsInLetters(String tip, int position, int number) {
        if (charIsInLetters(tip, position)) {
            return ++number;
        } else {
            return number;
        }
    }

    private String adapt(String tip) {
        tip = tip.trim();
        if (tip.length() > letters.length) {
            tip = tip.substring(0, letters.length);
        }
        return tip.toUpperCase();
    }

    private void verify(String tip) {
        rightPosition = 0;
        wrongPositionRightLetter = 0;
        Arrays.fill(checkedCharsInTip, false);

        for (int i = 0; i < tip.length(); ++i) {
            if (tip.charAt(i) == letters[i]) {
                checkedCharsInTip[i] = true;
                rightPosition++;
            } else {
                wrongPositionRightLetter = incIfCharIsInLetters(tip, i, wrongPositionRightLetter);
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
        triesPositions[0][i] = rightPosition;
        triesPositions[1][i] = wrongPositionRightLetter;
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
        System.out.println(timesTried + " bisherige" + (timesTried == 0 ? "r" : "") + " Versuch" + (timesTried > 0 ? "e" : "") + ":");
        for (int i = 0; i < tries.length; ++i) {
            if (tries[i] == null) {
                return;
            } else {
                printColoredTry(tries[i]);
                Console.printColoredText(" " + triesPositions[0][i], "green");
                Console.printlnColoredText(" " + triesPositions[1][i], "orange");
            }
        }
    }

    private boolean oneTry(Scanner scan) {
        String tip = OneLineInput.getStringValueOfDescription(scan, "Tipp");

        if (wantsHelp(tip)) {
            return false;
        }
        timesTried++;
        tip = adapt(tip);
        verify(tip);
        addTipToTries(tip);
        boolean won = won();
        if (won) {
            Console.printlnColoredText("Mit " + timesTried + " Versuch" + (timesTried == 1 ? "" : "en") + " gewonnen!", "green");
        } else {
            printTries();
            System.out.println();
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
        return Console.colorConsoleTextAndBackground("white bright", "green") + "Hilfe" + Console.colorConsoleTextAndBackground("default", "default") + "\n" +
                "Mögliche Buchstaben: " + Console.colorConsoleText(getColor('A')) + "A" + Console.colorConsoleText("default") + "-" + Console.colorConsoleText(getColor('H')) + "H" + Console.colorConsoleText("default") + "\n" +
                "Versuche: " + timesTried +
                "/" + MAX_TRIES + "\n" +
                Console.colorConsoleText("green") + "Zuletzt richtige Position: " + rightPosition + "\n" +
                Console.colorConsoleText("orange") + "Zuletzt falsche Position, richtige Letter: " + wrongPositionRightLetter +
                Console.colorConsoleText("default") + "\n";
    }

    public static void main(String[] args) {
        MasterMind game = new MasterMind();
        game.start();
    }
}