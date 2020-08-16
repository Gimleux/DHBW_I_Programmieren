package de.dhbwka.java.exercise.ui;

import de.dhbwka.java.utilities.console.Console;
import de.dhbwka.java.utilities.files.read.wholeTextFiles.FileToString;

import javax.swing.*;
import java.awt.*;

public class TextFrame extends JFrame {

    public TextFrame(String filename, int width, int height) {
        super(filename);
        this.setLayout(new BorderLayout());
        this.add(new JTextArea(FileToString.getFileToString_WithErrorDescription(filename)));
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } catch (Exception e) {
            Console.printlnColoredText("Fehler: Falscher Aufruf:\nProgrammname <Dateipfad/Dateiname.Endung> <Fensterbreite(positive Ganzzahl)> <Fensterhöhe(positive Ganzzahl)>", "red");
        }
    }
}