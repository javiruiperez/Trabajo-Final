package main.utils;

import java.sql.*;

public class Acceso {
    static final String JDBC_Driver = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/prueba";
    static final String User = "root";
    static final String Pass = "Nicolevante21";

   public static boolean acceso(String usuario, String contraseña){
       Connection conn = null;
       Statement stmt = null;

       try {

           conn = DriverManager.getConnection(DB_URL, User, Pass);
           stmt = conn.createStatement();

           String sql = "select * from usuario where Contraseña=? AND NombreUsuario=?;";
           PreparedStatement prpStatement = conn.prepareStatement(sql);
           prpStatement.setString(1, contraseña);
           prpStatement.setString(2, usuario);
           ResultSet rs = prpStatement.executeQuery();
           if (rs.next()) {
               return true;
           } else {

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
