package com.example.finalproject.GUI;

import com.example.finalproject.models.Map;
import com.example.finalproject.models.buildings.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class GameGroundController {
    public static int mapID;
    @FXML
    private ImageView airDefence1;

    @FXML
    private ImageView airDefence2;
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

    public void setMap(){
        clanCastle1.setVisible(false);
        clanCastle2.setVisible(false);
        goldStorage1.setVisible(false);
        goldStorage2.setVisible(false);
        archerTower1.setVisible(false);
        archerTower2.setVisible(false);
        townHall2.setVisible(false);
        townHall1.setVisible(false);
        airDefence1.setVisible(false);
        airDefence2.setVisible(false);
        setMapBackground();
        ArrayList<Building> buildings =this.setBuilding();
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
    private ArrayList<Building> setBuilding(){
        ArrayList<Building> buildings = new ArrayList<>();
        if(HomeController.player.getLevel() == 1){
            GoldStorage goldStorage11 = new GoldStorage(5 , goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(7,clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(7, 10, 1 , archerTower1);
            //------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
            return buildings;
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
            return buildings;
        }
        else if(HomeController.player.getLevel() == 3 ) {
            GoldStorage goldStorage11 = new GoldStorage(5 , goldStorage2);
            ClanCastle clanCastle11 = new ClanCastle(7,clanCastle1);
            ArcherTower archerTower11 = new ArcherTower(7, 10, 1 , archerTower1);
            ArcherTower archerTower22 = new ArcherTower(7, 10, 1 , archerTower2);
            TownHall townHall11 = new TownHall(5 , townHall1);
            AirDefence airDefence11 = new AirDefence(7, 5, 1 , airDefence1);
            AirDefence airDefence22 = new AirDefence(7, 5, 1 , airDefence2);
            //-------------------------
            buildings.add(goldStorage11);
            buildings.add(clanCastle11);
            buildings.add(archerTower11);
            buildings.add(archerTower22);
            buildings.add(townHall11);
            buildings.add(airDefence11);
            buildings.add(airDefence22);
            return buildings;
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
            AirDefence airDefence11 = new AirDefence(7, 5, 1 , airDefence1);
            AirDefence airDefence22 = new AirDefence(7, 5, 1 , airDefence2);
            //-------------------------
            buildings.add(goldStorage11);
            buildings.add(goldStorage22);
            buildings.add(clanCastle11);
            buildings.add(clanCastle22);
            buildings.add(archerTower11);
            buildings.add(archerTower22);
            buildings.add(townHall11);
            buildings.add(townHall22);
            buildings.add(airDefence11);
            buildings.add(airDefence22);
            return buildings;
        }
        else
            return null;
    }
}
