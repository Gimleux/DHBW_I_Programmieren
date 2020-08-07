package de.dhbwka.java.exercise.methods;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.util.Scanner;

public class Exponentiation {

    public static double xPowerN(double x, int n){
        if (n==0){
            return 1;
        } else {
            return x*xPowerN(x, n-1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = OneLineInput.getDoubleValueOfDescription(scan, "die Basis x");
        int n = OneLineInput.getIntValueOfDescription(scan, "positiven ganzzahligen Exponenten n");
        scan.close();

        System.out.println(x+"^"+n+" = " + xPowerN(x,n));
    }
}
