package com.example.finalproject.models.buildings;

import javafx.scene.image.Image;

public class ArcherTower extends DefenseBuilding {
    public ArcherTower(int health, int attackPower, int attackSpeed , int x , int y) {
        super(health, attackPower, attackSpeed , x, y);
        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/archer_tower_21.png").toString()));
    }
}
