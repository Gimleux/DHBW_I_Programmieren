package de.dhbwka.java.exercise.control;

public class Enumeration {
    public enum Month {JAN, FEB, MAR, APR, MAI, JUN, JUL, AUG, SEP, OCT, NOV, DEC};

    public static void main(String[] args) {
        Month m = Month.NOV;
        int monthNumber = 0;

        switch (m) {
            case JAN:
                monthNumber = 1;
                break;
            case FEB:
                monthNumber = 2;
                break;
            case MAR:
                monthNumber = 3;
                break;
            case APR:
                monthNumber = 4;
                break;
            case MAI:
                monthNumber = 5;
                break;
            case JUN:
                monthNumber = 6;
                break;
            case JUL:
                monthNumber = 7;
                break;
            case AUG:
                monthNumber = 8;
                break;
            case SEP:
                monthNumber = 9;
                break;
            case OCT:
                monthNumber = 10;
                break;
            case NOV:
                monthNumber = 11;
                break;
            case DEC:
                monthNumber = 12;
                break;
            default:
                monthNumber = 0;
                break;
        }

        System.out.println("Wir haben den " + monthNumber + ". Monat.");
    }
}
