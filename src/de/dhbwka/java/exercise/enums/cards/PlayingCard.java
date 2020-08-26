package de.dhbwka.java.exercise.enums.cards;

public class PlayingCard implements Comparable<PlayingCard> {
    private CardSuit suit;
    private CardValue value;

    public PlayingCard() {
    }

    public PlayingCard(String suit, String value) {
        this.suit = CardSuit.valueOf(suit);
        this.value = CardValue.valueOf(value);
    }

    public int compareTo(PlayingCard c) {
        return this.getCardValue() - c.getCardValue();
    }

    @Override
    public String toString() {
        return "Card: " +
                suit + " " +
                value;
    }

    public boolean equals(PlayingCard pc) {
        return (suit == pc.suit && value == pc.value && this.getClass()==pc.getClass());
    }

    private int getCardValue() {
        return suit.ordinal() * 10 + value.ordinal();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getter & Setter
    ///////////////////////////////////////////////////////////////////////////
    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }
}
