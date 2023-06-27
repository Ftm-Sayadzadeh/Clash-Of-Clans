package com.example.finalproject.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignIn extends Application {
    private boolean existedPlayer;

    public SignIn(boolean existedPlayer) {
        this.existedPlayer = existedPlayer;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/finalproject/signIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 560);
        ((SignInController)fxmlLoader.getController()).existedPlayer = existedPlayer;
        ((SignInController)fxmlLoader.getController()).setPane();
        if(existedPlayer) {
            stage.setTitle("LogIn");
        }
        else{
            stage.setTitle("SignUp");
        }
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
