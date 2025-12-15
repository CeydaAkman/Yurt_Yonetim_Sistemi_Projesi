package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:sqlserver://CYDKMN:14330;databaseName=YurtYonetimDB;encrypt=false;trustServerCertificate=true";

    private static final String USER = "yurtAdmin";
    private static final String PASSWORD = "Yurt1234";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("SQL Server bağlantısı başarılı!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Bağlantı hatası: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Bağlantı kapatıldı.");
            }
        } catch (SQLException e) {
            System.err.println("Kapatma hatası: " + e.getMessage());
        }
    }
}
