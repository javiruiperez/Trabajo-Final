package main.utils;

import main.DbConnections.DBConnection;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificar {
    /**
     * Esta clase tiene la funcion de verificar el usuario y el correo para ver si existe una cuenta con los mismos datos
     * en la base de datos y tambien para verificar que el correo es válido y contiene @ y un punto.
     * */
    public static boolean verificarUsuarioCorreo (String nombreUsuario, String correo){
        Connection conn = null;


        try {
            conn = DBConnection.getConnection();
            //aqui se genera la consulta en la que se comparan las variables con los datos de la base de datos
            String sql = "select * from creador where Nombre_Usuario=? or Correo=?;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            //aqui se introducen las variables
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
        //aquí se crea un metodo para verificar que el correo puede existir y obliga al usuario a utilizar punto y @
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
