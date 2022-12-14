package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Root@java";

    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() throws SQLException {

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection != null;
    }

    public void printConnectionStatus() {

        if (connection != null) {
            System.out.println("Database is connected");
        } else {
            System.err.println("Database is not connected");
        }

    }
}
