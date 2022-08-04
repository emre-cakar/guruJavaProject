package com.guru.help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private Config config;

    public Connection getConnection(){
        config=new Config();
        try {
            connection= DriverManager.getConnection(config.DB_URL,config.DB_USER,config.DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
