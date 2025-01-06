package Durak_v1.Model;

public class CardMove {
//    int order;
    Card card;
    Player player;
    boolean isBeaten;

    public CardMove(){};

    public CardMove(/*int order,*/ Card card, Player player, boolean isBeaten){
//        this.order = order;
        this.card = card;
        this.player = player;
        this.isBeaten = isBeaten;
    }
//    public void setOrder(int order) {
//        this.order = order;
//    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setIsBeaten(boolean isBeaten) {
        this.isBeaten = isBeaten;
    }

    public Card getCard() {
        return card;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isBeaten() {
        return isBeaten;
    }

//    public int getOrder() {
//        return order;
//    }

    @Override
    public String toString(){
        return /*"Order: " + this.getOrder() + */" Card: " + this.card.toString() + ", Player: "
                + this.player.getName() + ", Is beaten?: " + this.isBeaten;
    }
}
