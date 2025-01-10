package Durak_v1.Service;

import java.util.Arrays;
import java.util.List;

public class MoveValidatorService2 {

//    public MoveStatus isMoveValid(CardMove cardMove){
//        //1st check
////        boolean isFormatCorrect = isMoveFormatCorrect(move);
////        if(!isFormatCorrect) return MoveStatus.INPUT_FORMAT_ERROR;
//
//        //2nd check
//
//
//     }


    //Check if move/moves are in correct format
    public List<String> isMoveFormatCorrect(String move){
        String[] moves = new String[6];
        boolean status = false;
        if(move.contains(",")){
            moves = move.split(",");

            for(String moveObj: moves){
                status = checkMoveFormat(moveObj);
            }
        }

        if(status){

            return Arrays.asList(moves);
        } else return null;
    }


    //Helper Functions
    public boolean checkMoveFormat(String move){
        String [] moveSplit = move.split("-");
        boolean status;

        switch(moveSplit[0]){
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "J":
            case "Q":
            case "K":
            case "A":
                status = true;
                break;
            default: status = false;
        }

        switch(moveSplit[1]){
            case "Jack":
            case "Queen":
            case "King":
            case "Ace":
                status = true;
                break;
            default: status = false;
        }

        return status;
    }
}
