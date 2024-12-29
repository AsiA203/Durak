package Durak_v1.Model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void setCardInArray(Card card){
        cards.add(card);
    }

    public String getAllCardsDefaultToSting(){
        return cards.toString();
    }

//    public String getAllCardsFullToString(){
//        return cards.toStringFull();
//        return cards.toStringFull();
//    }

    public ArrayList <Card> getCardsArray(){
        return cards;
    }

    public int getCardsArrayLength(){
        return cards.size();
    }


    @Override
    public String toString(){
        return "Player, Name: " + getName();
    }
}
