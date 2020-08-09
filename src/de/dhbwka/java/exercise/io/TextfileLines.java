package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextfileLines {


    public static void main(String[] args) {
        StringBuilder readText = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("textfilelines.txt"))){
            int count = 0;
            while (br.ready()){
                ++count;
                String line = br.readLine();
                if(count>=2 && count<=5){
                    System.out.println(line);
                    readText.append(line).append(" ");
                }
            }
            System.out.println("Zeile -5: " + readText);
        } catch (IOException e){
            System.out.println("Fehler: Konnte Datei nicht lesen");
            System.out.println(e.getMessage());

        }
    }
}