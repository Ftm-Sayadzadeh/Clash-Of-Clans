package com.example.finalproject.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GameResultController implements Initializable {
    public static Boolean win;
    @FXML
    private Label headOfPage_lbl;

    @FXML
    private Label resultText;

    @FXML
    void backHome(MouseEvent event) throws IOException {
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void nextBattle(MouseEvent event) throws SQLException, IOException, ClassNotFoundException {
        new StartPage().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(win){
            headOfPage_lbl.setText("CONGRATULATIONS :)");
            resultText.setText("You win this battle and move on" + "\n" + " to the next level in your next game!");
        }
        else{
            headOfPage_lbl.setText("OHH... :(");
            resultText.setText("Don't be sad..." + "\n" + "You will win in the next game!");
        }
    }
}
