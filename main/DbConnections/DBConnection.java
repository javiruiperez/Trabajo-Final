package main.DbConnections;

import java.sql.*;

/**
 * Esta clase conecta la base de datos con el Intell IJ y a partir de esta clase se forman todas las consultas y sus respectivas
 * conexiones
 * */
public class DBConnection {
    String JDBC_Driver;
    String DB_URL;
    String User;
    String Pass;
    private static Connection conn = null;

    private DBConnection() {
        JDBC_Driver = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://127.0.0.1:3306/encuestas";
        User = "admin";
        Pass = "JaviNicoLucas1";

        try {
            Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            new DBConnection();
        }
        return conn;
    }
}
