package Durak_v1.Util;

import Durak_v1.Model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Durak_v1.Main.cardDeck;

public class InfoCollection {
    final List<Integer> possibleCardDecks = Arrays.asList(36, 52);

    //Check card deck choice
    public boolean cardDeckChoice(int cardsN){
        return possibleCardDecks.contains(cardsN);
    }

    //Limits of numbers of player depending on the card deck and rules
//    public void numberOfPlayers(int playersN){
//
//    }
}
