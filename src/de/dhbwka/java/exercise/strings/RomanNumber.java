package de.dhbwka.java.exercise.strings;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.util.Scanner;

public class RomanNumber {
    private String romanNumberInput;
    private final String[][] TABLE_OF_VALUES = new String[][]{{"I", "V", "X", "L", "C", "D", "M"}, {"1", "5", "10", "50", "100", "500", "1000"}};

    public int value(){
        StringBuilder roman = new StringBuilder();
        roman.append(romanNumberInput).reverse();
        return (roman.length()>0 ? calcValue(roman) : 0);
    }

    public void printValue(){
        System.out.println("Der Wert der Zahl " + romanNumberInput + " ist " + value() + ".");
    }

    private int getCharValue(String romanDigit){
        for (int i = 0; i<TABLE_OF_VALUES[0].length; ++i){
            if (TABLE_OF_VALUES[0][i].equals(romanDigit)){
                return Integer.parseInt(TABLE_OF_VALUES[1][i]);
            }
        }
        return 0;
    }

    private int calcValue(StringBuilder roman){
        int number = 0;
        for(int i = 0; i < roman.length(); ++i){
            int valueAtI = getCharValue(roman.substring(i,i+1));
            int valueAtIPlus1 = 0;
            if (roman.length()>i+1){
                valueAtIPlus1 = getCharValue(roman.substring(i+1,i+2));
            }
            if (valueAtI>valueAtIPlus1){
                number += valueAtI-valueAtIPlus1;
                i++;
            } else {
                number += valueAtI;
            }
        }
        return number;
    }

    public void setRomanNumber(){
        Scanner scan = new Scanner(System.in);
        setRomanNumberString(OneLineInput.getStringValueOfDescription(scan, "römische Zahl"));
    }

    public void setRomanNumberString(String romanNumberString) {
        this.romanNumberInput = romanNumberString;
    }

    public static void main(String[] args) {
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setRomanNumber();
        romanNumber.printValue();
    }
}