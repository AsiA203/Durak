package Durak_v1.Controller;

import Durak_v1.Enums.CardSuit;
import Durak_v1.Model.Card;
import Durak_v1.Service.GameService;

import java.util.ArrayList;

public class GameController {
    GameService gameService = new GameService();

    /*Game Start*/
    //Step 1
    public void initializeCards(int cardDeck){
        gameService.initializeAllCards(cardDeck);
    }

    //Step 2
    public void shuffleCardDeck(){
        gameService.shuffleCardDeck();
    }

    //Step 3
    public void giveOutTheFirstDraw(){
        gameService.giveOutFirstDrawOfCardsToPlayers();
    }

    //Step 4
    public Card randomTrumpSuitChoice(){
        return gameService.randomTrumpSuitChoice();
    }

    //Step 5
    public void makeChosenSuitsCards_TrumpSuitSetTrue(Card card){
        gameService.makeChosenSuitsCards_TrumpSuitSetTrue(card);
    }

    //Helpers
    public ArrayList<Card> getPlayersAllCardsOnHand(String playerName) throws Exception {
        return gameService.getPlayersAllCardsOnHand(playerName);
    }

    public int getCardsArraySizeOfThePlayer(String playerName) throws Exception{
        return gameService.getCardsArraySizeOfThePlayer(playerName);
    }

//        public ArrayList <Card> getAllCardsInDeck(){
//        return gameService.getAllCardsInDeck();
//    }

//    public int getCardsArraySize(){
//        return gameService.getCardsArraySize();
//    }
}
