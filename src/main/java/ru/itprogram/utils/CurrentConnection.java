package ru.itprogram.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CurrentConnection {
    private final String DB_URL = "jdbc:postgresql://192.168.1.201:5432/onlineStore";
    private final String USER = "postgres";
    private final String PASSWORD = "999138663";
    private Connection connection;

    public CurrentConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
