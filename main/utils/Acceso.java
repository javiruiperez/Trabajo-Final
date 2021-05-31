package main.utils;

import main.DbConnections.DBConnection;

import java.sql.*;

/**
 * Esta clase da funcionalidad al acceso comparando el usuario y la contraseña que el usuario proporciona
 * con los usuarios y contraseñas de la base de datos. Si la comparacion resulta positiva, se da acceso
 * al usuario, si no se bloquea el acceso y tiene que volver a introducir los datos
 * */
public class Acceso {
   public static boolean acceso(String usuario, String contrasenya){
       Connection conn = null;
       Statement stmt = null;

       try {

           conn = DBConnection.getConnection();
           stmt = conn.createStatement();

           //generamos la consulta para trabajar con la base de datos

           String sql = "select * from creador where Nombre_Usuario=? AND Contrasenya=?;";
           PreparedStatement prpStatement = conn.prepareStatement(sql);
           //añadimos las varibles que queremos comparar con la base de datos
           prpStatement.setString(1, usuario);
           prpStatement.setString(2, Encriptacion.cifrar(contrasenya));
           ResultSet rs = prpStatement.executeQuery();

           //si el resultado de la comparacion es positivo se devuelve true, si no se devuelve false

           if (rs.next()) {
               return true;
           } else {
               return false;
           }

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       } finally {
       }
       return false;
   }
}
