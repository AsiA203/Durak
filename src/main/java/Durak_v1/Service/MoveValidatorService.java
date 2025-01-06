package Durak_v1.Service;

public class MoveValidatorService {
    //Check if move/moves are in correct format
    public boolean isMoveFormatCorrect(String move){
        String[] moves;
        boolean status = false;
        if(move.contains(",")){
            moves = move.split(",");

            for(String moveObj: moves){
                status = checkMoveFormat(moveObj);
            }
            return status;

        } else return checkMoveFormat(move);
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
