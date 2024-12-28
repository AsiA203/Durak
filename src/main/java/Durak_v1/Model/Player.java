package Durak_v1.Model;

import java.util.ArrayList;

public class Player {
    private int order;
    private String name;
    private ArrayList<Card> cards;

    public Player(int order, String name){
        this.order = order;
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public int getOrder(){
        return this.order;
    }

    public String getName(){
        return this.name;
    }

    public void setCardInArray(Card card){
        cards.add(card);
    }

    public String getAllCards(){
        return cards.toString();
    }

    public ArrayList <Card> getCardsArray(){
        return cards;
    }

    public int getCardsArrayLength(){
        return cards.size();
    }


    @Override
    public String toString(){
        return "Player: " + getOrder() + ", Name: " + getName();
    }
}
