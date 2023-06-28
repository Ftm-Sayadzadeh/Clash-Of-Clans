package com.example.finalproject.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class StartPage extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/finalproject/startGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 560);
        ((StartPageController)fxmlLoader.getController()).setList();
        stage.setTitle("Loading Game...");
        stage.setScene(scene);
        stage.show();
    }
}
