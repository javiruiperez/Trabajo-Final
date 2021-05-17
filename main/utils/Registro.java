package main.utils;

import main.DbConnections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            String newcontrasenya = Encriptación.cifrar(contrasenya);

            String sql = "insert into creador values (?,?,?,?);";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, usuario);
            prpStatement.setString(2, correo);
            prpStatement.setString(3, newcontrasenya);
            prpStatement.setDouble(4, saldo);
            int row = prpStatement.executeUpdate();

            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
        return true;
    }
}
