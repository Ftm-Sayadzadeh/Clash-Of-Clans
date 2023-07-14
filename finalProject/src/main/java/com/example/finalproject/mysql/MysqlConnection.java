package com.example.finalproject.mysql;

import java.sql.*;

public class MysqlConnection {
    String URL = "jdbc:mysql://localhost/game";
    String username = "root";
    String password = "evelix";
    public MysqlConnection(){
    }
    public Boolean executeSQL(String SQLCom) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL,username , password);
        Statement statement = connection.prepareStatement(SQLCom);
        statement.execute(SQLCom);
        return true;
    }
    public ResultSet executeQuery(String query) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL,username , password);
        Statement statement = connection.prepareStatement(query);
        return statement.executeQuery(query);
    }
}
