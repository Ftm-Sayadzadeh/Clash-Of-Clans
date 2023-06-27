package com.example.finalproject.models.buildings;

import javafx.scene.image.Image;

public class AirDefence extends DefenseBuilding {
    public AirDefence(int health, int attackPower, int attackSpeed , int x , int y) {
        super(health, attackPower, attackSpeed , x , y);
        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/air_defense_13.png").toString()));
    }
}
