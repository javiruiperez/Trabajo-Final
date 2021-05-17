package main.utils;

import main.DbConnections.DBConnection;
import main.controladores.ControladorEncuesta;
import main.models.Usuario;
import java.sql.*;

public class Saldo {
    public static void sacarSaldo() {
        Connection conn = null;
        Statement stmt = null;

        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            SesionUsuario sesion = SesionUsuario.getInstance();
            Usuario usr = sesion.getUsr();
            String nombre = usr.getNombre_usuario();


            String sql = "update creador set Saldo = 0 where Nombre_Usuario = ? ;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, nombre);
            int row = prpStatement.executeUpdate();


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }
    public static void actualizarSaldo(){
        Connection conn = null;
        Statement stmt = null;
        double newsaldo = 0;

        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            SesionUsuario sesion = SesionUsuario.getInstance();

            String nombre = sesion.getUsr().getNombre_usuario();;
            double remuneracion = ControladorEncuesta.getEncuesta(1).getRemuneracion();

            String sql = "select Saldo from creador where Nombre_Usuario = ?;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, nombre);
            ResultSet rs = prpStatement.executeQuery();
            while(rs.next()){

                double saldo = rs.getDouble("Saldo");
                newsaldo = saldo + remuneracion;
            }
            String sql2 = "UPDATE creador SET Saldo = ? where Nombre_Usuario = ?;";
            PreparedStatement prpStatement2 = conn.prepareStatement(sql2);
            prpStatement2.setString(2, nombre);
            prpStatement2.setDouble(1, newsaldo);
            int rows = prpStatement2.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }
}
