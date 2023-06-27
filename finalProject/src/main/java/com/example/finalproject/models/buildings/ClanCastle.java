package com.example.finalproject.models.buildings;

import javafx.scene.image.Image;

public class ClanCastle extends NormalBuilding {
    public ClanCastle(int health , int x , int y) {
        super(health , x , y);
        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/clan_castle_1.png").toString()));
    }
}
