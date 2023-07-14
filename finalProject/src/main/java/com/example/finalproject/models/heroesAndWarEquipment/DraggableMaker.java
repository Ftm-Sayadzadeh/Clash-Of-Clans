package com.example.finalproject.models.heroesAndWarEquipment;

import com.example.finalproject.GUI.GameGroundController;
import javafx.scene.Node;

public class DraggableMaker {
    private static double mouseAnchorX;
    private static double mouseAnchorY;

    public static void makeDraggable(Node node , Hero h) {
        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });
        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
        });
        node.setOnMouseReleased(mouseEvent -> {
            GameGroundController.allHeroesInGround.add(h);
        });
    }
}
