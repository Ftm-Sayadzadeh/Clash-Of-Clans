package com.example.finalproject.models.buildingsAndWarEquipment;

import com.example.finalproject.models.heroesAndWarEquipment.Hero;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArrowOfArcherTower extends ImageView {
    private final String path = this.getClass().getResource("/com/example/finalproject/img/Shot.png").toString();

    public ArrowOfArcherTower() {
        this.setImage(new Image(path));
        this.setFitWidth(41);
        this.setFitHeight(15);

        this.setTranslateX(0);
        this.setTranslateY(0);
    }

    public void throwArrows(Hero h, Building building) {
//        System.out.println("building Arrow");
        if(h.isAlive()) {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(this);
            transition.setToX(h.getBound().getCenterX() - building.getBound().getCenterX());
            transition.setToY(h.getBound().getCenterY() - building.getBound().getCenterY());
//            transition.setCycleCount(3);
            transition.play();
            h.setHealth(h.getHealth() - 10);
        }
    }
}