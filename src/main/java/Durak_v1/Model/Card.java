package Durak_v1.Model;

import Durak_v1.Enums.CardColor;

public class Card {
    CardInfo cardInfo;
    String suit;
    CardColor color;
    boolean trumpSuit;

    public Card(CardInfo cardInfo, String suit, CardColor color) {
        this.cardInfo = cardInfo;
        this.suit = suit;
        this.color = color;
        this.trumpSuit = false;
    }

    public CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public String getSuit() {
        return this.suit;
    }

    public CardColor getColor() {
        return this.color;
    }

    public void setTrumpSuit(){
        this.trumpSuit = true;
    }

    public boolean getTrumpSuit(){
        return trumpSuit;
    }
}
