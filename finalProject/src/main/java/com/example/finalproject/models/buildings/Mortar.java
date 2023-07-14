package com.example.finalproject.models.buildings;

import javafx.scene.image.ImageView;

public class Mortar extends DefenseBuilding {
    public Mortar(int health, int attackPower, int attackSpeed , ImageView imageView) {
        super(health, attackPower, attackSpeed , imageView);
//        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/air_defense_13.png").toString()));
    }
}
