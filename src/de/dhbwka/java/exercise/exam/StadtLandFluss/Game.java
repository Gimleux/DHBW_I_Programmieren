package de.dhbwka.java.exercise.exam.StadtLandFluss;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Game {
    private char aChar;
    private ArrayList<ColumnType> columnTypes;
    private  int remainingSeconds=30;



    private boolean running=false;
    private  ArrayList<Sheet> sheets=new ArrayList<>();
    private int min;
    private int max;
    private  ArrayList<String> word=new ArrayList<>();


    public void setRemainingSeconds(int remainingSeconds) {

        for (Sheet s:
                sheets) {
            s.getSeconds().setText(String.valueOf(remainingSeconds));

        }

        this.remainingSeconds = remainingSeconds;
    }

    public Game(int min, int max, int seconds){

        try(BufferedReader bufferedReader=new BufferedReader((new FileReader("validwords.txt")))){
            while (bufferedReader.ready()){
                word.add(bufferedReader.readLine());
            }
        }
        catch (Exception e){

        }



        if (!(min>=3)){
            this.min=3;

        }
        else this.min=min;
        if (!(max>=min)){
            this.max=min;
        }
        else this.max=max;


    }


    char createFirstChar(){
        Random random=new Random();
        return (char) ('A'+random.nextInt(('Z'-'A')+1));
    }

    public char getaChar() {
        return aChar;
    }

    public ArrayList<ColumnType> getColumnTypes() {
        return columnTypes;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public boolean isRunning() {
        return running;
    }

    ArrayList<ColumnType> createColumns(int min, int max){

        Random random=new Random();
        int amount=(1+min+random.nextInt(1+max-min));
        System.out.println(amount);

        Set<ColumnType> set=new HashSet<>();

        set.add(ColumnType.CITY);
        set.add(ColumnType.COUNTRY);
        set.add(ColumnType.RIVER);

        while (set.size()<amount){
            set.add(ColumnType.values()[random.nextInt(ColumnType.values().length)]);
        }


        return new ArrayList<>(set);
    }



    public void  register(Sheet sheet){
        sheets.add(sheet);
    }


    public void startGame(){
        if (!running){
            aChar=createFirstChar();
            columnTypes=createColumns(min,max);

        }
        for (Sheet sheet:
                sheets) {
            sheet.start();
        }



        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                running=true;
                while(isRunning() && getRemainingSeconds()>0){
                    try {
                        Thread.sleep(1000);
                        setRemainingSeconds(getRemainingSeconds()-1);
                    }


                    catch (Exception e){}
                }
                if (isRunning()){
                    stopGame();
                }
            }
        };
        new Thread(runnable).start();

    }

    public void stopGame(){
        for (Sheet sheet:
                sheets) {
            sheet.stop();
        }
        running=false;
        result();
    }


    public void result(){

        for (ColumnType c:
                columnTypes) {
            ArrayList<String> answers=new ArrayList<>();
            for (Sheet sheet:
                    sheets) {
                System.out.println(sheet.getMap().get(c));
                if (isCorrect(sheet.getMap().get(c),c)){
                    answers.add(sheet.getMap().get(c));
                }

            }


            for (Sheet sheet:
                    sheets) {

                if (answers.contains(sheet.getMap().get(c))){
                    answers.remove(sheet.getMap().get(c));

                    if (answers.size()==0){
                        sheet.getPlayer().setPoints( sheet.getPlayer().getPoints()+20);
                        sheet.setResult(c,20);
                    }
                    else if (!answers.contains(sheet.getMap().get(c))){
                        sheet.getPlayer().setPoints( sheet.getPlayer().getPoints()+10);
                        sheet.setResult(c,10);
                    }
                    else {
                        sheet.getPlayer().setPoints( sheet.getPlayer().getPoints()+5);
                        sheet.setResult(c,5);
                    }
                    answers.add(sheet.getMap().get(c));
                }
                else {
                    sheet.setResult(c,0);
                }
            }


        }
    }

    private boolean isCorrect(String s,ColumnType c) {
        if (s.length()>1 && s.substring(0,1).equalsIgnoreCase(String.valueOf( aChar)) && word.contains(s.toLowerCase())){
            return true;
        }
        else if (s.length()>1 && s.substring(0,1).equalsIgnoreCase(String.valueOf( aChar))) {
            int i= JOptionPane.showConfirmDialog(null, "Ist "+s+" ein Wort der kategorie "+ c.getTitle());

            if ( i==JOptionPane.YES_OPTION){
                try ( BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter("validwords.txt",true))){
                    bufferedWriter.write(s.toLowerCase()+"\n");
                }
                catch (Exception e){}
                return true;
            }
            else return false;
        }
        return false;
    }
}