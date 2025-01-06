package Durak_v1;

import Durak_v1.Controller.GameInitializeController;
import Durak_v1.Enums.CardTypes;
import Durak_v1.Enums.MoveStatus;
import Durak_v1.Model.Card;
import Durak_v1.Model.CardMove;
import Durak_v1.Model.Player;
import Durak_v1.Service.MoveValidatorService;
import Durak_v1.Util.InfoCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Card> cardDeckArray = new ArrayList<>();
    public static ArrayList<Player> playersArray = new ArrayList<>();
    public static int cardDeck;
    public static Player winnerPlayer = null;
    public static Card trumpCard = null;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MoveValidatorService moveValidatorService = new MoveValidatorService();

        //Info Collection
        gameInfoCollection();
        //Game Initialize - Step 1 - 8
        gameInitialize();

        //Game Start
        String moveFormatRequest =
                "Please enter you move in this format, examples: \n" +
                "6-Jack \nA-Jack (meaning ACE) \nK-Club (meaning King)\n" +
                "If you want to select several cards in one move, please use comma(,) " +
                "between card names.";
        System.out.println(moveFormatRequest);
        Player currentPlayer = new Player();
        while(winnerPlayer == null){
            for(int i = 1; i < 10000; i++){
                //Which players turn
                if(i % 2 == 0){
                    currentPlayer = playersArray.get(1);
                } else currentPlayer = playersArray.get(0);

                System.out.println("Player " + currentPlayer.getName() +" enter your move: ");
                System.out.println(currentPlayer.getCardsArray());

                CardMove cardMove;
                MoveStatus moveStatus;
                do{
                    String move = scanner.nextLine();
                    List<String> moves = moveValidatorService.isMoveFormatCorrect(move);

                    //format check
                    if(moves == null) System.out.println(MoveStatus.INPUT_FORMAT_ERROR);
                    else{
                        cardMove = new CardMove(moves.get(0), currentPlayer, false);
                    }


                } while(moveStatus != MoveStatus.MOVE_VALID && moveStatus == MoveStatus.INPUT_FORMAT_ERROR);
            }
        } System.out.println("Player " + winnerPlayer.getName() + "is winner! Game Over.");
    }

    //Players and Card Deck Info Collection
    public static void gameInfoCollection() {
        //Players and Card Deck Info
        Scanner scanner = new Scanner(System.in);
        InfoCollection infoCollection = new InfoCollection();

        //Getting Players number
        System.out.println("Please enter how many people will play? Only 2 for now"); //2 for now, maybe later add logic players-cardDeck if needed
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
        trumpCard = chosenCard;

        /*Putting chosen TrumpSuitCard on the end of the deck and
        make all other cards with same suit to trumpSuit = true*/
        gameController.putChosenTrumpSuitCardAtTheEndOfTheMainCardDeck(chosenCard); //Step 5
        gameController.makeChosenSuitsCards_TrumpSuitSetTrue(chosenCard); //Step 6

        //Find player with the least ranked trump suit card
        Player gameStarterPlayer = gameController.playerWithLeastStrongTrumpSuitCard(chosenCard); //Step 7

        //ReOrder order of player (playerArray) depending on the player from Step 7
        gameController.createNewOrderOfPlayersBeforeGameStart(gameStarterPlayer); //Step 8
    }

    public static void moveStatusHelper(MoveStatus result) {
        switch (result) {
            case MOVE_VALID: {
                System.out.println(MoveStatus.MOVE_VALID);
                break;
            }

            case MOVE_INVALID: {
                System.out.println(MoveStatus.MOVE_INVALID);
                break;
            }

            case INPUT_FORMAT_ERROR: {
                System.out.println(MoveStatus.INPUT_FORMAT_ERROR);
                break;
            }
        }
    }
}
