package com.example.finalproject.models.buildingsAndWarEquipment;

import javafx.scene.image.ImageView;

abstract public class NormalBuilding extends Building {
    public NormalBuilding(int health , int defenseRadiusCircle , ImageView imageView) {
        super("normal", health , defenseRadiusCircle , imageView);
    }
}