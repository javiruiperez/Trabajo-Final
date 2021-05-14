package main.utils;

import main.DbConnections.DBConnection;
import main.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RetirarSaldo {
    public static void outSaldo() {
        Connection conn = null;
        Statement stmt = null;

        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            SesionUsuario sesion = SesionUsuario.getInstance();
            Usuario usr = sesion.getUsr();
            String nombre = usr.getNombre_usuario();


            String sql = "update creador set Saldo = 0 where Nombre_Usuario = ? ;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, nombre);
            int row = prpStatement.executeUpdate();


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }
}
