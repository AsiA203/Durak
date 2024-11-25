package Durak_v1;

import Durak_v1.Enums.CardSuit;
import Durak_v1.Enums.CardTypes;
import Durak_v1.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int cardDeck;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Please enter how many people will play?"); //2 for now
        int numOfPlayers = scanner.nextInt();

        System.out.println("Which deck do you want to use for Durak"); //32 cards for now
        cardDeck = scanner.nextInt();

        for (int i = 0; i < numOfPlayers; i++){
            Scanner scForLoop = new Scanner(System.in);
            System.out.println("Please enter name of player #" + (i+1));
            Player player = new Player(i + 1, scForLoop.nextLine());
            players.add(player);
        }

        System.out.println(players);
        System.out.println(players.get(0).getAllCards());
        System.out.println(CardTypes.values()[0]);
    }
}
