package de.dhbwka.java.exercise.io;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrossTotalFile {
    private int crossTotal;
    private String numberAsString;

    public CrossTotalFile() {
    }

    public String getNumber() {
        Scanner scan = new Scanner(System.in);
        String input = OneLineInput.getStringValueOfDescription(scan, "Zahl");
        scan.close();
        return input;
    }

    public void getCrossTotal() {
        calcCrossTotal();
        System.out.println(toString());
    }

    private void calcCrossTotal() {
        int total = 0;
        for (int i = 0; i < numberAsString.length(); ++i) {
            total += Integer.parseInt(numberAsString.substring(i, i + 1));
        }
        crossTotal = total;
    }

    private void printInFile() {
        String path = "crosstotal.txt";
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(toString() + System.lineSeparator());
            System.out.println("In " + path + " hinterlegt.");
        } catch (IOException e) {
            System.out.println("I/O-Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setNumberAsString(String numberAsString) {
        this.numberAsString = numberAsString;
    }

    @Override
    public String toString() {
        return "Die Quersumme von " +
                numberAsString +
                " ist " + crossTotal +
                '.';
    }

    public static void main(String[] args) {
        CrossTotalFile crossTotalFile = new CrossTotalFile();
        crossTotalFile.setNumberAsString(crossTotalFile.getNumber());
        crossTotalFile.getCrossTotal();
        crossTotalFile.printInFile();
    }
}
