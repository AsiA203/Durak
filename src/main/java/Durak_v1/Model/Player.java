package Durak_v1.Model;

public class Player {
    private int id;
    private String name;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
