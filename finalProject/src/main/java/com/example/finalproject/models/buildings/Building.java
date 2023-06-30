package com.example.finalproject.models.buildings;
import javafx.scene.image.ImageView;

abstract public class Building {
    private String type;
    private int health;
    private ImageView img;

    public Building(String type , int health , ImageView imageView) {
        this.type = type;
        this.health = health;
        img = imageView;
    }
    public boolean isAlive() {
        return getHealth() >= 0;
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

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
}
