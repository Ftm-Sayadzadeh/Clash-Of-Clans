package com.example.finalproject.models.heroesAndWarEquipment;

import com.example.finalproject.models.buildingsAndWarEquipment.Building;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Arrow extends ImageView {
    private final String path = this.getClass().getResource("/com/example/finalproject/img/Shot.png").toString();

    public Arrow(){
        this.setImage(new Image(path));
        this.setFitWidth(41);
        this.setFitHeight(15);

        this.setTranslateX(0);
        this.setTranslateY(0);
    }
    public void attack (Hero h , Building building){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        //transition.setDuration(Duration.seconds(2));
        //transition.setCycleCount(3);
//        transition.setFromX(h.getBound().getCenterX());
//        transition.setFromY(h.getBound().getCenterY());
//        transition.setByX(building.getBound().getCenterX());
//        transition.setByY(building.getBound().getCenterY());
        transition.setToX(building.getBound().getCenterX() - h.getBound().getCenterX());
        transition.setToY(building.getBound().getCenterY() - h.getBound().getCenterY());
        transition.play();
    }
}
