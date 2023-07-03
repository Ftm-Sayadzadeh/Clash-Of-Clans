package com.example.finalproject.models.buildingsAndWarEquipment;
import javafx.scene.image.ImageView;

public class ArcherTower extends DefenseBuilding {
    public ArcherTower(int health, int attackPower, int attackSpeed , ImageView imageView) {
        super(health, attackPower, attackSpeed , 65,110 , imageView);
    }
}