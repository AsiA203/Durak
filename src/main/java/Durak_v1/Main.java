package Durak_v1;

import Durak_v1.Controller.GameInitializeController;
import Durak_v1.Enums.CardTypes;
import Durak_v1.Model.Card;
import Durak_v1.Model.Player;
import Durak_v1.Util.InfoCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Card> cardDeckArray = new ArrayList<>();
    public static ArrayList<Player> playersArray = new ArrayList<>();
    public static int cardDeck;
    public static Player winnerPlayer = null;

    public static void main(String[] args) throws Exception {
        //Players and Card Deck Info
        Scanner scanner = new Scanner(System.in);
        InfoCollection infoCollection = new InfoCollection();

        //Getting Players number
        System.out.println("Please enter how many people will play?"); //2 for now, maybe later add logic players-cardDeck if needed
        int numOfPlayers = scanner.nextInt();

        //Getting Players Names (IDs) //TODO finish util method (check if exist?) - Priority 2
        for (int i = 0; i < numOfPlayers; i++) {
            Scanner scForLoop = new Scanner(System.in);
            System.out.println("Please enter name of player #" + (i + 1));
            Player player = new Player(scForLoop.nextLine());
            playersArray.add(player);
        }

        //Getting Card Deck Info
        String cardDeckQuestion = "Which deck do you want to use for Durak? 36 or 52"; //36 cards for now
        do {
            System.out.println(cardDeckQuestion);
            cardDeck = scanner.nextInt();
        } while (!infoCollection.cardDeckChoice(cardDeck));


        //Checking if players don't have any cards yet -> CORRECT
        System.out.println(playersArray);
        for (Player player : playersArray) {
            System.out.println(player.getAllCardsDefaultToSting());
        }

        //Checking if the CardTypes getValue() is working correctly -> CORRECT
        System.out.println(CardTypes.values()[0]);

        /*Game Initialize - Step 1 - 8*/
        gameInitialize();

        //Game Start
        ArrayList<Card> movesArray = new ArrayList<>();
        String moveFormatRequest = "Please enter you move in this format, examples: \n " +
                "- 6Jack \n - AJack (Ace) \n - or KClub (King)";
        while(winnerPlayer == null){
            for(int i = 0; i < playersArray.size(); i++){
                System.out.println("Player " + playersArray.get(i).getName()
                        + ", please choose your card/cards for a move from following cards."
                + "Please move in this format and in order -> 6Jack or AJack( or KClub");
                System.out.println(playersArray.get(i).getCardsArray().toString());
                String currentMove =
            }
        }
    }








    //Game Initialize Method to call all needed functions from GameInitializeController
    private static void gameInitialize() throws Exception {
        //Game Initialize
        GameInitializeController gameController = new GameInitializeController();
        gameController.initializeCards(cardDeck); //Step 1

        //shuffling cards in main deck
        gameController.shuffleCardDeck(); //Step 2

        //First Draw (giving out first 6 cards to players)
        gameController.giveOutTheFirstDraw(); //Step 3

        //Initialize TrumpSuit from main card deck randomly
        Card chosenCard = gameController.randomTrumpSuitChoice(); //step 4

        /*Putting chosen TrumpSuitCard on the end of the deck and
        make all other cards with same suit to trumpSuit = true*/
        gameController.putChosenTrumpSuitCardAtTheEndOfTheMainCardDeck(chosenCard); //Step 5
        gameController.makeChosenSuitsCards_TrumpSuitSetTrue(chosenCard); //Step 6

        //Find player with the least ranked trump suit card
        Player gameStarterPlayer = gameController.playerWithLeastStrongTrumpSuitCard(chosenCard); //Step 7

        //ReOrder order of player (playerArray) depending on the player from Step 7
        gameController.createNewOrderOfPlayersBeforeGameStart(gameStarterPlayer); //Step 8
    }
}
