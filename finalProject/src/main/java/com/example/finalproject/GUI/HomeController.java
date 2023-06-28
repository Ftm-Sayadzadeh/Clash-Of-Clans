package com.example.finalproject.GUI;

import com.example.finalproject.controller.GameController;
import com.example.finalproject.models.Map;
import com.example.finalproject.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HomeController {
    public static Player player;//= new Player("ala" , "12345678" , 4,1,1,1);
    @FXML
    private Button login_btn;

    @FXML
    private ImageView logout_btn;

    @FXML
    private Button play_btn;

    @FXML
    private ImageView profile_btn;

    @FXML
    private Button signup_btn;

    @FXML
    void logIn(ActionEvent event) throws IOException {
        new SignIn(true).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        HomeController.player = null;
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void playButton(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        new StartPage().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void showProfile(MouseEvent event) {

    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        new SignIn(false).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    public void setPageItem(){
        if(player != null){
            signup_btn.setVisible(false);
            login_btn.setVisible(false);
            logout_btn.setVisible(true);
            profile_btn.setVisible(true);
            play_btn.setVisible(true);
        }
        else{
            logout_btn.setVisible(false);
            profile_btn.setVisible(false);
            play_btn.setVisible(false);
            signup_btn.setVisible(true);
            login_btn.setVisible(true);
        }
    }
}
