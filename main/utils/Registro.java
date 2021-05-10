package main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Registro {
    static final String JDBC_Driver = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/encuestas";
    static final String User = "root";
    static final String Pass = "Nicolevante21";

    public static boolean registro(String usuario, String correo, String contrasenya) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();

            String sql = "INSERT INTO creador "
                    + "VALUES('" + usuario + "','" + correo + "','" + Encriptación.cifrar(contrasenya) + "')";
            stmt.executeUpdate(sql);

            return true;

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
        return true;
    }
}
