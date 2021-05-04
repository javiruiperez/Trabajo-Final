package main.utils;

import java.sql.*;

public class Saldo {
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/encuestas";
    static final String User = "root";
    static final String Pass = "Nicolevante21";

    public void saldo(double saldo){
        Connection conn = null;
        Statement stmt = null;

        try {

            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();

            String sql = "select Saldo from creador";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, String.valueOf(saldo));
            ResultSet rs = prpStatement.executeQuery();

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
    }
}
