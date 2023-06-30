package com.example.finalproject.GUI;

import com.example.finalproject.models.Map;
import com.example.finalproject.models.buildings.*;
import com.example.finalproject.models.heros.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class GameGroundController {
    Timeline timeline;
    public static int mapID;
    public static ArrayList<Hero> heroes = new ArrayList<>();
    private int numOfType = 0;
    private int numOfKnights = 0;
    private int numOfWonderfulWoman = 0;
    private int numOfCommander = 0;
    private int numOfArcherWoman = 0;
    private ArrayList<Hero> allHeroesInGround = new ArrayList<>();
    private ArrayList<Building> buildings = new ArrayList<>();
//    private ArrayList<Hero> heroType = new ArrayList<>();
    @FXML
    private Pane heroPane1;

    @FXML
    private Pane heroPane2;

    @FXML
    private Pane heroPane3;

    @FXML
    private Pane heroPane4;

    @FXML
    private ImageView mortar1;

    @FXML
    private ImageView mortar2;
    @FXML
    private ImageView archerTower1;

    @FXML
    private ImageView archerTower2;

    @FXML
    private ImageView clanCastle1;

    @FXML
    private ImageView clanCastle2;

    @FXML
    private ImageView goldStorage1;

    @FXML
    private ImageView goldStorage2;
    @FXML
    private ImageView townHall1;

    @FXML
    private ImageView townHall2;

    @FXML
    private ImageView map1;

    @FXML
    private ImageView map2;

    @FXML
    private ImageView map3;

    @FXML
    private ImageView map4;

    @FXML
    private ImageView map5;

    @FXML
    private AnchorPane pane;
    @FXML
    private Label num1;

    @FXML
    private Label num2;

    @FXML
    private Label num3;

    @FXML
    private Label num4;

    public void setMap(){
        clanCastle1.setVisible(false);
        clanCastle2.setVisible(false);
        goldStorage1.setVisible(false);
        goldStorage2.setVisible(false);
        archerTower1.setVisible(false);
        archerTower2.setVisible(false);
        townHall2.setVisible(false);
        townHall1.setVisible(false);
        mortar1.setVisible(false);
        mortar2.setVisible(false);
        this.setMapBackground();
        this.setBuilding();
        Map map = new Map(buildings , mapID);
        for(Building building : map.getBuildings()){
            building.getImg().setVisible(true);
        }
    }
    private void setMapBackground(){
        if(mapID == 1){
            map2.setVisible(false);
            map3.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(false);
            map1.setVisible(true);
        }
        else if(mapID == 2){
            map1.setVisible(false);
            map3.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(false);
            map2.setVisible(true);
        }
        else if(mapID == 3){
            map1.setVisible(false);
            map2.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(false);
            map3.setVisible(true);
        }
        else if(mapID == 4){
            map1.setVisible(false);
            map2.setVisible(false);
            map3.setVisible(false);
            map5.setVisible(false);
            map4.setVisible(true);
        }
        else if(mapID == 5){
            map1.setVisible(false);
            map2.setVisible(false);
            map3.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(true);
        }
    }
    private void setBuilding(){
        if(HomeController.player.getLevel() == 1){
            GoldStorage goldStorage11 = new GoldStorage(5 , goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(7,clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(7, 10, 1 , archerTower1);
            //------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
        }
        else if (HomeController.player.getLevel() == 2 ) {
            GoldStorage goldStorage11 = new GoldStorage(5 , goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(7,clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(7, 10, 1 , archerTower1);
            ArcherTower archerTower22 = new ArcherTower(7, 10, 1 , archerTower2);
            TownHall townHall11 = new TownHall(5 , townHall1);
            //-------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
            buildings.add(archerTower22);
            buildings.add(townHall11);
        }
        else if(HomeController.player.getLevel() == 3 ) {
            GoldStorage goldStorage11 = new GoldStorage(5 , goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(7,clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(7, 10, 1 , archerTower1);
            ArcherTower archerTower22 = new ArcherTower(7, 10, 1 , archerTower2);
            TownHall townHall11 = new TownHall(5 , townHall1);
            Mortar mortar11 = new Mortar(7, 5, 1 , mortar1);
            Mortar mortar22 = new Mortar(7, 5, 1 , mortar2);
            //-------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
            buildings.add(archerTower22);
            buildings.add(townHall11);
            buildings.add(mortar11);
            buildings.add(mortar22);
        }
        else if(HomeController.player.getLevel() >= 4) {
            GoldStorage goldStorage11 = new GoldStorage(5 , goldStorage2);
            GoldStorage goldStorage22 = new GoldStorage(5 , goldStorage1);
            ClanCastle clanCastle11 = new ClanCastle(7,clanCastle1);
            ClanCastle clanCastle22 = new ClanCastle(7,clanCastle2);
            ArcherTower archerTower11 = new ArcherTower(7, 10, 1 , archerTower1);
            ArcherTower archerTower22 = new ArcherTower(7, 10, 1 , archerTower2);
            TownHall townHall11 = new TownHall(5 , townHall1);
            TownHall townHall22 = new TownHall(5 , townHall2);
            Mortar mortar11 = new Mortar(7, 5, 1 , mortar1);
            Mortar mortar22 = new Mortar(7, 5, 1 , mortar2);
            //-------------------------
            buildings.add(goldStorage11);
            buildings.add(goldStorage22);
            buildings.add(clanCastle11);
            buildings.add(clanCastle22);
            buildings.add(archerTower11);
            buildings.add(archerTower22);
            buildings.add(townHall11);
            buildings.add(townHall22);
            buildings.add(mortar11);
            buildings.add(mortar22);
        }
    }
    @FXML
    ImageView image = new ImageView();
    @FXML
    void knight_btn(MouseEvent event) {
        if(numOfKnights > 0 ) {
            Knight knight = new Knight(0, 0);
            numOfKnights --;
            num1.setText(String.valueOf(Integer.parseInt(num1.getText()) - 1));

            image = knight;
            image.setLayoutX(160);
            image.setLayoutY(145);

            pane.getChildren().add(image);

            Timeline t = new Timeline();
            t.setCycleCount(Timeline.INDEFINITE);
            t.getKeyFrames().add(new KeyFrame(Duration.millis(100),
                    (ActionEvent e) ->{knight.walk();}
            ));
            DraggableMaker.makeDraggable(image , t);

            image = new ImageView();
        }

    }
    @FXML
    void archerWoman_btn(MouseEvent event) {
        if(numOfArcherWoman > 0 ) {
            ArcherWoman archerWoman = new ArcherWoman(0,0);
            numOfArcherWoman--;
            num4.setText(String.valueOf(Integer.parseInt(num4.getText()) - 1));

            image = archerWoman;
            image.setLayoutX(160);
            image.setLayoutY(310);

            pane.getChildren().add(image);
            Timeline t = new Timeline();
            t.setCycleCount(Timeline.INDEFINITE);
            t.getKeyFrames().add(new KeyFrame(Duration.millis(100),
                    (ActionEvent e) ->{archerWoman.walk();}
            ));
            DraggableMaker.makeDraggable(image , t);

            image = new ImageView();
        }
    }

    @FXML
    void commander_btn(MouseEvent event) {
        if(numOfCommander > 0 ) {
            Commander commander = new Commander(0,0);
            numOfCommander--;
            num2.setText(String.valueOf(Integer.parseInt(num2.getText()) - 1));

            image = commander;
            image.setLayoutX(100);
            image.setLayoutY(200);

            pane.getChildren().add(image);
            Timeline t = new Timeline();
            t.setCycleCount(Timeline.INDEFINITE);
            t.getKeyFrames().add(new KeyFrame(Duration.millis(100),
                    (ActionEvent e) ->{commander.walk();}
                    ));
            DraggableMaker.makeDraggable(image , t);

            image = new ImageView();
        }
    }
    @FXML
    void wonderfulWoman_btn(MouseEvent event) {
        if(numOfWonderfulWoman > 0 ) {
            WonderfulWoman wonderfulWoman = new WonderfulWoman(0,0);
            numOfWonderfulWoman--;
            num3.setText(String.valueOf(Integer.parseInt(num3.getText()) - 1));

            image = wonderfulWoman;
            image.setLayoutX(90);
            image.setLayoutY(250);

            pane.getChildren().add(image);
            Timeline t = new Timeline();
            t.setCycleCount(Timeline.INDEFINITE);
            t.getKeyFrames().add(new KeyFrame(Duration.millis(100),
                    (ActionEvent e) ->{wonderfulWoman.walk();}
            ));
            DraggableMaker.makeDraggable(image , t);

            image = new ImageView();
        }
    }

    ArrayList<Timeline> timelines = new ArrayList<>();
    ArrayList<ProgressIndicator> progressIndicators = new ArrayList<>();

    public void setHero(){
        for(Hero hero : this.heroes){
            if(hero instanceof Commander){
                numOfCommander++;
            }
            else if(hero instanceof WonderfulWoman){
                numOfWonderfulWoman++;
            }
            else if(hero instanceof Knight){
                numOfKnights++;
            }
            else if(hero instanceof ArcherWoman){
                numOfArcherWoman++;
            }
        }

        heroPane1.setVisible(false);
        heroPane2.setVisible(false);
        heroPane3.setVisible(false);
        heroPane4.setVisible(false);
        if(numOfKnights != 0 ){
            heroPane1.setVisible(true);
            num1.setText(String.valueOf(numOfKnights));
        }
        if(numOfCommander != 0 ){
            heroPane2.setVisible(true);
            num2.setText(String.valueOf(numOfCommander));
        }
        if(numOfWonderfulWoman != 0 ){
            heroPane3.setVisible(true);
            num3.setText(String.valueOf(numOfWonderfulWoman));
        }
        if(numOfArcherWoman != 0 ){
            heroPane4.setVisible(true);
            num4.setText(String.valueOf(numOfArcherWoman));
        }
    }
    public void startGame(){
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

            updateGame();

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public void updateGame(){
        for(Hero h : heroes) {
            // detect collision and attack
            if (!h.isAttacking) {
                for (Building b : this.buildings) {
                    if (h.detectCollision(b)) {
                        h.isAttacking = true;

                        new Thread(() -> {
                            while (h.isAlive() && b.isAlive()) {

                                //Platform.runLater(() -> heroHealth.setProgress(h1.getHealth() / totalHealth));
                                h.attack(b);
                                try {
                                    sleep(600);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }).start();
                    }
                }
                h.isAttacking = false;
            }
            // walk
            if (!h.isAttacking)
                h.walk();
        }
    }
}
