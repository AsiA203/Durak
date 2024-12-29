package Durak_v1.Service;

import Durak_v1.Enums.*;
import Durak_v1.Model.Card;
import Durak_v1.Model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import static Durak_v1.Main.cardDeckArray;
import static Durak_v1.Main.playersArray;

public class GameService {

    /*Game Start*/
    //Step 1 - initialize card deck depending on which was chosen
    public void initializeAllCards(int cardDeck) {
        //initialize 36 card deck
        if (cardDeck == 36) {
            initialize36CardDeck();
        }//TODO: 52 card deck if needed
    }

    //Step 2 - shuffle all cards after initializing
    public void shuffleCardDeck(){
        Collections.shuffle(cardDeckArray);
        Collections.shuffle(cardDeckArray);
        Collections.shuffle(cardDeckArray);
        Collections.shuffle(cardDeckArray);
    }

    //Step 3 - give out first 6 cards to all the players(give to player and remove from main card deck)
    public void giveOutFirstDrawOfCardsToPlayers(){
        for(int i = 0; i < 6; i++){
            for(int p = 0; p < playersArray.size(); p++){
                playersArray.get(p).setCardInArray(cardDeckArray.remove(0));
            }
        }
    }

    /*Step 4 - 1. Shuffle card deck one more time
               2. Choose random card to make its suit a trump suit = true
               2. Shuffle card deck one more time ----------
               3. Put chosen card at the end of the deck (cardDeckArray.size() - 1)
               + return card for Step 5
     */
    public Card randomTrumpSuitChoice() throws Exception {
        shuffleCardDeck(); //1 let's try as first step
        int randomCard = ThreadLocalRandom.current().nextInt(0, cardDeckArray.size()); //1
        Card card = cardDeckArray.get(randomCard);
        card.setTrumpSuitTrue();
        ArrayList<Card> beforeIndexGame = cardDeckArray;
//        shuffleCardDeck(); //2
        int chosenCardAt = cardDeckArray.indexOf(card);
        int lastCardAt = cardDeckArray.indexOf(cardDeckArray.get(cardDeckArray.size() - 1));
        Collections.swap(cardDeckArray, randomCard, cardDeckArray.size() - 1); //3

        ArrayList<Card> afterIndexGame = cardDeckArray;
//        if(beforeIndexGame == afterIndexGame) throw new Exception ("Collection Swap didn't work");

        return cardDeckArray.get(randomCard);
    }

    //Step 5 - Go over main card deck and players' cards to make chosen suit's cards.trumpSuit = true;
    public void makeChosenSuitsCards_TrumpSuitSetTrue(Card card){
        for(Card cardObj : cardDeckArray){
            if(cardObj.getCardSuit() == card.getCardSuit()){
                cardObj.setTrumpSuitTrue();
            }
        }

        for(Player player : playersArray){
            for(Card cardObj : player.getCardsArray()){
                if(cardObj.getCardSuit() == card.getCardSuit()){
                    cardObj.setTrumpSuitTrue();
                }
            }
        }
    }

    //Helper Functions
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
    //TODO: Create "Initialize52CardDeck" method, if needed

//        public ArrayList <Card> getAllCardsInDeck(){
//        return cardDeckArray;
//    }

//    public int getCardsArraySize(){
//        return cardDeckArray.size();
//    }
}