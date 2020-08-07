package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.utilities.Input.OneLineInput;
import de.dhbwka.java.utilities.console.Console;

import java.util.Scanner;

public class Nimmspiel {
    private boolean playerOne = true;
    private int stock1;
    private int stock2;

    public Nimmspiel() {
        this((int) (Math.random() * 10), (int) (Math.random() * 10));
    }

    public Nimmspiel(int stock1, int stock2) {
        if (stock1 != 0 || stock2 != 0) {
            this.stock1 = Math.abs(stock1);
            this.stock2 = Math.abs(stock2);
        } else {
            System.out.println("Es muss mindestens eine Kugel geben. Standardwerte werden initialisiert. \n");
            this.stock1 = (int) (Math.random() * 10);
            this.stock2 = (int) (Math.random() * 10);
        }
    }

    public boolean isPlayerOne() {
        return playerOne;
    }

    private void switchPlayer() {
        playerOne = !playerOne;
    }

    private boolean won() {
        return ((stock1 == stock2) && (stock1 == 0));
    }

    public void reduceStock(int stockNumber, int number){
        if (stockNumber == 1) {
            reduceStock1(number);
        } else {
            reduceStock2(number);
        }
    }

    public void reduceStock1(int number) {
        if (number > 0 && stock1 - number >= 0) stock1 -= number;
    }

    public void reduceStock2(int number) {
        if (number > 0 && stock2 - number >= 0) stock2 -= number;
    }

    public int getStock1() {
        return stock1;
    }

    public int getStock2() {
        return stock2;
    }

    @Override
    public String toString() {
        return "1. Haufen: " + stock1 +
                " Kugeln; 2. Haufen: " + stock2 +
                " Kugeln";
    }

    public static boolean oneRound(Scanner scan, Nimmspiel game) {
        Console.printlnColoredText(game.toString(), "yellow");
        char playerChar = (game.isPlayerOne() ? 'A' : 'B');

        System.out.println("Von welchem Vorrat(1/2) möchte Spieler "+playerChar+" ziehen?");
        int stackNumber = scan.nextInt();
        stackNumber = stackNumber < 1 ? 1 : Math.min(stackNumber, 2);

        int stackRemaining = (stackNumber == 1) ? game.getStock1() : game.getStock2();
        System.out.print("Im ausgewählten Vorrat " + stackNumber + " befinden sich noch " + stackRemaining + " Kugeln.\nWie viele wollen Sie ziehen: ");
        int reduceNumber = scan.nextInt();


        boolean won;
        if ((stackNumber==1? game.stock1 : game.stock2)-reduceNumber>=0){
            game.reduceStock(stackNumber, reduceNumber);
            won = game.won();
            if (!won) game.switchPlayer();

            System.out.println(
                    (won? Console.colorConsoleText("green") : "") +
                            "Spieler " + playerChar +
                            ": nimmt vom " +
                            stackNumber + ". Haufen " +
                            reduceNumber + " Kugel" + (reduceNumber>1? "n" : "") +
                            (won ? " und hat gewonnen!" : "") + "\n"
                    + Console.colorConsoleText("default")
            );
        } else {
            Console.printlnColoredText("Zug nicht möglich!\n", "red");
            won = false;
        }
        return won;
    }

    public static void play(Scanner scan, Nimmspiel game) {
        boolean finished = false;
        while (!finished){
            finished = oneRound(scan, game);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stack1 = OneLineInput.getIntValueOfDescription(scan, "Anzahl der Kugeln im Vorrat 1");
        int stack2 = OneLineInput.getIntValueOfDescription(scan, "Anzahl der Kugeln im Vorrat 2");
        Console.printlnColoredText("-----------------------------------------------\n", "yellow");
        Nimmspiel game = new Nimmspiel(stack1, stack2);
        play(scan, game);
    }
}
