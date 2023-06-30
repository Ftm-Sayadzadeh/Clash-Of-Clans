package com.example.finalproject.GUI;

import com.example.finalproject.controller.GameController;
import com.example.finalproject.controller.PlayerController;
import com.example.finalproject.exceptions.DuplicateUsername;
import com.example.finalproject.exceptions.InvalidPassword;
import com.example.finalproject.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInController {
    public boolean existedPlayer;
    @FXML
    private ImageView backHome;

    @FXML
    private RadioButton battleGround;

    @FXML
    private RadioButton cityAtNight;

    @FXML
    private RadioButton defaultMap;

    @FXML
    private RadioButton iceGround;

    @FXML
    private Button login_btn;

    @FXML
    private Pane login_pane;

    @FXML
    private ToggleGroup maps;

    @FXML
    private TextField password_txt;

    @FXML
    private Button signup_btn;

    @FXML
    private Pane signup_pane;

    @FXML
    private TextField signup_password_txt;

    @FXML
    private TextField signup_username_txt;

    @FXML
    private TextField username_txt;

    @FXML
    private RadioButton winterCity;

    @FXML
    void backHome(MouseEvent event) throws IOException {
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        int mapID = 0;
        if(defaultMap.isSelected()){
            mapID = 1;
        }
        else if(winterCity.isSelected()){
            mapID = 2;
        }
        else if(iceGround.isSelected()){
            mapID = 3;
        }
        else if(cityAtNight.isSelected()){
            mapID = 4;
        }
        else if(battleGround.isSelected()){
            mapID = 5;
        }
        PlayerController playerController = new PlayerController();
        try{
            //check username
            playerController.checkUsername(signup_username_txt.getText());
            //check password
            Pattern passwordPattern = Pattern.compile("^\\S{8,}$");
            Matcher passwordMather = passwordPattern.matcher(signup_password_txt.getText());
            if(!passwordMather.find())
                throw new InvalidPassword();
            //add to database and login
            playerController.insertPlayer(signup_username_txt.getText() , signup_password_txt.getText() , mapID);
            Player signupPlayer = playerController.login(signup_username_txt.getText() , signup_password_txt.getText());
            HomeController.player = signupPlayer;
            //--------------------------
            //GameController.readAllPlayersFromDatabase();
            //--------------------------
            new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
        } catch (SQLException se) {
            throw new RuntimeException(se);
        } catch (ClassNotFoundException cfe) {
            throw new RuntimeException(cfe);
        } catch (DuplicateUsername e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Duplicated username!");
            alert.setContentText("Another member use this username so please enter another one :)");
            alert.showAndWait();
        } catch (InvalidPassword e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid password!");
            alert.setContentText("You have entered an invalid password. It should contain 8 or more char without space!");
            alert.showAndWait();
        }
    }

    @FXML
    void signin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        PlayerController playerController = new PlayerController();
        Player signinPlayer = null;
        try {
            signinPlayer = playerController.login(username_txt.getText() , password_txt.getText());
        } catch (SQLException se) {
            throw new RuntimeException(se);
        } catch (ClassNotFoundException cne) {
            throw new RuntimeException(cne);
        }
        if(signinPlayer != null ) {
            HomeController.player = signinPlayer;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("NOT FOUND!");
            alert.setHeaderText("NOT FOUND USER!");
            alert.setContentText("Enter your info correctly and if you don't have an account , you should sign up first!");
            alert.showAndWait();
        }
        //GameController.readAllPlayersFromDatabase();
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    public void setPane(){
        if(this.existedPlayer){
            signup_pane.setVisible(false);
            login_pane.setVisible(true);
        }
        else{
            login_pane.setVisible(false);
            signup_pane.setVisible(true);
        }
    }
}


