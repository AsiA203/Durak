package Durak_v1;

import Durak_v1.Controller.GameController;
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

    public static void main(String[] args) throws Exception {
        //Players and Card Deck Info
        Scanner scanner = new Scanner(System.in);
        InfoCollection infoCollection = new InfoCollection();

        //Getting Players number
        System.out.println("Please enter how many people will play?"); //2 for now, maybe later add logic players-cardDeck if needed
        int numOfPlayers = scanner.nextInt();

        //Getting Players Names (IDs) //TODO finish util method (check if exist?)
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
//        System.out.println(playersArray);
//        for (Player player : playersArray) {
//            System.out.println(player.getAllCardsDefaultToSting());
//        }

        //Checking if the CardTypes getValue() is working correctly -> CORRECT
//        System.out.println(CardTypes.values()[0]);

        //Initializing Game
        GameController gameController = new GameController();
        gameController.initializeCards(cardDeck); //Step 1

        //Checking if initializing correct -> CORRECT
//        System.out.println(cardDeckArray.size());
        //before shuffling card deck
//        for (Card card : cardDeckArray) {
//            System.out.println(card);
//        }


        //shuffling cards in main deck
        gameController.shuffleCardDeck(); //Step 2

        //checking cardDeckArray size, and it was shuffled correctly -> CORRECT
//        System.out.println("________________________________________________________" +
//                "\nAfter shuffling card deck");
//        System.out.println(cardDeckArray.size());
//        for (Card card : cardDeckArray) {
//            System.out.println(card);
//        }


        //First Draw (giving out first 6 cards to players)
        gameController.giveOutTheFirstDraw(); //Step 3

        //Checking cards of players -> CORRECT
//        for (Player player : playersArray) {
//            System.out.println(player.getAllCardsDefaultToSting());
//        }

        //Checking if first draw correct by number -> CORRECT
//        System.out.println("Card Deck: " + gameController.getCardsArraySize());
//        System.out.println("Player1: " + gameController.getCardsArraySizeOfThePlayer(playersArray.get(0).getName()));
//        System.out.println("Player2: " + gameController.getCardsArraySizeOfThePlayer(playersArray.get(1).getName()));

        //Initialize TrumpSuit from main card deck randomly
        gameController.makeChosenSuitsCards_TrumpSuitSetTrue(gameController.randomTrumpSuitChoice());

        //checking which card from main deck was chosen for Trump Suit Card
        System.out.print(gameController.randomTrumpSuitChoice().toStringFull());

        //Checking if all cards with chosen suit from main cardDeck was set to true
        System.out.println(cardDeckArray.size());
        for (Card card : cardDeckArray) {
            System.out.println(card.toStringFull());
        }

        //Checking if all cards with chosen suit on hands of players was set to true
        for (Player player : playersArray) {
            System.out.println(player.getAllCardsDefaultToSting());
        }
    }
}
