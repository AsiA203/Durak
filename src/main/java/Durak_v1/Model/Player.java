package Durak_v1.Model;

import java.util.Arrays;

public class Player {
    private int order;
    private String name;
    private Card [] cards;

    public Player(int order, String name){
        this.order = order;
        this.name = name;
        this.cards = null;
    }

    public int getOrder(){
        return this.order;
    }

    public String getName(){
        return this.name;
    }

    public void setCardInArray(int index, Card card){
       cards[index] = card;
    }

    public String getAllCards(){
        return Arrays.toString(cards);
    }

    public Card [] getCardsArray(){
        return cards;
    }

    public int getCardsArrayLength(){
        return cards.length;
    }


    @Override
    public String toString(){
        return "Number: " + getOrder() + ", Name: " + getName();
    }
}
