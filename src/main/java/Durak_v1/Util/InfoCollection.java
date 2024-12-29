package Durak_v1.Util;

import Durak_v1.Model.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Durak_v1.Main.playersArray;

public class InfoCollection {
    final List<Integer> possibleCardDecks = Arrays.asList(36, 52);

    //Check card deck choice
    public boolean cardDeckChoice(int cardsN){
        return possibleCardDecks.contains(cardsN);
    }

    //TODO if there's time left
//    //Check names (IDs) and save if validation passed
//    public boolean playersSaveCheck(String name){
//        for(Player playerObj : playersArray){
//            if(playerObj.getName().equals(name)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void playerNameCollect(String name){
//        System.out.println("Please enter different name, since player with name "
//                + name + " already exists");
//    }

    //Limits of numbers of player depending on the card deck and rules
//    public void numberOfPlayers(int playersN){
//
//    }
}
