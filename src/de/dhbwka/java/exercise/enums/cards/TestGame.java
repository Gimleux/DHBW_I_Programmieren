package de.dhbwka.java.exercise.enums.cards;

import de.dhbwka.java.utilities.console.Console;

public class TestGame {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        Console.printlnColoredText("Unsorted: " + game.size(), "red");
        System.out.println(game);
        Console.printlnColoredText("Shuffled: " + game.size(), "red");
        game.shuffle();
        System.out.println(game);
        Console.printlnColoredText("Draw ten cards and compare to Heart 7", "red");
        PlayingCard heartSeven = new PlayingCard("Heart", "Seven");
        for (int i = 0; i<10; i++){
            PlayingCard card = game.get();
            System.out.println(card + " " +(card.equals(heartSeven)));
        }
        System.out.println();
        Console.printlnColoredText("Print missing cards: " + game.size(), "red");
        System.out.println(game);
        Console.printlnColoredText("Sort missing cards: " + game.size(), "red");
        game.sort();
        System.out.println(game);

    }
}
