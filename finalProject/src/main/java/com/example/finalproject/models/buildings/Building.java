package com.example.finalproject.models.buildings;

import javafx.scene.image.ImageView;

abstract public class Building extends ImageView {
    private String type;
    private int health;

    public Building(String type , int health , double x , double y) {
        this.type = type;
        this.health = health;
        this.setFitWidth(60);
        this.setFitHeight(60);
        this.setX(x);
        this.setY(y);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
