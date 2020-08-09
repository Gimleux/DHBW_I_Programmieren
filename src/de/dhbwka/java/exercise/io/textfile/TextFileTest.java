package de.dhbwka.java.exercise.io.textfile;

import de.dhbwka.java.utilities.console.Console;

import java.io.IOException;

public class TextFileTest {
    public static void main(String[] args) throws IOException, LineNumberOutOfBoundsException {
        TextFile textFile = new TextFile("textFile.txt");
        // Anzahl der Zeilen
        System.out.println("Anzahl der Zeilen: " + textFile.availableLines() + "\n");
        // Erste Zeile
        System.out.println("Zeile 1: " + textFile.getLine(1) + "\n");
        // Fünfte Zeile
        System.out.println("Zeile 5: " + textFile.getLine(5) + "\n");
        // Alle Zeilen
        Console.printlnColoredText("Alle Zeilen: ", "green");
        for (String line : textFile.getLines())
            System.out.println(line);
        System.out.println();
        // Ersetzen von "meine" durch "unsre"
        textFile.replaceAll("meine", "unsre");
        // Datei schreiben
        // textFile.write();
        Console.printlnColoredText("Alle Zeilen nach dem Ersetzen: ", "green");
        for (String line : textFile.getLines())
            System.out.println(line);
        textFile.close();
    }
}
