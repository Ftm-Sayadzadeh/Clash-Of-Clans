package com.example.finalproject.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HeroesSelectionPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/finalproject/heroesSelectionPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 560);
        ((HeroesSelectionPageController)fxmlLoader.getController()).setPage();
        stage.setTitle("Loading Heroes...");
        stage.setScene(scene);
        stage.show();
    }
}
