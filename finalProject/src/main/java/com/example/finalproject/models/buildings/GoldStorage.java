package com.example.finalproject.models.buildings;

import javafx.scene.image.Image;

public class GoldStorage extends NormalBuilding {
    public GoldStorage(int health, int x , int y) {
        super(health , x , y);
        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/gold_storage_16.png").toString()));
    }
}
