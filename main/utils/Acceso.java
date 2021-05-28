package main.utils;

import main.DbConnections.DBConnection;

import java.sql.*;
//Esta es la interfaz de inicio de sesión
//El usuario mete su nombre y la contraseña
public class Acceso {

     /**
     * Esta clase da funcionalidad al acceso comparando el usuario y la contraseña que el usuario proporciona
      * con los usuarios y contraseñas de la base de datos. Si la comparacion resulta positiva, se da acceso
      * al usuario, si no se bloquea el acceso y tiene que volver a introducir los datos
     * */

   public static boolean acceso(String usuario, String contrasenya){
       Connection conn = null;
       Statement stmt = null;

       try {

           conn = DBConnection.getConnection();
           stmt = conn.createStatement();

           String sql = "select * from creador where Nombre_Usuario=? AND Contrasenya=?;";
           PreparedStatement prpStatement = conn.prepareStatement(sql);
           prpStatement.setString(1, usuario);
           prpStatement.setString(2, Encriptacion.cifrar(contrasenya));
           ResultSet rs = prpStatement.executeQuery();
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
