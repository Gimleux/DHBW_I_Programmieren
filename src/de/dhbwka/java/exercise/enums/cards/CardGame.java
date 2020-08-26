package de.dhbwka.java.exercise.enums.cards;

import de.dhbwka.java.utilities.random.Random;

import java.util.*;

public class CardGame {
    List<PlayingCard> cards = new LinkedList<>();

    public CardGame() {
        while (cards.size()<32){
            PlayingCard card = new PlayingCard();
            card.setSuit(CardSuit.values()[Random.RandomIntIncMinExcMax(0,CardSuit.values().length)]);
            card.setValue(CardValue.values()[Random.RandomIntIncMinExcMax(0,CardValue.values().length)]);
            cards.add(card);
        }
        for (PlayingCard p : cards){
            System.out.println(p);
        }
    }

    public void shuffle(){
        ArrayList<PlayingCard> cardsArray = new ArrayList<>(cards);
        cards.clear();
        while(cardsArray.size()>0){
            int ord = Random.RandomIntIncMinExcMax(0,cardsArray.size());
            cards.add(cardsArray.get(ord));
            cardsArray.remove(ord);
        }
    }

    public void sort(){
        cards.sort(new Comparator<PlayingCard>() {
            @Override
            public int compare(PlayingCard o1, PlayingCard o2) {
                if (CardSuit.valueOf(o1.getSuit().toString())<CardSuit.valueOf(o2.getSuit().toString())){

                }
            }
        });
        ArrayList<PlayingCard> cardsArray = new ArrayList<>(cards);
        cards.clear();

        while(cardsArray.size()>0){
            int ord = Random.RandomIntIncMinExcMax(0,cardsArray.size());
            cards.add(cardsArray.get(ord));
            cardsArray.remove(ord);
        }
    }

    public static void main(String[] args) {
        new CardGame();
    }
}
