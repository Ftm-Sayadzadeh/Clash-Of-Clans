package com.example.finalproject.models.buildings;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AirDefence extends DefenseBuilding {
    public AirDefence(int health, int attackPower, int attackSpeed , ImageView imageView) {
        super(health, attackPower, attackSpeed , imageView);
//        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/air_defense_13.png").toString()));
    }
}
