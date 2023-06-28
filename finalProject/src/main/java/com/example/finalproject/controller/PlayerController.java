package com.example.finalproject.controller;
import com.example.finalproject.exceptions.DuplicateUsername;
import com.example.finalproject.models.Player;
import com.example.finalproject.mysql.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerController {
    public Player login(String username , String password) throws SQLException, ClassNotFoundException {
        MysqlConnection mysqlConnection = new MysqlConnection();
        String query = String.format("SELECT * FROM `Players` WHERE `players`.`username`='%s'"+ "AND `players`.`password`='%s'",username , password);
        ResultSet rs = mysqlConnection.executeQuery(query);
        Player player = null;
        while (rs.next()) {
            player = new Player(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)));
        }
        return player ;
    }
    public void checkUsername(String username) throws SQLException, ClassNotFoundException, DuplicateUsername {
        MysqlConnection mysqlConnection = new MysqlConnection();
        String query = String.format("SELECT * FROM `Players` WHERE `players`.`username`='%s'",username);
        ResultSet rs = mysqlConnection.executeQuery(query);
        Player player = null;
        while (rs.next()) {
            player = new Player(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)));
        }
        if(player != null){
            throw new DuplicateUsername();
        }
    }
    public void insertPlayer(String username , String password , int mapID ) throws SQLException, ClassNotFoundException {
        MysqlConnection mySQLConnection = new MysqlConnection();
        String sql = String.format("INSERT INTO `Players` (`username`, `password`, `level`, `numOfWins`, `numOfLosses`, `mapID`) VALUES ('%s', '%s','%s', %s, %s, %s)" , username , password , 1 , 0 , 0 ,  mapID );
        mySQLConnection.executeSQL(sql);
    }
}
