package Durak_v1.Model;

import java.util.ArrayList;

public class Board {
    ArrayList<Card> cardsOnBoard;

    public Board(){};

    public Board(ArrayList<Card> cardsOnBoard){
        this.cardsOnBoard = cardsOnBoard;
    }

    public void getAllCardsOnBoard(){
        for(Card card : cardsOnBoard){
            System.out.print(card.toString());
        }
    }
}
