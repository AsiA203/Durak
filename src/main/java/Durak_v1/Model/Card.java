package Durak_v1.Model;

import Durak_v1.Enums.*;

public class Card {
    CardSuit cardSuit;
    CardTypes cardType;
    CardColor cardColor;
    boolean trumpSuit;

    public Card(CardSuit cardSuit, CardTypes cardType, CardColor cardColor){
        this.cardSuit = cardSuit;
        this.cardType = cardType;
        this.cardColor = cardColor;
        this.trumpSuit = false;
    }

    public void setTrumpSuitTrue(){
        this.trumpSuit = true;
    }

    public boolean getTrumpSuitStatus(){
        return trumpSuit;
    }

    public CardSuit getCardSuit(){
        return this.cardSuit;
    }

    public CardTypes getCardType(){
        return this.cardType;
    }

    public CardColor getCardColor(){
        return this.cardColor;
    }

    public String toStringFull(){
        return "Card: Suit - " + getCardSuit() + ", Type - " + getCardType() + ", Color - " +
                getCardColor() + ", Trump Suit - " + getTrumpSuitStatus();
    }

    @Override
    public String toString(){
        return getCardType() + " - " + getCardSuit();
    }
}
