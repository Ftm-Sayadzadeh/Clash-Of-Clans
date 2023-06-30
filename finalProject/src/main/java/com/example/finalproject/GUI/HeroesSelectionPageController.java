package com.example.finalproject.GUI;

import com.example.finalproject.models.heros.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HeroesSelectionPageController {
    public static ArrayList<Hero> heroes = new ArrayList<>();

    @FXML
    private Pane errorPane;

    @FXML
    private Label aWomanNum;

    @FXML
    private Pane archerWomanPane;

    @FXML
    private Label commanderNum;

    @FXML
    private Pane commanderPane;

    @FXML
    private Label knightNum;

    @FXML
    private Pane knightPane;

    @FXML
    private Label maxHeroes;

    @FXML
    private Label selectedHeroesCounter;

    @FXML
    private Label wWomanNum;

    @FXML
    private Pane wonderfulWomanPane;
    @FXML
    void closeErrorPane(MouseEvent event) {
        errorPane.setVisible(false);
    }

    @FXML
    void addAWoman(ActionEvent event) {
        if(Integer.parseInt(maxHeroes.getText())  > Integer.parseInt(selectedHeroesCounter.getText())){
            ArcherWoman newChar = new ArcherWoman(0,0);
            heroes.add(newChar);
            selectedHeroesCounter.setText(String.valueOf(Integer.parseInt(selectedHeroesCounter.getText()) + 1));
            aWomanNum.setText(String.valueOf(Integer.parseInt(aWomanNum.getText()) + 1));
        }
        else
            errorPane.setVisible(true);
    }

    @FXML
    void addCommander(ActionEvent event) {
        if(Integer.parseInt(maxHeroes.getText())  > Integer.parseInt(selectedHeroesCounter.getText())){
            Commander newChar = new Commander(0,0);
            heroes.add(newChar);
            selectedHeroesCounter.setText(String.valueOf(Integer.parseInt(selectedHeroesCounter.getText()) + 1));
            commanderNum.setText(String.valueOf(Integer.parseInt(commanderNum.getText()) + 1));
        }
        else
            errorPane.setVisible(true);
    }

    @FXML
    void addKnight(ActionEvent event) {
        if(Integer.parseInt(maxHeroes.getText())  > Integer.parseInt(selectedHeroesCounter.getText())){
            Knight newChar = new Knight(0,0);
            heroes.add(newChar);
            selectedHeroesCounter.setText(String.valueOf(Integer.parseInt(selectedHeroesCounter.getText()) + 1));
            knightNum.setText(String.valueOf(Integer.parseInt(knightNum.getText()) + 1));
        }
        else
            errorPane.setVisible(true);
    }

    @FXML
    void addWWoman(ActionEvent event) {
        if(Integer.parseInt(maxHeroes.getText())  > Integer.parseInt(selectedHeroesCounter.getText())){
            WonderfulWoman newChar = new WonderfulWoman(0,0);
            heroes.add(newChar);
            selectedHeroesCounter.setText(String.valueOf(Integer.parseInt(selectedHeroesCounter.getText()) + 1));
            wWomanNum.setText(String.valueOf(Integer.parseInt(wWomanNum.getText()) + 1));
        }
        else
            errorPane.setVisible(true);
    }

    @FXML
    void back(MouseEvent event) throws SQLException, IOException, ClassNotFoundException {
        new StartPage().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    @FXML
    void startGame(ActionEvent event) throws IOException {
        GameGroundController.heroes = heroes;
        new GameGround().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    public void setPage(){
        knightPane.setVisible(false);
        commanderPane.setVisible(false);
        wonderfulWomanPane.setVisible(false);
        archerWomanPane.setVisible(false);

        errorPane.setVisible(false);

        int playerLevel = HomeController.player.getLevel();
        if(playerLevel == 1){
            knightPane.setVisible(true);
            maxHeroes.setText("3");
        }
        else if(playerLevel == 2){
            knightPane.setVisible(true);
            commanderPane.setVisible(true);
            maxHeroes.setText("5");
        }
        else if(playerLevel == 3){
            knightPane.setVisible(true);
            commanderPane.setVisible(true);
            wonderfulWomanPane.setVisible(true);
            maxHeroes.setText("7");
        }
        else if(playerLevel >= 4){
            knightPane.setVisible(true);
            commanderPane.setVisible(true);
            wonderfulWomanPane.setVisible(true);
            archerWomanPane.setVisible(true);
            maxHeroes.setText("10");
        }
    }

}

