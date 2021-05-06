package main.utils;

import java.sql.*;
public class encuestapred {
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/encuestas";
    static final String User = "root";
    static final String Pass = "Lgz-05112002";

    public void respuestas(double respuesta){
        Connection conn = null;
        Statement stmt = null;

       // try {
            //Class.forName(JDBC_Driver);
            //conn = DriverManager.getConnection(DB_URL, User, Pass);
            //stmt = conn.createStatement();

            //String sql = "INSERT INTO respuesta "
                    //+ "VALUES('" + usuario + "','" + correo + "','" + Encriptación.cifrar(contraseña, 3) + "')";
            //stmt.executeUpdate(sql);
        }
    }
//}
