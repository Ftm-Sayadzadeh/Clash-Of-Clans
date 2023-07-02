package com.example.finalproject.GUI;

import com.example.finalproject.models.heroesAndWarEquipment.ArcherWoman;
import com.example.finalproject.models.heroesAndWarEquipment.Commander;
import com.example.finalproject.models.heroesAndWarEquipment.Knight;
import com.example.finalproject.models.heroesAndWarEquipment.WonderfulWoman;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HeroesInfoPageController {

    @FXML
    private Label archerWomanAttackRadius;

    @FXML
    private Label archerWomanAttackSpeed;

    @FXML
    private Label archerWomanHealth;

    @FXML
    private Label archerWomanPower;

    @FXML
    private Label archerWomanSpeed;

    @FXML
    private Label commanderAttackSpeed;

    @FXML
    private Label commanderHealth;

    @FXML
    private Label commanderPower;

    @FXML
    private Label commanderSpeed;

    @FXML
    private Label knightAttackSpeed;

    @FXML
    private Label knightHealth;

    @FXML
    private Label knightPower;

    @FXML
    private Label knightSpeed;

    @FXML
    private Label wonderfulWomanAttackSpeed;

    @FXML
    private Label wonderfulWomanHealth;

    @FXML
    private Label wonderfulWomanPower;

    @FXML
    private Label wonderfulWomanSpeed;

    @FXML
    void backHome(MouseEvent event) throws IOException {
        new Home().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    public void setInfos(){
        Knight knight = new Knight(0,0);
        knightHealth.setText(String.valueOf(knight.getHealth()));
        knightPower.setText(String.valueOf(knight.getPower()));
        knightSpeed.setText(String.valueOf(knight.getSpeed()));
        knightAttackSpeed.setText(String.valueOf(knight.getAttackSpeed()));
        //-------
        Commander commander = new Commander(0,0);
        commanderHealth.setText(String.valueOf(commander.getHealth()));
        commanderPower .setText(String.valueOf(commander.getPower()));
        commanderSpeed .setText(String.valueOf(commander.getSpeed()));
        commanderAttackSpeed .setText(String.valueOf(commander.getAttackSpeed()));
        //-------
        WonderfulWoman wonderfulWoman = new WonderfulWoman(0,0);
        wonderfulWomanHealth.setText(String.valueOf(wonderfulWoman.getHealth()));
        wonderfulWomanPower .setText(String.valueOf(wonderfulWoman.getPower()));
        wonderfulWomanSpeed .setText(String.valueOf(wonderfulWoman.getSpeed()));
        wonderfulWomanAttackSpeed .setText(String.valueOf(wonderfulWoman.getAttackSpeed()));
        //-------
        ArcherWoman archerWoman = new ArcherWoman(0,0);
        archerWomanHealth.setText(String.valueOf(archerWoman.getHealth()));
        archerWomanPower .setText(String.valueOf(archerWoman.getPower()));
        archerWomanSpeed .setText(String.valueOf(archerWoman.getSpeed()));
        archerWomanAttackSpeed .setText(String.valueOf(archerWoman.getAttackSpeed()));
        archerWomanAttackRadius .setText(String.valueOf(archerWoman.getAttackRadius()));
    }

}

