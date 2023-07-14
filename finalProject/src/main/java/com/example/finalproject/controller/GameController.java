package com.example.finalproject.controller;

import com.example.finalproject.GUI.HomeController;
import com.example.finalproject.models.Player;
import com.example.finalproject.models.buildingsAndWarEquipment.Building;
import com.example.finalproject.models.buildingsAndWarEquipment.DefenseBuilding;
import com.example.finalproject.models.heroesAndWarEquipment.Hero;
import com.example.finalproject.mysql.MysqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class GameController {
    public static ArrayList<Player> players = new ArrayList<>();
    public static void readAllPlayersFromDatabase() throws SQLException, ClassNotFoundException {
        players.clear();
        //players.add(new Player("Default" , "12345678" , 1 , 0,0,1));
        MysqlConnection mySQLConnection = new MysqlConnection();
        String query = String.format("SELECT * FROM `Players`");
        ResultSet rs =  mySQLConnection.executeQuery(query);
        while(rs.next()){
            players.add( new Player(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6))));
        }
    }
    public static void updatePlayersAfterGame(Player winner , Player loser) throws SQLException, ClassNotFoundException {
        readAllPlayersFromDatabase();
        int newNumOfWin = 0;
        int newNumOfLose = 0;
        for(Player p : players ) {
            if(Objects.equals(p.getUsername(), winner.getUsername()))
                newNumOfWin = p.getNumOfWins() + 1;
            if(Objects.equals(p.getUsername(), loser.getUsername()))
                newNumOfLose = p.getNumOfLosses() + 1;
        }

        MysqlConnection mySQLConnection = new MysqlConnection();
        String sql = String.format("UPDATE `Players` SET numOfWins =%s WHERE username='%s'", newNumOfWin,winner.getUsername());
        mySQLConnection.executeSQL(sql);
        sql = String.format("UPDATE `Players` SET numOfLosses =%s WHERE username='%s'", newNumOfLose,loser.getUsername());
        mySQLConnection.executeSQL(sql);
    }
    public static void updatePlayerLevel(Player player) throws SQLException, ClassNotFoundException {
        int level = 0;
        for(Player p : players ) {
            if (Objects.equals(p.getUsername(), player.getUsername()))
                level = p.getNumOfWins() + 1;
        }
        MysqlConnection mySQLConnection = new MysqlConnection();
        String sql = String.format("UPDATE `Players` SET level =%s WHERE username='%s'", level,player.getUsername());
        mySQLConnection.executeSQL(sql);
        //update player in program
        HomeController.player.setLevel(HomeController.player.getLevel() + 1 );
    }
    public static boolean detectCollision(Hero hero , Building building){
        double disCenterX = building.getBound().getCenterX() - hero.getBound().getCenterX();
        double disCenterY = building.getBound().getCenterY() - hero.getBound().getCenterY();
        double distance = Math.sqrt((disCenterX*disCenterX) + (disCenterY*disCenterY));
        return !(distance > (building.getDefenseRadiusCircle()+ hero.getAttackRadius()));
    }
    public static boolean detectAttackRadius(Hero hero , Building building){
        double disCenterX = building.getBound().getCenterX() - hero.getBound().getCenterX();
        double disCenterY = building.getBound().getCenterY() - hero.getBound().getCenterY();
        double distance = Math.sqrt((disCenterX*disCenterX) + (disCenterY*disCenterY));
        return !(distance > (((DefenseBuilding) building).getAttackRadiusCircle()));
    }
}
