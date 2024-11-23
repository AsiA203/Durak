package Durak_v1.Model;

import Durak_v1.Enums.Color;

public class Card {
    int type;
    String suit;
    Color color;
    boolean trumpSuit;

    public Card(int type, String suit, Color color) {
        this.type = type;
        this.suit = suit;
        this.color = color;
        this.trumpSuit = false;
    }

    public int getType() {
        return this.type;
    }

    public String getSuit() {
        return this.suit;
    }

    public Color getColor() {
        return this.color;
    }

    public void setTrumpSuit(){
        this.trumpSuit = true;
    }

    public boolean getTrumpSuit(){
        return trumpSuit;
    }
}
