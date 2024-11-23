package Durak_v1.Enums;

public enum CardTypes {
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private final int value;

    CardTypes(int value) {
        this.value = value;
    }

    public int getCardTypeInt(){
        return (value);
    }
}
