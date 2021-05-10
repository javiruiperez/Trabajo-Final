package main.utils;

import java.sql.*;
//Esta es la interfaz de inicio de sesión
//El usuario mete su nombre y la contraseña
public class Acceso {
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/encuestas";
    static final String User = "root";
    static final String Pass = "Lgz-05112002";

   public static boolean acceso(String usuario, String contrasenya){
       Connection conn = null;
       Statement stmt = null;

       try {

           conn = DriverManager.getConnection(DB_URL, User, Pass);
           stmt = conn.createStatement();

           String sql = "select * from creador where Nombre_Usuario=? AND Contrasenya=?;";
           PreparedStatement prpStatement = conn.prepareStatement(sql);
           prpStatement.setString(1, usuario);
           prpStatement.setString(2, Encriptación.cifrar(contrasenya));
           ResultSet rs = prpStatement.executeQuery();
           if (rs.next()) {
               return true;
           } else {
               return false;
           }

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       } finally {
           try {
               if (stmt != null) {
                   conn.close();
               }
           } catch (SQLException se) {
           }
           try {
               if (conn != null) {
                   conn.close();
               }
           } catch (SQLException se) {
           }
       }
       return false;
   }
}
