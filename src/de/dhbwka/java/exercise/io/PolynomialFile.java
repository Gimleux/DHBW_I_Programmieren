package de.dhbwka.java.exercise.io;

import java.io.*;

public class PolynomialFile {
    private double a;
    private double b;
    private double c;

    public PolynomialFile() {
        this.a = 3;
        this.b = 2;
        this.c = 1;
    }

    public PolynomialFile(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double fX(double x) {
        return a * x * x + b * x + c;
    }

    public PolynomialFile subtractPolynom(PolynomialFile poly) {
        return new PolynomialFile(this.a - poly.a, this.b - poly.b, this.c - poly.c);
    }

    public PolynomialFile addPolynom(PolynomialFile poly) {
        return new PolynomialFile(this.a + poly.a, this.b + poly.b, this.c + poly.c);
    }

    public PolynomialFile multiplyWithScalar(double scalar) {
        return new PolynomialFile(this.a * scalar, this.b * scalar, this.c * scalar);
    }

    public double[] getZeros() {
        double discriminant = this.b * this.b - (4 * this.a * this.c);
        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            return new double[]{(-this.b) / 2 * this.a};
        } else {
            double[] zeros = new double[2];
            zeros[0] = (-this.b + Math.sqrt(discriminant)) / (2 * this.a);
            zeros[1] = (-this.b - Math.sqrt(discriminant)) / (2 * this.a);
            return zeros;
        }
    }

    public void printPolynomInFile(String preString) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("polynomialFile.txt", true))) {
            out.write(preString + toString() + System.lineSeparator() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printZerosInFile(String preString) {
        double[] zeros = getZeros();
        try (BufferedWriter out = new BufferedWriter(new FileWriter("polynomialFile.txt", true))) {
            out.write(preString + System.lineSeparator());
            for (double zero : zeros){
                out.write(Double.toString(zero) + System.lineSeparator());
            }
            out.write(System.lineSeparator() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPolynoms(){
        try(BufferedReader br = new BufferedReader(new FileReader("polynomialFile.txt"))) {
            while (br.ready()){
                String line = br.readLine();
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return a + "x^2 "
                + (b >= 0 ? "+" : "") + b + "x "
                + (c >= 0 ? "+" : "") + c;
    }

    public static void main(String[] args) {
        PolynomialFile polynom = new PolynomialFile(2, 0, 0);
        polynom.printPolynomInFile("P1: ");
        PolynomialFile polynom2 = new PolynomialFile(0, -4, 1);
        polynom2.printPolynomInFile("P2: ");
        PolynomialFile polynom3 = polynom.addPolynom(polynom2);
        polynom3.printPolynomInFile("P3 = P1 + P2: ");
        polynom3 = polynom3.multiplyWithScalar(2);
        polynom3.printPolynomInFile("P3 = 2 * P3: ");
        polynom3.printZerosInFile("Nullstellen von P3 (" + polynom3.toString() + "):");
        readPolynoms();
    }
}
