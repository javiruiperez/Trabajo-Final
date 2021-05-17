package main.utils;

import main.DbConnections.DBConnection;
import main.models.Usuario;

import java.sql.*;

public class GuardarResp {
    public static boolean registro(int idpregunta, int respuestapreg) {
        Connection conn = null;
        Statement stmt = null;


        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            SesionUsuario sesion = SesionUsuario.getInstance();
            Usuario usr = sesion.getUsr();
            String nombre = usr.getNombre_usuario();


            String sql = "insert into respuesta_usuario values (?,?,?);";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setInt(1, idpregunta);
            prpStatement.setString(2, nombre);
            prpStatement.setInt(3, respuestapreg);
            int row = prpStatement.executeUpdate();

            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
        return true;
    }
}
