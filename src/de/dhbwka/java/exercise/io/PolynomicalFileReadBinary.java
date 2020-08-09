package de.dhbwka.java.exercise.io;

import java.io.*;

public class PolynomicalFileReadBinary {
    public static void main(String[] args) {
        try(DataInputStream in = new DataInputStream(new FileInputStream("polynomialFileBinary.txt"))){
            double x, y;
            boolean eof = false;
            while(!eof){
                try {
                    x = in.readDouble();
                    y = in.readDouble();
                    System.out.println(x + " " + y);
                } catch(EOFException e){
                    eof = true;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
