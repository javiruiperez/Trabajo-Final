package main.controladores;

import main.DbConnections.DBConnection;
import main.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase contiene un metodo llamado getUsuario con el que se actualiza la instancia del usuario, es decir, obtenemos
 * todos los datos disponibles del usuario que está utilizando en ese momento la aplicacion, ya que cuando se cierra sesion
 * esta instancia se elimina y se vuelve a crear otra con el nuevo usuario en uso.
 * */
public class ControladorUsuario {
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
