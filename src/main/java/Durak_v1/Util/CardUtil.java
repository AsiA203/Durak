package Durak_v1.Util;

import Durak_v1.Enums.CardColor;
import Durak_v1.Enums.CardSuit;
import Durak_v1.Enums.CardTypes;
import Durak_v1.Model.Card;
import Durak_v1.Model.Player;

import java.util.ArrayList;

import static Durak_v1.Main.trumpCard;

public class CardUtil {
    CardTypes cardTypes;

    public Card convertStringToCard(String stringCard){
        CardSuit cardSuit = null;
        CardTypes cardType = null;
        CardColor cardColor;
        boolean trumpSuit = false;

        //cardSuit
        switch(stringCard.split("-")[1].toUpperCase()){
            case "HEART": cardSuit = CardSuit.HEART;
                break;
            case "DIAMOND": cardSuit = CardSuit.DIAMOND;
                break;
            case "CLUB": cardSuit = CardSuit.CLUB;
                break;
            case "SPADE": cardSuit = CardSuit.SPADE;
                break;
        }

        //cardType
        switch(stringCard.split("-")[0].toUpperCase()){
            case "6": cardType = CardTypes.SIX;
                break;
            case "7": cardType = CardTypes.SEVEN;
                break;
            case "8": cardType = CardTypes.EIGHT;
                break;
            case "9": cardType = CardTypes.NINE;
                break;
            case "10": cardType = CardTypes.TEN;
                break;
            case "JACK": cardType = CardTypes.JACK;
                break;
            case "QUEEN": cardType = CardTypes.QUEEN;
                break;
            case "KING": cardType = CardTypes.KING;
                break;
            case "ACE": cardType = CardTypes.ACE;
                break;
        }

        //cardColor
        if(cardSuit.equals(CardSuit.HEART) || cardSuit.equals(CardSuit.DIAMOND)) cardColor = CardColor.RED;
        else cardColor = CardColor.BLACK;

        if(cardSuit.equals(trumpCard.getCardSuit())) trumpSuit = true;
        return new Card(cardSuit, cardType, cardColor,trumpSuit);
    }


    public boolean removeCardFromPlayer(Card cardToBeRemoved, Player player){
        for(Card card : player.getCardsArray()){
            if(card.equals(cardToBeRemoved)){
                player.removeCardFromArray(card);
            }
        }
        return false;
    }

    public ArrayList<Card> pickUpCard(Card card, Player player){
        if(!player.getCardsArray().contains(card)) player.addCardIntoCardArray(card);
        return player.getCardsArray();
    }

    public ArrayList<Card> pickUpCards(ArrayList<Card> cards, Player player){
        for(Card card : cards){
            if(!player.getCardsArray().contains(card)) player.addCardIntoCardArray(card);
        }
        return player.getCardsArray();
    }
}
