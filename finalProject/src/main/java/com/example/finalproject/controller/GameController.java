package com.example.finalproject.controller;

import com.example.finalproject.models.Player;
import com.example.finalproject.mysql.MysqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameController {
    public static ArrayList<Player> players = new ArrayList<>();
    public static void readAllPlayersFromDatabase() throws SQLException, ClassNotFoundException {
        players.clear();
        players.add(new Player("Default" , "12345678" , 1 , 0,0,1));
        MysqlConnection mySQLConnection = new MysqlConnection();
        String query = String.format("SELECT * FROM `Players`");
        ResultSet rs =  mySQLConnection.executeQuery(query);
        while(rs.next()){
            players.add( new Player(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6))));
        }
    }
}
