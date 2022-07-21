package com.guru.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(Config.DB_URL,Config.DB_USER,Config.DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
