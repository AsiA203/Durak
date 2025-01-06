package Durak_v1.Model;

import java.util.ArrayList;

public class Board {
    ArrayList<CardMove> cardsOnBoard;

    public Board(){};

    public Board(ArrayList<CardMove> cardsOnBoard){
        this.cardsOnBoard = cardsOnBoard;
    }

    public void getAllCardsOnBoard(){
        for(CardMove cardMove : cardsOnBoard){
            System.out.print(cardMove.toString());
        }
    }
}
