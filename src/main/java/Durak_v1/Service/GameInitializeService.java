package Durak_v1.Service;

import Durak_v1.Enums.*;
import Durak_v1.Model.Card;
import Durak_v1.Model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static Durak_v1.Main.cardDeckArray;
import static Durak_v1.Main.playersArray;

public class GameInitializeService {

    /*Game Initialize*/
    //Step 1 - initialize card deck depending on which was chosen
    public void initializeAllCards(int cardDeck) {
        //initialize 36 card deck
        if (cardDeck == 36) {
            initialize36CardDeck();
        }//TODO: 52 card deck if needed
    }

    //Step 2 - shuffle all cards after initializing
    public void shuffleCardDeck(/*int rangeStart, int rangeEnd*/) {
        //Manual - with range //TODO when extra time, after main game logic - Priority 2
//        int randomNumber = rangeStart + (int)(Math.random() * ((rangeEnd - rangeStart) + 1));
//        for(int i = 0; i < )

        //Build-in method use
        Collections.shuffle(cardDeckArray);
        Collections.shuffle(cardDeckArray);
        Collections.shuffle(cardDeckArray);
        Collections.shuffle(cardDeckArray);
    }

    //Step 3 - give out first 6 cards to all the players(give to player and remove from main card deck)
    public void giveOutFirstDrawOfCardsToPlayers() {
        for (int i = 0; i < 6; i++) {
            for (int p = 0; p < playersArray.size(); p++) {
                playersArray.get(p).setCardInArray(cardDeckArray.remove(0));
            }
        }
    }

    /*Step 4 - 1. Shuffle card deck one more time
               2. Choose random card to make its suit a trump suit = true
               + return card for Step 5
     */
    public Card randomTrumpSuitChoice() throws Exception {
        shuffleCardDeck(); //1

        int randomCard = ThreadLocalRandom.current().nextInt(0, cardDeckArray.size()); //2
        Card card = cardDeckArray.get(randomCard);
        card.setTrumpSuitTrue();

        return cardDeckArray.get(randomCard);
    }

    //Step 5 - Put chosen card at the end of the deck (cardDeckArray.size() - 1)
    public void putChosenTrumpSuitCardAtTheEndOfTheMainCardDeck(Card card) {
        putCardAtIndexInsideCardDeckArray(card, cardDeckArray.indexOf(card), cardDeckArray.size() - 1);
    }

    //Step 6 - Go over main card deck and players' cards to make chosen suit's cards.trumpSuit = true;
    public void makeChosenSuitsCards_TrumpSuitSetTrue(Card card) {
        for (Card cardObj : cardDeckArray) {
            if (cardObj.getCardSuit() == card.getCardSuit()) {
                cardObj.setTrumpSuitTrue();
            }
        }

        for (Player player : playersArray) {
            for (Card cardObj : player.getCardsArray()) {
                if (cardObj.getCardSuit() == card.getCardSuit()) {
                    cardObj.setTrumpSuitTrue();
                }
            }
        }
    }

    //Step 7 - determine who should go first (start game), player with the least ranked trump suit card
    public Player playerWithLeastStrongTrumpSuitCard(Card chosenCard) throws Exception /*from step 4*/ {
        ArrayList <Card> trumpSuitCardsOnPlayersHands = new ArrayList<>();
        for (Player player : playersArray) {
            for (Card cardObj : player.getCardsArray()) {
                if (cardObj.getCardSuit() == chosenCard.getCardSuit()) {
                    trumpSuitCardsOnPlayersHands.add(cardObj);

                    if(cardObj.getCardType().getCardTypeInt() == 6){
                        return player; //if someone has least ranked trump suit card, return player right away
                    }
                }
            }
        }

        if(trumpSuitCardsOnPlayersHands.size() > 1){
            Card leastRankedCard = trumpSuitCardsOnPlayersHands.get(0);
            for(Card cardObj : trumpSuitCardsOnPlayersHands){
                if(cardObj.getCardType().getCardTypeInt() < leastRankedCard.getCardType().getCardTypeInt()){
                    leastRankedCard = cardObj;
                }
            }
            return getPlayerWithCard(leastRankedCard); //return player with the least ranked trump suit card

        } else if(trumpSuitCardsOnPlayersHands.size() == 0){
            return playersArray.get(0); //return first player overall since nobody has trump suit cards on hand
        } else return getPlayerWithCard(trumpSuitCardsOnPlayersHands.get(0)); //return the player who only has a trump suit card on hand from whole group
    }

    //Helper Functions
    public Player getPlayerWithCard(Card card) throws Exception {
        for(Player player : playersArray){
            for (Card cardObj : player.getCardsArray()){
                if(cardObj == card){
                    return player;
                }
            }
        }
        throw new Exception("No player with this card at hand");
    }

    public void putCardAtIndexInsideCardDeckArray(Card card, int swapCardIndex, int putIntoIndex) {
        cardDeckArray.remove(swapCardIndex);
        cardDeckArray.add(putIntoIndex, card);

        //Collections.swap(cardDeckArray, randomCard, cardDeckArray.size() - 1);
        //if(beforeIndexGame == afterIndexGame) throw new Exception ("Collection Swap didn't work");
        //Could have been used ^, but not working for now //TODO find out why - Priority 4
    }

    public ArrayList<Card> getPlayersAllCardsOnHand(String playerName) throws Exception {
        for (Player player : playersArray) {
            if (player.getName().equals(playerName)) {
                return player.getCardsArray();
            }
        }
        throw new Exception("No player with this name " + playerName + " was not found.");
    }

    public int getCardsArraySizeOfThePlayer(String playerName) throws Exception {
        return getPlayersAllCardsOnHand(playerName).size();
    }

    public void initialize36CardDeck() {
        for (int i = 0; i < 9; i++) {
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