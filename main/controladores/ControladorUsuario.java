package main.controladores;

import main.DbConnections.DBConnection;
import main.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorUsuario {

    /*
    * Este metodo siempre se ejecuta tras asegurarnos que el Nombre_Usuario esiste en la BD,
    * ya que este no lo comprueba
    * */

    public static Usuario getUsuario(String nombreUsuario){
        String correo = null;
        double saldo = 0.0;
        Connection conn = DBConnection.getConnection();
        String sql = "Select Nombre_Usuario, Correo, Saldo FROM creador WHERE Nombre_Usuario = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                correo = rs.getString("Correo");
                saldo = rs.getDouble("Saldo");
            }
            return new Usuario(nombreUsuario, correo, saldo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
