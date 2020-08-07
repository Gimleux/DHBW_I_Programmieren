package de.dhbwka.java.exercise.strings;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.util.Scanner;

public class CrossTotal {
    private int crossTotal;
    private String numberAsString;

    public CrossTotal() {
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
        CrossTotal crossTotal = new CrossTotal();
        crossTotal.setNumberAsString(crossTotal.getNumber());
        crossTotal.getCrossTotal();
    }
}
