package main.utils;

import main.DbConnections.DBConnection;

import java.sql.*;
//Esta es la interfaz de inicio de sesión
//El usuario mete su nombre y la contraseña
public class Acceso {


   public static boolean acceso(String usuario, String contrasenya){
       Connection conn = null;
       Statement stmt = null;

       try {

           conn = DBConnection.getConnection();
           stmt = conn.createStatement();

           String sql = "select * from creador where Nombre_Usuario=? AND Contrasenya=?;";
           PreparedStatement prpStatement = conn.prepareStatement(sql);
           prpStatement.setString(1, usuario);
           prpStatement.setString(2, encriptacion.cifrar(contrasenya));
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
