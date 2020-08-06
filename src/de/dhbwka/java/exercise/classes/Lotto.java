package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.utilities.Input.SameLineInput;
import de.dhbwka.java.utilities.console.Console;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
    private short numberToDraw;
    private short numberOfBalls;
    private short[] tip;
    private short[] drawnNumbers;

    public Lotto() {
        this((short) 6, (short) 49);
    }

    public Lotto(short numberToDraw, short numberOfBalls) {
        if (numberToDraw > numberOfBalls) {
            Console.printlnColoredText("Anzahl der zu ziehenden Kugeln darf nicht kleiner der Anzahl aller Kugeln sein.", "red");
            Console.printlnColoredText("Anzahl aller Kugeln -> Anzahl der zu ziehenden Kugeln +1", "yellow");
            numberOfBalls = (short) (numberToDraw + 1);
        }
        this.numberToDraw = numberToDraw;
        this.numberOfBalls = numberOfBalls;
        this.tip = new short[numberToDraw];
        this.drawnNumbers = new short[numberToDraw];
    }

    //TODO Hilfsklasse Array durchsuchen (mit und ohne sortieren) schreiben

    public void ziehen() {
        for (int i = 0; i < numberToDraw; ++i) {
            short random;
            do {
                random = (short) ((Math.random() * numberOfBalls) + 1);
            } while (arrayContainsNumber(drawnNumbers, random));
            this.drawnNumbers[i] = random;
        }
        Arrays.sort(drawnNumbers);
    }

    private boolean arrayContainsNumber(short[] array, short number) {
        for (short value : array) {
            if (value == number) return true;
        }
        return false;
    }

    public int richtige() {
        short drawn = 0;
        while (drawn < numberToDraw && this.tip[drawn] != 0) {
            ++drawn;
        }
        short right = 0;
        if (drawn != numberToDraw) {
            Console.printlnColoredText("Fehler: Nicht alle Tipps abgegeben!", "red");
        } else {
            for (short tip : this.tip) {
                for (short number : this.drawnNumbers) {
                    if (tip == number) ++right;
                }
            }
        }
        return right;
    }

    public void setAllTips(Scanner scan) {
        while (this.tip[numberToDraw - 1] == 0) {
            setTip(scan);
        }
        Arrays.sort(this.tip);
    }

    private void setTip(Scanner scan) {
        short i = 0;
        while (this.tip[i] != 0) {
            i++;
        }
        short tip = (short) SameLineInput.getIntValueOfDescription(scan, "Tipp für die " + (i + 1) + ". Zahl");
        if (tip <= numberOfBalls && tip > 0 && this.tip[i] == 0) {
            this.tip[i] = tip;
        } else Console.printlnColoredText("Fehler: Eingabe nicht im Bereich [1," + numberOfBalls + "]", "red");
    }

    public void setTip(short tip) {
        short i = 0;
        while (this.tip[i] != 0) {
            i++;
        }
        if (tip <= numberOfBalls && tip > 0 && this.tip[i] == 0) this.tip[i] = tip;
        Arrays.sort(this.tip);
    }

    public void setTip(short[] tip) {
        this.tip = tip;
        Arrays.sort(this.tip);
    }

    public short getNumberToDraw() {
        return numberToDraw;
    }

    @java.lang.Override
    public java.lang.String toString() {
        boolean alreadyDrawn = (drawnNumbers[0] != 0);
        boolean alreadyTiped = (tip[0] != 0);
        String drawn = "Gezogene Zahlen:";
        for (short number : drawnNumbers) drawn += (" " + number);
        String tipsGiven = "Tipps: ";
        for (short number : tip) if (number != 0) tipsGiven += (" " + number);
        return (!alreadyTiped) ? "" : (tipsGiven) + ((!alreadyDrawn) ? "" : "\n" + drawn);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lotto germanLotto = new Lotto((short) 6, (short) 49);
        germanLotto.setAllTips(scan);
        germanLotto.ziehen();
        System.out.println(germanLotto);
        short richtige = (short)germanLotto.richtige();
        String color;
        if (richtige==germanLotto.getNumberToDraw()) color = "green bright";
                else if (richtige>Math.nextUp(germanLotto.getNumberToDraw()/4.0)) color="yellow";
                    else if (richtige>0)color="orange";
                        else color = "red";
        Console.printlnColoredText("Richtige: " + germanLotto.richtige(), color);
    }

}