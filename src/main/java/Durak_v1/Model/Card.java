package Durak_v1.Model;

import Durak_v1.Enums.Color;

public class Card {
    int id;
    int type;
    String name;
    Color color;

    public Card(int id, int type, String name, Color color) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
