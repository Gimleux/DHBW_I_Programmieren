package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.utilities.Input.SameLineInput;
import de.dhbwka.java.utilities.console.Console;

import java.util.Scanner;

public class Lotto {
    private short numberToDraw;
    private short numberOfBalls;
    private short[] tip;
    private short[] drawnNumbers;

    public Lotto() {
        this((short)6,(short)49);
    }

    public Lotto(short numberToDraw, short numberOfBalls) {
        this.numberToDraw = numberToDraw;
        this.numberOfBalls = numberOfBalls;
    }

    public void draw() {
        for (int i = 0; i<numberToDraw; ++i){
            drawnNumbers[i] = (short) (Math.random()*numberOfBalls);
        }
    }

    public int richtige() {
        short i = 0;
        short drawn = 0;
        while(this.tip[i]!=0) {
            i++;
            drawn++;
        }
        short right = 0;
        if (drawn!=numberToDraw){
            Console.printlnColoredText("Fehler: Nicht alle Tipps abgegeben!", "red");
        } else {
            for (short tip : this.tip){
                for (short number : this.drawnNumbers){
                    if(tip==number) ++right;
                }
            }
        }
        return right;
    }

    public void setTip(Scanner scan){
        short i = 0;
        while(this.tip[i]!=0) {
            i++;
        }
        short tip = (short) SameLineInput.getIntValueOfDescription(scan, "Tipp für die "+ (i+1) + ". Zahl");
        if (tip <=numberOfBalls && tip>0) {
            this.tip[i] = tip;
        }
                else Console.printlnColoredText("Fehler: Eingabe nicht im Bereich [1,"+numberOfBalls+"]", "red");
    }

    private void setTip(short tip){
        short i = 0;
        while(this.tip[i]!=0) {
            i++;
        }
        if (tip <=numberOfBalls && tip>0)this.tip[i] = tip;
    }

    public void setTip(short[] tip) {
        this.tip = tip;
    }

    public static void main(String[] args) {

    }

}
