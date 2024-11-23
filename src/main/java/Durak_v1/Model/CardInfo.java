package Durak_v1.Model;

public class CardInfo{
    int rank;
    String type;

    public CardInfo(int rank, String type){
        this.rank = rank;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
