package de.dhbwka.java.exercise.io.textfile;

import de.dhbwka.java.utilities.console.Console;

import java.io.*;
import java.util.ArrayList;

public class TextFile {

    private File file;
    private String[] buffer;

    public TextFile(File file) {
        if(file.exists()){
            this.file = file;
            this.read();
        }else {
            Console.printlnColoredText("Fehler: Datei " + file.getName() + " existiert nicht", "red");
        }
    }

    public TextFile(String pathname){
        this(new File(pathname));
    }

    public void read(){
        int numberOfLines = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                br.readLine();
                numberOfLines++;
            }
        } catch (IOException e){
            Console.printlnColoredText("Fehler: Datei nicht gefunden", "red");
        }
        buffer = new String[numberOfLines];
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            for (int i = 0; i< buffer.length; i++){
                buffer[i] = br.readLine();
            }
        } catch (IOException e){
            Console.printlnColoredText("Fehler: " + e.getMessage(), "red");
        }
    }

    public void write(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for(String line : buffer){
                bw.write(line + System.lineSeparator());
            }
        } catch (IOException e){
            Console.printlnColoredText("Fehler: " + e.getMessage(), "red");
        }
    }

    public int availableLines(){
        return buffer.length;
    }

    public String[] getLines(){
        return buffer;
    }

    public String getLine(int i) throws LineNumberOutOfBoundsException {
        if (i<1 || i>availableLines()){
            throw new LineNumberOutOfBoundsException("Index außerhalb des Puffers!");
        } else {
            return buffer[i-1];
        }
    }

    public void setLine(int i, String content) throws LineNumberOutOfBoundsException{
        if (i<1 || i>availableLines()){
            throw new LineNumberOutOfBoundsException("Index außerhalb des Puffers!");
        } else {
            if (buffer!= null) {
                buffer[i - 1] = content;
            } else Console.printlnColoredText("Fehler: Puffer ist nicht definiert", "red");
        }
    }

    public void replaceAll(String regexp, String replace){
        if (buffer!=null && regexp != null && replace != null) {
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = buffer[i].replaceAll(regexp, replace);
            }
        } else Console.printlnColoredText("Fehler: Fehlerhafte Eingabe", "red");
    }

    public void close(){
        buffer = null;
        file = null;
    }
}