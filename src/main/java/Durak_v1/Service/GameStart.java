package Durak_v1.Service;

import Durak_v1.Enums.CardTypes;
import Durak_v1.Main;
import Durak_v1.Model.Card;
import Durak_v1.Model.CardInfo;

import java.util.ArrayList;
import java.util.Arrays;

public class GameStart {
    ArrayList<Card> cardStack = new ArrayList<>();
    Main main = new Main();

    public void GameStartMethod(){

    }

    public void initializeAllCards(){
        int cardDeck = Main.cardDeck;
    }

    //Helper Functions
    public void initialize32CardDeck(){
        for (int i = 0; i < 32; i++){

            //Hearts
            for (int h = 0; i < 9; i++){
                CardInfo cardInfo = new CardInfo(i + 6, CardTypes.va)
                Card card = new Card()
            }
        }
    }
}
