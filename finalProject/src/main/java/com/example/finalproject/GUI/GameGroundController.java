package com.example.finalproject.GUI;

import com.example.finalproject.controller.GameController;
import com.example.finalproject.models.Map;
import com.example.finalproject.models.Player;
import com.example.finalproject.models.buildingsAndWarEquipment.*;
import com.example.finalproject.models.heroesAndWarEquipment.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


public class GameGroundController {
    boolean end = false;
    public static Player competitorPlayer;
    public static int mapID;
    public static ArrayList<Hero> heroes = new ArrayList<>();
    private int numOfKnights = 0;
    private int numOfWonderfulWoman = 0;
    private int numOfCommander = 0;
    private int numOfArcherWoman = 0;
    private int deadHeroes = 0;
    public static ArrayList<Hero> allHeroesInGround = new ArrayList<>();
    private ArrayList<Building> buildings = new ArrayList<>();
    private ArrayList<Building> defenceBuildings = new ArrayList<>();
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

    public void setMap() {
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
        Map map = new Map(buildings, mapID);
        for (Building building : map.getBuildings()) {
            building.getImg().setVisible(true);
        }
        for (Building b : buildings) {
            if (Objects.equals(b.getType(), "defense"))
                defenceBuildings.add(b);
        }
        for (Building b : defenceBuildings) {
            System.out.println(b.getClass());
        }
    }

    private void setMapBackground() {
        if (mapID == 1) {
            map2.setVisible(false);
            map3.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(false);
            map1.setVisible(true);
        } else if (mapID == 2) {
            map1.setVisible(false);
            map3.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(false);
            map2.setVisible(true);
        } else if (mapID == 3) {
            map1.setVisible(false);
            map2.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(false);
            map3.setVisible(true);
        } else if (mapID == 4) {
            map1.setVisible(false);
            map2.setVisible(false);
            map3.setVisible(false);
            map5.setVisible(false);
            map4.setVisible(true);
        } else if (mapID == 5) {
            map1.setVisible(false);
            map2.setVisible(false);
            map3.setVisible(false);
            map4.setVisible(false);
            map5.setVisible(true);
        }
    }

    private void setBuilding() {
        if (HomeController.player.getLevel() == 1) {
            GoldStorage goldStorage11 = new GoldStorage(10, goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(12, clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(20, 4, 1, archerTower1);
            //------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
        } else if (HomeController.player.getLevel() == 2) {
            GoldStorage goldStorage11 = new GoldStorage(28, goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(24, clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(50, 5, 1, archerTower1);
            ArcherTower archerTower22 = new ArcherTower(50, 5, 1, archerTower2);
            TownHall townHall11 = new TownHall(24, townHall1);
            //-------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
            buildings.add(archerTower22);
            buildings.add(townHall11);
        } else if (HomeController.player.getLevel() == 3) {
            GoldStorage goldStorage11 = new GoldStorage(24, goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(20, clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(50, 5, 1, archerTower1);
            ArcherTower archerTower22 = new ArcherTower(50, 5, 1, archerTower2);
            TownHall townHall11 = new TownHall(28, townHall1);
            Mortar mortar11 = new Mortar(40, 5, 1, mortar1);
            Mortar mortar22 = new Mortar(40, 5, 1, mortar2);
            //-------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
            buildings.add(archerTower22);
            buildings.add(townHall11);
            buildings.add(mortar11);
            buildings.add(mortar22);
        } else if (HomeController.player.getLevel() >= 4) {
            GoldStorage goldStorage11 = new GoldStorage(24, goldStorage2);
            GoldStorage goldStorage22 = new GoldStorage(24, goldStorage1);
            ClanCastle clanCastle11 = new ClanCastle(20, clanCastle1);
            ClanCastle clanCastle22 = new ClanCastle(20, clanCastle2);
            ArcherTower archerTower11 = new ArcherTower(50, 10, 1, archerTower1);
            ArcherTower archerTower22 = new ArcherTower(50, 10, 1, archerTower2);
            TownHall townHall11 = new TownHall(24, townHall1);
            TownHall townHall22 = new TownHall(24, townHall2);
            Mortar mortar11 = new Mortar(40, 5, 1, mortar1);
            Mortar mortar22 = new Mortar(40, 5, 1, mortar2);
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
    private Pane draggableAWoman;

    @FXML
    private Pane draggableCommander;

    @FXML
    private Pane draggableKnight;

    @FXML
    private Pane draggableWWoman;
    @FXML
    ImageView image = new ImageView();


    @FXML
    void knight_btn(MouseEvent event) {

        if (numOfKnights > 0) {
            draggableKnight.setVisible(true);
            Knight knight = new Knight(0, 0);
            numOfKnights--;
            num1.setText(String.valueOf(Integer.parseInt(num1.getText()) - 1));

            image = knight;
            image.setLayoutX(-35);
            image.setLayoutY(470);


            pane.getChildren().add(image);

            DraggableMaker.makeDraggable(image, knight);
            image = new ImageView();
        }

    }

    @FXML
    void archerWoman_btn(MouseEvent event) {

        if (numOfArcherWoman > 0) {
            draggableAWoman.setVisible(true);
            ArcherWoman archerWoman = new ArcherWoman(0, 0);
            numOfArcherWoman--;
            num4.setText(String.valueOf(Integer.parseInt(num4.getText()) - 1));

            image = archerWoman;
            image.setLayoutX(710);
            image.setLayoutY(475);

            pane.getChildren().add(image);

            DraggableMaker.makeDraggable(image, archerWoman);

            image = new ImageView();
        }

    }

    @FXML
    void commander_btn(MouseEvent event) {

        if (numOfCommander > 0) {
            draggableCommander.setVisible(true);
            Commander commander = new Commander(0, 0);
            numOfCommander--;
            num2.setText(String.valueOf(Integer.parseInt(num2.getText()) - 1));

            image = commander;
            image.setLayoutX(45);
            image.setLayoutY(470);

            pane.getChildren().add(image);
            DraggableMaker.makeDraggable(image, commander);

            image = new ImageView();
        }

    }

    @FXML
    void wonderfulWoman_btn(MouseEvent event) {
        if (numOfWonderfulWoman > 0) {
            draggableWWoman.setVisible(true);
            WonderfulWoman wonderfulWoman = new WonderfulWoman(0, 0);
            numOfWonderfulWoman--;
            num3.setText(String.valueOf(Integer.parseInt(num3.getText()) - 1));

            image = wonderfulWoman;
            image.setLayoutX(790);
            image.setLayoutY(475);

            pane.getChildren().add(image);
            DraggableMaker.makeDraggable(image, wonderfulWoman);

            image = new ImageView();
        }
    }

    public void setHero() {
        for (Hero hero : heroes) {
            if (hero instanceof Commander) {
                numOfCommander++;
            } else if (hero instanceof WonderfulWoman) {
                numOfWonderfulWoman++;
            } else if (hero instanceof Knight) {
                numOfKnights++;
            } else if (hero instanceof ArcherWoman) {
                numOfArcherWoman++;
            }
        }

        heroPane1.setVisible(false);
        heroPane2.setVisible(false);
        heroPane3.setVisible(false);
        heroPane4.setVisible(false);
        if (numOfKnights != 0) {
            heroPane1.setVisible(true);
            num1.setText(String.valueOf(numOfKnights));
        }
        if (numOfCommander != 0) {
            heroPane2.setVisible(true);
            num2.setText(String.valueOf(numOfCommander));
        }
        if (numOfWonderfulWoman != 0) {
            heroPane3.setVisible(true);
            num3.setText(String.valueOf(numOfWonderfulWoman));
        }
        if (numOfArcherWoman != 0) {
            heroPane4.setVisible(true);
            num4.setText(String.valueOf(numOfArcherWoman));
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateGame() {
        if (!end) {
            for (Hero h : allHeroesInGround) {
                // detect collision and attack
                if (!h.isAttacking) {
                    Building b = chooseTheClosestBuilding(h);
                    if (GameController.detectCollision(h, b)) {
                        h.isAttacking = true;
                        // normal hero
                        if (h instanceof Knight || h instanceof Commander || h instanceof WonderfulWoman) {
                            new Thread(() -> {
                                while (h.isAlive() && b.isAlive()) {
                                    h.attack(b);
                                    System.out.println("Hero is Alive!");
                                    sleep(200);
                                }
                                if (!b.isAlive()) {
                                    buildings.remove(b);
                                    if (defenceBuildings.contains(b)) {
                                        defenceBuildings.remove(b);
                                    }
                                }

                                h.isAttacking = false;
                            }).start();

                        } else if (h instanceof ArcherWoman) {

                            Arrow arrow = new Arrow();
                            pane.getChildren().add(arrow);
                            arrow.setLayoutX(h.getBound().getCenterX());
                            arrow.setLayoutY(h.getBound().getCenterY());
                            arrow.setVisible(true);

                            new Thread(() -> {
                                while (h.isAlive() && b.isAlive()) {
                                    //hero attack
                                    h.attack(b);
                                    //arrow translate
                                    arrow.attack(h, b);

                                    sleep(200);
                                }
                                if (!b.isAlive()) {
                                    buildings.remove(b);
                                    if (defenceBuildings.contains(b)) {
                                        defenceBuildings.remove(b);
                                    }
                                }

                                h.isAttacking = false;
                                arrow.setVisible(false);

                            }).start();
                        }
                    }
                    // walk
                    if (!h.isAttacking) {
                        h.walk(b);
                    }
                }
            }
        }
    }

    public Building chooseTheClosestBuilding(Hero hero) {
        Building bestChoice = null;
        double min = 100000000;
        if (hero instanceof ArcherWoman) {
            if (defenceBuildings.size() > 0)
                return this.bestChoiceForArcher(hero);
        }

        for (Building building : buildings) {
            double disCenterX = building.getBound().getCenterX() - hero.getBound().getCenterX();
            double disCenterY = building.getBound().getCenterY() - hero.getBound().getCenterY();
            double distance = Math.sqrt((disCenterX * disCenterX) + (disCenterY * disCenterY));
            if (distance < min) {
                bestChoice = building;
                min = distance;
            }
        }
        return bestChoice;
    }

    public Building bestChoiceForArcher(Hero hero) {
        Building bestChoice = null;
        double min = 100000000;
        for (Building building : defenceBuildings) {
            double disCenterX = building.getBound().getCenterX() - hero.getBound().getCenterX();
            double disCenterY = building.getBound().getCenterY() - hero.getBound().getCenterY();
            double distance = Math.sqrt((disCenterX * disCenterX) + (disCenterY * disCenterY));
            if (distance < min) {
                bestChoice = building;
                min = distance;
            }
        }
        return bestChoice;
    }

    public Hero chooseTheClosestHero(Building b) {
        Hero bestChoice = null;
        double min = 100000000;
        for (Hero hero : allHeroesInGround) {
            double disCenterX = hero.getBound().getCenterX() - b.getBound().getCenterX();
            double disCenterY = hero.getBound().getCenterY() - b.getBound().getCenterY();
            double distance = Math.sqrt((disCenterX * disCenterX) + (disCenterY * disCenterY));
            if (distance < min) {
                bestChoice = hero;
                min = distance;
            }
        }
        return bestChoice;
    }

    public void manageBuildingAttack() {
        if (!end) {
            //do it when at least one hero in the ground
            if (allHeroesInGround.size() != 0) {
                for (Building building : defenceBuildings) {
                    // detect collision and attack
                    if (!((DefenseBuilding) building).isAttacking) {
                        Hero hero = this.chooseTheClosestHero(building);
                        if (GameController.detectAttackRadius(hero, building)) {

                            ((DefenseBuilding) building).isAttacking = true;

                            if (building instanceof ArcherTower) {
                                ArrowOfArcherTower arrow = new ArrowOfArcherTower();
                                pane.getChildren().add(arrow);
                                arrow.setLayoutX(building.getBound().getCenterX());
                                arrow.setLayoutY(building.getBound().getCenterY());
                                arrow.setVisible(true);
                                new Thread(() -> {
                                    while (hero.isAlive()) {
                                        arrow.throwArrows(hero, building);
                                        sleep(300);
                                    }
                                    System.out.println("HEro Health " + hero.getHealth());
                                    System.out.println("HEro is alive " + hero.isAlive());
                                    if (!hero.isAlive()) {
                                        deadHeroes ++;
                                        allHeroesInGround.remove(hero);
                                        arrow.setVisible(false);
                                    }
                                    ((DefenseBuilding) building).isAttacking = false;

                                }).start();

                            }else if (building instanceof Mortar) {
                                Bomb bomb = new Bomb();
                                pane.getChildren().add(bomb);
                                bomb.setLayoutX(building.getBound().getCenterX());
                                bomb.setLayoutY(building.getBound().getCenterY());
                                bomb.setVisible(true);
                                new Thread(() -> {
                                    while (hero.isAlive() && building.isAlive()) {
                                        bomb.attack(hero, building);
                                        sleep(200);
                                    }
                                    if (!hero.isAlive()) {
                                        deadHeroes ++;
                                        allHeroesInGround.remove(hero);
                                        bomb.setVisible(false);
                                    }
                                    ((DefenseBuilding) building).isAttacking = false;
                                }).start();
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean haveALivingHero(){
        return deadHeroes >= heroes.size();
    }


    public void playTimeline() {
        //manage hero--------------------------------
        Timeline heroesTimer = new Timeline();
        heroesTimer.setCycleCount(Timeline.INDEFINITE);
        heroesTimer.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
                (ActionEvent e) -> {
                    if (this.buildings.size() == 0)
                        end = true;
                    updateGame();
                }
        ));
        heroesTimer.play();
        //mange defence buildings--------------------------------
        Timeline defenceBuildingsTimer = new Timeline();
        defenceBuildingsTimer.setCycleCount(Timeline.INDEFINITE);
        defenceBuildingsTimer.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
                (ActionEvent e) -> {
                    if (haveALivingHero())
                        end = true;
                    manageBuildingAttack();
                }
        ));
        defenceBuildingsTimer.play();
        //manage stop game--------------------------------
        Timeline stop = new Timeline();
        stop.setCycleCount(Timeline.INDEFINITE);
        stop.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1),
                (ActionEvent e) -> {
                    if (end && this.buildings.size() == 0) {
                        heroesTimer.stop();
                        defenceBuildingsTimer.stop();
                        GameResultController.win = true;
                        try {
                            GameController.updatePlayersAfterGame(HomeController.player, competitorPlayer);
                            GameController.updatePlayerLevel(HomeController.player);
                        } catch (SQLException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        GameResult gameResult = new GameResult();
                        try {
                            sleep(3000);
                            pane.getScene().getWindow().hide();
                            gameResult.start(new Stage());
                            stop.stop();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else if (end && this.haveALivingHero()) {
                        heroesTimer.stop();
                        defenceBuildingsTimer.stop();
                        GameResultController.win = false;
                        try {
                            GameController.updatePlayersAfterGame(competitorPlayer, HomeController.player);
                        } catch (SQLException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        GameResult gameResult = new GameResult();
                        try {
                            sleep(3000);
                            pane.getScene().getWindow().hide();
                            gameResult.start(new Stage());
                            stop.stop();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        ));
        stop.play();
    }
}
