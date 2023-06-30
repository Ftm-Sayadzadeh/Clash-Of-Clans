package com.example.finalproject.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HeroesInfoPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/finalproject/heroesInfoPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 560);
        ((HeroesInfoPageController)fxmlLoader.getController()).setInfos();
        stage.setTitle("Heroes");
        stage.setScene(scene);
        stage.show();
    }
}
