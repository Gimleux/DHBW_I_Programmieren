package de.dhbwka.java.exercise.classes;

public class Complex {
    private double real;
    private double imag;

    public Complex() {
        this.real = 1;
        this.imag = 2;
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex comp) {
        return new Complex(this.real + comp.real, this.imag + comp.imag);
    }

    public Complex sub(Complex comp) {
        return new Complex(this.real - comp.real, this.imag - comp.imag);
    }

    public Complex mult(Complex comp) {
        return new Complex(this.real * comp.real - this.imag * comp.imag, this.real * comp.imag + this.imag * comp.real);
    }

    public Complex div(Complex comp) {
        return new Complex((this.real * comp.real + this.imag * comp.imag) / (comp.real * comp.real + comp.imag * comp.imag), (this.imag * comp.real - this.real * comp.imag) / (comp.real * comp.real + comp.imag * comp.imag));
    }

    public boolean isLess(Complex comp) {
        return (this.getMagnitude() < comp.getMagnitude());
    }

    public static void sortComplexByMagnitude(Complex[] array) {
        if (array.length > 1) {
            boolean notSorted;
            int i = 0;
            do {
                notSorted = sort(array, i);
                if (notSorted) {
                    i++;
                }
            } while (notSorted);
        }
    }

    private static boolean sort(Complex[] array, int numberOfDoneIterations) {
        boolean notSorted = false;
        for (int i = 0; i < array.length - 1 - numberOfDoneIterations; i++) {
            if (array[i].getMagnitude() > array[i + 1].getMagnitude()) {
                Complex help = array[i + 1];
                array[i + 1] = array[i];
                array[i] = help;
                notSorted = true;
            }
        }
        return notSorted;
    }

    public static void printComplex(Complex comp) {
        System.out.println("Complex " + comp);
    }

    public double getMagnitude() {
        return Math.sqrt(this.real + this.real + this.imag * this.imag);
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    @Override
    public String toString() {
        return real + (imag >= 0 ? " +" : " ") +
                imag + "i";
    }

    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex(2,1);
        System.out.print("C1: "); printComplex(c1);
        System.out.print("C2: "); printComplex(c2);
        System.out.print("C1+C2: "); printComplex(c1.add(c2));
        System.out.print("C1-C2: "); printComplex(c1.sub(c2));
        System.out.print("C1*C2: "); printComplex(c1.mult(c2));
        System.out.print("C1/C2: "); printComplex(c1.div(c2));
        System.out.println("C1<C2: " + c1.isLess(c2));

        System.out.println("Unsortiert:");
        Complex[] array = new Complex[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Complex((Math.round(Math.random() * 10000)) / 100.0, (Math.round(Math.random() * 10000)) / 100.0);
            printComplex(array[i]);
        }
        System.out.println("Sortiert:");
        sortComplexByMagnitude(array);
        for (Complex element : array) {
            System.out.println(element + " Betrag: " + element.getMagnitude());
        }
    }
}
