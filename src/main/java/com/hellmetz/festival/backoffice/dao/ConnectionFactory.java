package com.hellmetz.festival.backoffice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // À adapter selon ton installation
    private static final String URL = "jdbc:postgresql://localhost:5432/hellmetz";
    private static final String USER = "hellmetz_user";
    private static final String PASSWORD = "Epi@88fcgn1";

    static {
        try {
            Class.forName("org.postgresql.Driver"); // charge le driver JDBC
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL introuvable", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
