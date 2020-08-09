package de.dhbwka.java.exercise.io;

import de.dhbwka.java.exercise.classes.Polynomial;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PolynomialFileBinary {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("polynomialFileBinary.txt.txt"))) {
            Polynomial p = new Polynomial(1, 0, 1);
            for (double x = -3; x <= 3.1; x += 0.5) {
                out.writeDouble(x);
                out.writeChar(' ');
                out.writeDouble(p.fX(x));
                out.writeBytes(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
