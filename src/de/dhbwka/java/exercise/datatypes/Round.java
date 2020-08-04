package de.dhbwka.java.exercise.datatypes;

import de.dhbwka.java.utilities.console.Console;

import java.util.Scanner;

public class Round {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben Sie die zu rundende Zahl ein: " + Console.colorConsoleText("red"));
        double input = scan.nextDouble();
        System.out.println(Console.colorConsoleText("default"));
        scan.close();

        System.out.println("Die kaufmännische Rundung von " + Console.colorConsoleText("red") + input + Console.colorConsoleText("default") + " lautet: " + Console.colorConsoleText("green") + round(input) + Console.colorConsoleText("default"));

        /* 
        System.out.println("33,4: " + round(33.4));
        System.out.println("33,6: " + round(33.6));
        System.out.println("3333,999: " + round(3333.999));
        System.out.println("333399,0000001: " + round(333399.0000001));

        System.out.println("\n***Mit negativen Zahlen \n");
        System.out.println("-33,4: " + round(-33.4));
        System.out.println("-33,6: " + round(-33.6));
        System.out.println("-3333,999: " + round(-3333.999));
        System.out.println("-333399,0000001: " + round(-333399.0000001));
         */
    }

    public static int round(double input) {
        int addValue = (input >= 0) ? 1 : -1;

        //falls im Bereich (0.5,-0.5)
        return (((input - ((int) input) < 0.5) && (input - ((int) input) > -0.5))) ? (int) input : (int) input + addValue;
    }
}
