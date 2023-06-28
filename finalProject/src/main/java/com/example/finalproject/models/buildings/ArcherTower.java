package com.example.finalproject.models.buildings;
import javafx.scene.image.ImageView;

public class ArcherTower extends DefenseBuilding {
    public ArcherTower(int health, int attackPower, int attackSpeed , ImageView imageView) {
        super(health, attackPower, attackSpeed , imageView);
//        this.setImage(new Image(this.getClass().getResource("/com/example/finalproject/img/archer_tower_21.png").toString()));
    }
}
