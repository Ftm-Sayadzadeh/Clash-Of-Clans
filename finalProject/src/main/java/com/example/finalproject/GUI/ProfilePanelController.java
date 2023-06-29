package com.example.finalproject.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePanelController implements Initializable {
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
    void backHome(MouseEvent event) throws IOException {
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username_lbl.setText(HomeController.player.getUsername());
        password_lbl.setText(HomeController.player.getPassword());
        level_lbl.setText(Integer.toString(HomeController.player.getLevel()));
        numOfWins_lbl.setText(Integer.toString(HomeController.player.getNumOfWins()));
        numOfLosses_lbl.setText(Integer.toString(HomeController.player.getNumOfLosses()));
        mapID_lbl.setText(Integer.toString(HomeController.player.getMapID()));
    }
}
