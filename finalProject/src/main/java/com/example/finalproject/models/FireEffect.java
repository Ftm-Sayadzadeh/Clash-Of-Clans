package com.example.finalproject.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireEffect extends ImageView {
    private final String path = this.getClass().getResource("/com/example/finalproject/img/pngwing.com.png").toString();
    public FireEffect() {
        this.setImage(new Image(path));
        this.setFitWidth(61);
        this.setFitHeight(82);
    }
}
