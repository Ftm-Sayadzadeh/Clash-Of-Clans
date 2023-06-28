package com.example.finalproject.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameGround extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/finalproject/gameGround.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 560);
        //((GameGroundController)fxmlLoader.getController()).mapID = 1;
        ((GameGroundController)fxmlLoader.getController()).setMap();
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }
}
