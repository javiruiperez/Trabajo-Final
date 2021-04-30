package main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Registro {
    static final String JDBC_Driver = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/prueba";
    static final String User = "root";
    static final String Pass = "Nicolevante21";

    public static String registro(String usuario, String correo, String contraseña) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();

            String sql = "INSERT INTO usuario "
                    + "VALUES('" + usuario + "','" + correo + "','" + Encriptación.cifrar(contraseña, 3) + "')";
            stmt.executeUpdate(sql);

            System.out.println("\n¡Cuenta Creada con Éxito!");

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
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
        return registro(usuario, correo, contraseña);
    }
}
