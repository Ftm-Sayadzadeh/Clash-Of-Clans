package com.example.finalproject.GUI;

import com.example.finalproject.controller.GameController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class StartPageController {

    public StartPageController() throws SQLException, ClassNotFoundException {
    }
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
    private Button next_btn;

    @FXML
    private ListView<String> playerList;

    @FXML
    void backHome(MouseEvent event) throws IOException {
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void nextButton(ActionEvent event) throws IOException {
        GameGroundController.mapID = mapID;
        new HeroSelectionPage().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    private final String[] playersUsername = new String[GameController.players.size() - 1];
    private String currentChoice;
    private int mapID;
    public void setList() throws SQLException, ClassNotFoundException {
        int j = 0 ;
        for (int i = 0 ; i< GameController.players.size() ; i++) {
            if(!Objects.equals(GameController.players.get(i).getUsername(), HomeController.player.getUsername())) {
                playersUsername[j] = GameController.players.get(i).getUsername() + " - level " + GameController.players.get(i).getLevel() ;
                j++;
            }
        }
        playerList.getItems().addAll(playersUsername);
        playerList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s1, String s2) {
                currentChoice = playerList.getSelectionModel().getSelectedItem();
                int index = 0;
                for (int i = 0; i < GameController.players.size(); i++) {
                    // add all player except this player
                    if (GameController.players.get(i).getUsername().equals(currentChoice)) {
                        index = i;
                        break;
                    }
                }
                mapID = GameController.players.get(index).getMapID();
                if(mapID == 1){
                    map1_img.setVisible(false);
                    map2_img.setVisible(false);
                    map3_img.setVisible(false);
                    map4_img.setVisible(false);
                    map5_img.setVisible(false);
                    map1_img.setVisible(true);
                }
                else if(mapID == 2){
                    map1_img.setVisible(false);
                    map2_img.setVisible(false);
                    map3_img.setVisible(false);
                    map4_img.setVisible(false);
                    map5_img.setVisible(false);
                    map2_img.setVisible(true);
                }
                else if(mapID == 3){
                    map1_img.setVisible(false);
                    map2_img.setVisible(false);
                    map3_img.setVisible(false);
                    map4_img.setVisible(false);
                    map5_img.setVisible(false);
                    map3_img.setVisible(true);
                }
                else if(mapID == 4){
                    map1_img.setVisible(false);
                    map2_img.setVisible(false);
                    map3_img.setVisible(false);
                    map4_img.setVisible(false);
                    map5_img.setVisible(false);
                    map4_img.setVisible(true);
                }
                else if(mapID == 5){
                    map1_img.setVisible(false);
                    map2_img.setVisible(false);
                    map3_img.setVisible(false);
                    map4_img.setVisible(false);
                    map5_img.setVisible(false);
                    map5_img.setVisible(true);
                }
            }
        });
    }

}

