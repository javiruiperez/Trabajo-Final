package main.controladores;

import main.DbConnections.DBConnection;
import main.models.Encuesta;
import main.models.Pregunta;
import main.models.Respuesta;

import java.sql.*;
import java.util.ArrayList;

public class ControladorEncuesta {
    public static Encuesta getEncuesta(int ID_Encuesta){
        Connection conn = DBConnection.getConnection();

    }

    private static ArrayList<Pregunta> getPreguntas(int ID_Encuesta){
        Connection conn = DBConnection.getConnection();

    }

    private static ArrayList<Respuesta> getRespuestas(int ID_Pregunta){
        ArrayList<Respuesta> resultado = new ArrayList<Respuesta>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT ID_Respuesta, Texto FROM respuesta WHERE ID_Pregunta = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID_Pregunta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int ID_Respuesta = rs.getInt("ID_Respuesta");
                String Texto = rs.getString("Texto");
                Respuesta res = new Respuesta(ID_Respuesta, Texto);
                resultado.add(res);
            }
            return resultado;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
