package de.dhbwka.java.exercise.classes;

import java.util.Arrays;

public class Horner {
    private double[] polynom;

    public Horner() {
        this.polynom = new double[]{3, 2, 1};
    }

    public Horner(double[] polynom) {
        this.polynom = polynom;
    }

    public double getValue(double x) {
        if (this.polynom.length > 0) {
            double result = this.polynom[0];
            for (int i = 1; i<this.polynom.length; ++i) {
                result = result*x + this.polynom[i];
            }
            return result;
        }
        return Double.NaN;
    }

    @Override
    public String toString() {
        String result = "Polynomial f:";
        for (int i = 0; i < this.polynom.length; ++i) {
            result += " " + ((this.polynom[i]>=0 && i!=0) ? "+" : "") + this.polynom[i] + "x^" + (this.polynom.length-i-1); //-1 da Laenge = Grad +1 wegen 0. Grad
        }
        return result;
    }

    public static void main(String[] args) {
        Horner polynom = new Horner(new double[]{0.5, -3.0, +2.0, +4.0, +3.0, -10.0, +8.0, +4.5, 3.0, -2.0, 1.0});
        System.out.println(polynom);
        System.out.println("f(1.5) = " + polynom.getValue(1.5));
        Horner polyShort = new Horner(new double[]{1,2,3});
        System.out.println(polyShort);
        System.out.println("f(2) = " + polyShort.getValue(2));
    }
}