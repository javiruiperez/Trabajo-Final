package main.utils;

import java.sql.*;

import main.DbConnections.DBConnection;
import main.GUI.Interfaz_logIn;

public class Saldo {


    public static double verSaldo(String usuario ){
        Connection conn = null;
        Statement stmt = null;


        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String sql = "select Saldo from creador where Nombre_Usuario =?";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, usuario);
            ResultSet rs = prpStatement.executeQuery();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            
        }
        return 0;
    }
}
