package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year = readInputYear();

        System.out.println(year + " ist " + (isLeapYear(year) ? "" : "k") + "ein Schaltjahr.");
    }

    public static int readInputYear() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben Sie ein Schaltjahr ein, welches auf Schaltjahr geprüft werden soll: ");
        int year = scan.nextInt();
        scan.close();
        return year;
    }

    public static boolean isLeapYear(int year) {
       /* if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
        */
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
