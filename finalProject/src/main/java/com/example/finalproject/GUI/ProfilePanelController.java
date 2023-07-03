package com.example.finalproject.GUI;

import com.example.finalproject.controller.PlayerController;
import com.example.finalproject.models.Player;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ProfilePanelController {
    @FXML
    private Label level_lbl;

    @FXML
    private Label mapID_lbl;

    @FXML
    private Label numOfLosses_lbl;

    @FXML
    private Label numOfWins_lbl;

    @FXML
    private Label password_lbl;

    @FXML
    private Label username_lbl;
    @FXML
    private ImageView map1;

    @FXML
    private ImageView map2;

    @FXML
    private ImageView map3;

    @FXML
    private ImageView map4;

    @FXML
    private ImageView map5;
    @FXML
    void backHome(MouseEvent event) throws IOException {
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void setData(){
        //read data first
        PlayerController playerController = new PlayerController();
        Player player;
        try {
            player = playerController.login(HomeController.player.getUsername() , HomeController.player.getPassword());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        username_lbl.setText(player.getUsername());
        password_lbl.setText(player.getPassword());
        level_lbl.setText(Integer.toString(player.getLevel()));
        numOfWins_lbl.setText(Integer.toString(player.getNumOfWins()));
        numOfLosses_lbl.setText(Integer.toString(player.getNumOfLosses()));
        mapID_lbl.setText(Integer.toString(player.getMapID()));
        //--------------------------
        int mapID = player.getMapID();
        map1.setVisible(false);
        map2.setVisible(false);
        map3.setVisible(false);
        map4.setVisible(false);
        map5.setVisible(false);
        if(mapID == 1)
            map1.setVisible(true);
        else if (mapID == 2)
            map2.setVisible(true);
        else if (mapID == 3)
            map3.setVisible(true);
        else if (mapID == 4)
            map4.setVisible(true);
        else if (mapID == 5)
            map5.setVisible(true);
    }
}
