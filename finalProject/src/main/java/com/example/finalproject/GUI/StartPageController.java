package com.example.finalproject.GUI;

import com.example.finalproject.controller.GameController;
import com.example.finalproject.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class StartPageController {
    @FXML
    private ImageView back_btn;

    @FXML
    private ImageView map1_img;

    @FXML
    private ImageView map2_img;

    @FXML
    private ImageView map3_img;

    @FXML
    private ImageView map4_img;

    @FXML
    private ImageView map5_img;
    @FXML
    private Label randomPlayerInfo;

    @FXML
    void backHome(MouseEvent event) throws IOException {
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    @FXML
    void accept(ActionEvent event) throws IOException {
        GameGroundController.mapID = mapID;
        GameGroundController.competitorPlayer = competitor;
        new HeroesSelectionPage().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    @FXML
    void reject(ActionEvent event) {
        setRandomMap();
    }
    private int mapID;
    private Player competitor;
    public void setRandomMap() {
        ArrayList<Player> players = GameController.players;
        players.removeIf(p -> Objects.equals(p.getUsername(), HomeController.player.getUsername()));

        Random random = new Random();
        int randomInt = random.nextInt(0,players.size()-1);
        competitor = players.get(randomInt);
        mapID = players.get(randomInt).getMapID();

        randomPlayerInfo.setText(players.get(randomInt).getUsername() + "  - Level "  + players.get(randomInt).getLevel());
        map1_img.setVisible(false);
        map2_img.setVisible(false);
        map3_img.setVisible(false);
        map4_img.setVisible(false);
        map5_img.setVisible(false);
        if(mapID == 1){
            map1_img.setVisible(true);
        }
        else if(mapID == 2){
            map2_img.setVisible(true);
        }
        else if(mapID == 3){
            map3_img.setVisible(true);
        }
        else if(mapID == 4){
            map4_img.setVisible(true);
        }
        else if(mapID == 5){
            map5_img.setVisible(true);
        }
    }

}

