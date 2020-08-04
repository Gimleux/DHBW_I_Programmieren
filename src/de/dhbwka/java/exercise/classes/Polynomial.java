package de.dhbwka.java.exercise.classes;

public class Polynomial {
    private double a;
    private double b;
    private double c;

    public Polynomial() {
        this.a = 3;
        this.b = 2;
        this.c = 1;
    }

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double fX(double x) {
        return a * x * x + b * x + c;
    }

    public Polynomial subtractPolynom(Polynomial poly) {
        return new Polynomial(this.a - poly.a, this.b - poly.b, this.c - poly.c);
    }

    public Polynomial addPolynom(Polynomial poly) {
        return new Polynomial(this.a + poly.a, this.b + poly.b, this.c + poly.c);
    }

    public Polynomial multiplyWithScalar(double scalar) {
        return new Polynomial(this.a * scalar, this.b * scalar, this.c * scalar);
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

    @Override
    public String toString() {
        return a + "x^2 "
                + (b >= 0 ? "+" : "") + b + "x "
                + (c >= 0 ? "+" : "") + c;
    }

    public static void main(String[] args) {
        Polynomial polynom = new Polynomial(2, 0, 0);
        System.out.println("P1: " + polynom);
        Polynomial polynom2 = new Polynomial(0, -4, 1);
        System.out.println("P2: " + polynom2);
        Polynomial polynom3 = polynom.addPolynom(polynom2);
        System.out.println("P3 = P1 + P2: " + polynom3);
        polynom3 = polynom3.multiplyWithScalar(2);
        System.out.println("P3 = 2 * P3: " + polynom3);
        System.out.print("Nullstellen von P3 (" + polynom3.toString() + "): " + "\n");
        for (double zero : polynom3.getZeros()) System.out.print(zero + " ");
    }
}
