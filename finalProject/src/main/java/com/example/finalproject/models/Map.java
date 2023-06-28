package com.example.finalproject.models;
import com.example.finalproject.models.buildings.Building;

import java.util.ArrayList;

public class Map {
    private int mapID;
    private final ArrayList<Building> buildings;
    public Map(ArrayList<Building> buildings , int mapID){
        this.mapID = mapID;
        this.buildings = buildings;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
}
