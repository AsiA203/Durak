package Durak_v1.Enums;

public enum MoveStatus {
    MOVE_VALID("Move is valid"),
    MOVE_INVALID("Move is invalid"),
    INPUT_FORMAT_ERROR("Format of input move is not correct. Please follow this example-> ");
    //TODO INPUT_FORMAT_ERROR


    private final String message;

    MoveStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}