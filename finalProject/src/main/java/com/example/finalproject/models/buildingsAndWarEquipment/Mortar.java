package com.example.finalproject.models.buildingsAndWarEquipment;

import javafx.scene.image.ImageView;

public class Mortar extends DefenseBuilding {
    public Mortar(int health, int attackPower, int attackSpeed , ImageView imageView) {
        super(health, attackPower, attackSpeed , 60 , 140 , imageView);
    }
}