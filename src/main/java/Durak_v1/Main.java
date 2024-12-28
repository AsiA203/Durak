package Durak_v1;

import Durak_v1.Controller.GameController;
import Durak_v1.Enums.CardTypes;
import Durak_v1.Model.Card;
import Durak_v1.Model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Players and Card Deck Info
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Please enter how many people will play?"); //2 for now
        int numOfPlayers = scanner.nextInt();

        String cardDeckQuestion = "Which deck do you want to use for Durak? 36 or 52"; //36 cards for now
        int cardDeck;
        do{
            System.out.println(cardDeckQuestion);
            cardDeck = scanner.nextInt();
        } while (cardDeck != 36 && cardDeck != 52);

        //Getting Players Names (IDs)
        for (int i = 0; i < numOfPlayers; i++){
            Scanner scForLoop = new Scanner(System.in);
            System.out.println("Please enter name of player #" + (i+1));
            Player player = new Player(i + 1, scForLoop.nextLine());
            players.add(player);
        }

        //Checking if players don't have any cards yet
        System.out.println(players);
        for(Player player : players){
            System.out.println(player.getAllCards());
        }

        //Checking if the CardTypes getValue() is working correctly
        System.out.println(CardTypes.values()[0]);

        //Initializing Game
        GameController gameController = new GameController();
        gameController.initializeCardsAndPlayers(players, cardDeck);

        //Checking if initializing correct
        ArrayList<Card> cards = gameController.getAllCardsInDeck();
        System.out.println(cards.size());
        //before shuffling card deck
        for(Card card : cards){
            System.out.println(card);
        }

        //after shuffling card deck
        System.out.println("________________________________________________________" +
                "\nAfter shuffling card deck");
        gameController.shuffleCardDeck();
        System.out.println(cards.size());
        for(Card card : cards){
            System.out.println(card);
        }

        //First Draw (giving out first 6 cards to players)
        gameController.giveOutTheFirstDraw();
        for(Player player : players){
            System.out.println(player.getAllCards());
        }

        //Checking if first draw correct
        System.out.println("Card Deck: " + gameController.getCardsArraySize());
        System.out.println("Player1: " + gameController.getCardsArraySizeOfThePlayer(players.get(0).getName()));
        System.out.println("Player2: " + gameController.getCardsArraySizeOfThePlayer(players.get(1).getName()));
    }
}
