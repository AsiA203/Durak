package Durak_v1.Controller;

import Durak_v1.Model.Card;
import Durak_v1.Model.Player;
import Durak_v1.Service.GameInitializeService;

import java.util.ArrayList;

public class GameInitializeController {
    GameInitializeService gameService = new GameInitializeService();

    /*Game Initialize*/
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
    public Card randomTrumpSuitChoice() throws Exception{
        return gameService.randomTrumpSuitChoice();
    }

    //Step5
    public void putChosenTrumpSuitCardAtTheEndOfTheMainCardDeck(Card card){
        gameService.putChosenTrumpSuitCardAtTheEndOfTheMainCardDeck(card);
    }

    //Step 6
    public void makeChosenSuitsCards_TrumpSuitSetTrue(Card card){
        gameService.makeChosenSuitsCards_TrumpSuitSetTrue(card);
    }

    //Step 7
    public Player playerWithLeastStrongTrumpSuitCard(Card chosenCard) throws Exception{
        return gameService.playerWithLeastStrongTrumpSuitCard(chosenCard);
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
