package de.dhbwka.java.exercise.enums.cards;

import de.dhbwka.java.utilities.random.Random;

import java.util.*;

public class CardGame{
    List<PlayingCard> cards = new LinkedList<>();

    public CardGame() {
        newCardStack();
    }

    public void newCardStack(){
        while (cards.size()<32){
            PlayingCard card = new PlayingCard();
            card.setSuit(CardSuit.values()[Random.RandomIntIncMinExcMax(0,CardSuit.values().length)]);
            card.setValue(CardValue.values()[Random.RandomIntIncMinExcMax(0,CardValue.values().length)]);
            boolean alreadyInThere = false;
            for(PlayingCard pc : cards){
                if (card.equals(pc)) {
                    alreadyInThere = true;
                    break;
                }
            }
            if (!alreadyInThere) cards.add(card);
        }
        //shorter/less time:
        /*
        for (CardSuit cardSuit : CardSuit.values()){
            for (CardValue cardValue : CardValue.values()){
                this.cards.add(new PlayingCard(cardSuit.toString(), cardValue.toString()));
            }
        }
        //optional: this.cards.shuffle();
        */
    }

    public void shuffle(){
        ArrayList<PlayingCard> cardsArray = new ArrayList<>(cards);
        cards.clear();
        while(cardsArray.size()>0){
            int ord = Random.RandomIntIncMinExcMax(0,cardsArray.size());
            cards.add(cardsArray.get(ord));
            cardsArray.remove(ord);
        }
        //shorter: Collections.shuffle(this.cards);
    }

    public void sort(){
        cards.sort(new PlayingCardComparator());
        //shorter: Collections.sort(cards);
    }

    public PlayingCard get(){
        if(this.cards.isEmpty()){
            return null;
        }
        PlayingCard playingCard = cards.get(cards.size() - 1);
        cards.remove(cards.size()-1);
        return playingCard;
        //shorter: return cards.remove(0);
    }

    public List<PlayingCard> all(){
        return cards;
    }

    public int size(){
        return cards.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayingCard p : cards){
            stringBuilder.append(p).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
