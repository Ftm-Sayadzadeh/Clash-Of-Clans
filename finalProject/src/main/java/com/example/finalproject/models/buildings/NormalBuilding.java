package com.example.finalproject.models.buildings;

import javafx.scene.image.ImageView;

abstract public class NormalBuilding extends Building {
    public NormalBuilding(int health , ImageView imageView) {
        super("normal", health , imageView);
    }
}
