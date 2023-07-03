package com.example.finalproject.models.buildingsAndWarEquipment;

import com.example.finalproject.models.heroesAndWarEquipment.Hero;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb extends ImageView {
    private final String path = this.getClass().getResource("/com/example/finalproject/img/bomb_10.png").toString();

    public Bomb() {
        this.setImage(new Image(path));
        this.setFitWidth(20);
        this.setFitHeight(20);

        this.setTranslateX(0);
        this.setTranslateY(0);
    }

    public void attack(Hero h, Building building) {
        //System.out.println("building bomb");
        if(h.isAlive()) {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(this);
            transition.setToX(h.getBound().getCenterX() - building.getBound().getCenterX());
            transition.setToY(h.getBound().getCenterY() - building.getBound().getCenterY());
            transition.play();
            h.setHealth(h.getHealth() - 12);
        }
    }
}