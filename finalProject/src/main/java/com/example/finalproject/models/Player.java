package com.example.finalproject.models;

public class Player implements Comparable < Player> {

    private String username;
    private String password;
    private int level;
    private int numOfWins;
    private int numOfLosses;
    private int mapID;

    public Player(String username , String password ,int level, int numOfWins, int numOfLosses , int mapID) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.numOfWins = numOfWins;
        this.numOfLosses = numOfLosses;
        this.mapID = mapID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
        if(numOfWins == 2){
            this.level = 2;
        }
        if(numOfWins == 4){
            this.level = 3;
        }
        if(numOfWins == 6){
            this.level = 4;
        }
    }

    public int getNumOfLosses() {
        return numOfLosses;
    }

    public void setNumOfLosses(int numOfLosses) {
        this.numOfLosses = numOfLosses;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    @Override
    public int compareTo(Player p) {
        if(this.level < p.level)
            return 1;
        else if(this.level > p.level )
            return -1;
        else
            return 0;
    }
}
