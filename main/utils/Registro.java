package main.utils;

import main.DbConnections.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Registro {


    public static boolean registro(String usuario, String correo, String contrasenya) {
        Connection conn = null;
        Statement stmt = null;
        double saldo = 0;

        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String sql = "INSERT INTO creador "
                    + "VALUES('" + usuario + "','" + correo + "','" + Encriptación.cifrar(contrasenya) + "','" + saldo + "')";
            stmt.executeUpdate(sql);

            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
        return true;
    }
}
