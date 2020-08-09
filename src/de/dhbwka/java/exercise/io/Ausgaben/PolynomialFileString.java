package de.dhbwka.java.exercise.io.Ausgaben;

import de.dhbwka.java.exercise.classes.Polynomial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PolynomialFileString {
    public static void main(String[] args) {
        try(BufferedWriter out = new BufferedWriter(new FileWriter("polynomialFileString.txt"))){
            Polynomial p = new Polynomial(1,0,1);
            for (double x = -3; x <= 3.1; x += 0.5){
                String str = x + " " + p.fX(x) + System.lineSeparator();
                out.write(str);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
