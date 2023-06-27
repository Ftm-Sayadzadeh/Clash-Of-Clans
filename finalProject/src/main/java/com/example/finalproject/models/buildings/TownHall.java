package com.example.finalproject.models.buildings;

import javafx.scene.image.Image;

public class TownHall extends NormalBuilding {
    public TownHall(int health , int x , int y) {
        super(health , x , y);
        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/town_hall_15.png").toString()));
    }
}
