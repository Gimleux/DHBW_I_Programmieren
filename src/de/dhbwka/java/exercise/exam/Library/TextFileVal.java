package de.dhbwka.java.exercise.exam.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFileVal {
    public ArrayList<String> lines = new ArrayList<String>();
    public File file;


    public TextFileVal(File f) {
        file=f;
        read();
    }

    public TextFileVal(String pathname) {
        try {
            file =new File(pathname);
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void read(){
        try(BufferedReader br=new BufferedReader(new FileReader(file))) {
            String tmp;
            lines.clear();
            while ((tmp= br.readLine()) != null){
                lines.add(tmp);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    public void write(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
            for (String s:
                    lines) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int availableLines(){
        return lines.size();
    }

    public String[] getLines(){
        String[] strings=new String[availableLines()];
        for (int i = 0; i < availableLines(); i++) {
            strings[i]=lines.get(i);
        }
        return strings;
    }


    String getLine(int i) throws LineNumberOutOfBoundsExceptionVal {
        if (i<1 || i>availableLines()) throw new LineNumberOutOfBoundsExceptionVal();
        else {
            return lines.get(i-1);
        }
    }

    void setLine(int i, String s) throws LineNumberOutOfBoundsExceptionVal {
        getLine(i);
        lines.set(i-1,s);
    }

    void replaceAll(String regexp, String ersatz) {
        String string;
        for (int i = 1; i <= availableLines() ; i++) {
            try{ string=getLine(i);
                setLine(i,string.replaceAll(regexp,ersatz));}
            catch (LineNumberOutOfBoundsExceptionVal e){e.printStackTrace();}
        }
    }

    public String getText(){
        read();
        StringBuilder sb= new StringBuilder();
        for (String s:
                lines) {
            sb.append(s+"\n");
        }
        return sb.toString();
    }

    public void setText(String s ){
        lines= new ArrayList<String>( Arrays.asList(s.split("\n")));
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }
    public void addLine(String s){
        lines.add(s);
    }

    public void close(){
        write();
        lines.clear();
        file=null;
    }
}