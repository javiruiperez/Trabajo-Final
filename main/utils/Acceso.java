package main.utils;

import java.sql.*;

public class Acceso {
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/encuestas";
    static final String User = "root";
    static final String Pass = "Nicolevante21";

   public static boolean acceso(String correo, String contraseña){
       Connection conn = null;
       Statement stmt = null;

       try {

           conn = DriverManager.getConnection(DB_URL, User, Pass);
           stmt = conn.createStatement();

           String sql = "select * from creador where Correo=? AND Contrasenya=?;";
           PreparedStatement prpStatement = conn.prepareStatement(sql);
           prpStatement.setString(1, correo);
           prpStatement.setString(2, Encriptación.cifrar(contraseña, 3));
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
