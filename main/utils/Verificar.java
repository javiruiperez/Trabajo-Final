package main.utils;

import main.DbConnections.DBConnection;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificar {
    public static boolean verificarUsuarioCorreo (String nombreUsuario, String correo){
        Connection conn = null;


        try {
            conn = DBConnection.getConnection();
            String sql = "select * from creador where Nombre_Usuario=? or Correo=?;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, nombreUsuario);
            prpStatement.setString(2, correo);
            ResultSet rs = prpStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {}
        return false;
    }
    public static boolean verificarCorreo(String correo){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        if (mather.find()) {
            return true;
        } else {
            return false;
        }
    }
}
