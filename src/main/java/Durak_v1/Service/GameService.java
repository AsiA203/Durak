package Durak_v1.Service;

import Durak_v1.Enums.*;
import Durak_v1.Model.Card;
import Durak_v1.Model.Player;

import java.util.ArrayList;
import java.util.Collections;

public class GameService {
    ArrayList<Card> cardDeckArray = new ArrayList<>();
    ArrayList<Player> playersArray = new ArrayList<>();

    public void GameStartMethod() {

    }

    //Game Start
    public void randomChooseTrumpSuit(){

    }

    public void giveOutFirstDrawOfCardsToPlayers(){
        for(int i = 0; i < 6; i++){
            for(int p = 0; p < playersArray.size(); p++){
                playersArray.get(p).setCardInArray(cardDeckArray.remove(0));
            }
        }
    }

    public void initializeAllCards(ArrayList<Player> newPlayers, int cardDeck) {
        //save players
        this.playersArray = newPlayers;

        //initialize 36 card deck
        if (cardDeck == 36) {
            initialize36CardDeck();
        }//TODO: 52 card deck if needed
    }

    //Helper Functions
    public void shuffleCardDeck(){
        Collections.shuffle(cardDeckArray);
        Collections.shuffle(cardDeckArray);
    }

    public ArrayList <Card> getAllCardsInDeck(){
        return cardDeckArray;
    }

    public int getCardsArraySize(){
        return cardDeckArray.size();
    }

    public ArrayList<Card> getPlayersAllCardsOnHand(String playerName) throws Exception{
        for(Player player : playersArray){
            if(player.getName().equals(playerName)){
                return player.getCardsArray();
            }
        }
        throw new Exception("No player with this name " + playerName + " was not found.");
    }

    public int getCardsArraySizeOfThePlayer(String playerName) throws Exception{
        return getPlayersAllCardsOnHand(playerName).size();
    }

    public void initialize36CardDeck() {
        for(int i = 0; i < 9; i++) {
            int rank = i + 6;
            Card heart = new Card(CardSuit.HEART, CardTypes.getCardTypeFromValue(rank), CardColor.RED);
            Card diamond = new Card(CardSuit.DIAMOND, CardTypes.getCardTypeFromValue(rank), CardColor.RED);
            Card club = new Card(CardSuit.CLUB, CardTypes.getCardTypeFromValue(rank), CardColor.BLACK);
            Card spade = new Card(CardSuit.SPADE, CardTypes.getCardTypeFromValue(rank), CardColor.BLACK);

            cardDeckArray.add(heart);
            cardDeckArray.add(diamond);
            cardDeckArray.add(club);
            cardDeckArray.add(spade);
        }
    }

    //TODO: Initialize 52 Card Deck, if needed
}
