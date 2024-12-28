package Durak_v1.Controller;

import Durak_v1.Model.Card;
import Durak_v1.Model.Player;
import Durak_v1.Service.GameService;

import java.util.ArrayList;
import java.util.HashSet;

public class GameController {
    GameService gameService = new GameService();

    public void GameController(){

    }

    //Game Start
    public void initializeCardsAndPlayers(ArrayList<Player> players, int cardDeck){
        gameService.initializeAllCards(players, cardDeck);
    }

    public void giveOutTheFirstDraw(){
        gameService.giveOutFirstDrawOfCardsToPlayers();
    }

    //Helpers
    public ArrayList <Card> getAllCardsInDeck(){
        return gameService.getAllCardsInDeck();
    }

    public int getCardsArraySize(){
        return gameService.getCardsArraySize();
    }

    public ArrayList<Card> getPlayersAllCardsOnHand(String playerName) throws Exception {
        return gameService.getPlayersAllCardsOnHand(playerName);
    }

    public int getCardsArraySizeOfThePlayer(String playerName) throws Exception{
        return gameService.getCardsArraySizeOfThePlayer(playerName);
    }

    public void shuffleCardDeck(){
        gameService.shuffleCardDeck();
    }
}
