package de.dhbwka.java.exercise.enums.cards;

import java.util.Comparator;

public class PlayingCardComparator implements Comparator<PlayingCard> {

    public PlayingCardComparator() {
    }

    @Override
    public int compare(PlayingCard o1, PlayingCard o2) {
        if (CardSuit.valueOf(o1.getSuit().toString()).ordinal()-CardSuit.valueOf(o2.getSuit().toString()).ordinal()!=0){
            return CardSuit.valueOf(o1.getSuit().toString()).ordinal()-CardSuit.valueOf(o2.getSuit().toString()).ordinal();
        } else {
            return CardValue.valueOf(o1.getValue().toString()).ordinal()-CardValue.valueOf(o2.getValue().toString()).ordinal();
        }
    }
}