package de.dhbwka.java.exercise.operators;

import java.util.Scanner;

public class Easter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Für welches Jahr wollen Sie den Ostertag wissen?");
        int year = scan.nextInt();
        scan.close();

        System.out.println("Im Jahr " + year + " ist Ostern am " + printEasterDay(getEasterDay(year)) + ".");
    }

    public static int getEasterDay(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        return (22 + d + e);
    }

    public static String printEasterDay(int day) {
        return (day >= 32) ? ((day - 31) + ". April") : (day + ". März");
    }
}
