package main.controladores;

import main.DbConnections.DBConnection;

import java.sql.*;


public class ControladorCSV {
    public static int añadirEncuesta(String titulo, double remuneracion, String nombre_usuario, int numeroPreguntas){
        Connection conn = DBConnection.getConnection();
        String sql = "Insert Into encuestas(Titulo, Numero_Preguntas, Remuneracion, Nombre_Usuario) Values( ?, ?, ?, ?)";
        try {
            PreparedStatement prp = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prp.setString(1, titulo);
            prp.setInt(2, numeroPreguntas);
            prp.setDouble(3, remuneracion);
            prp.setString(4, nombre_usuario);
            prp.executeUpdate();
            ResultSet generatedKeys = prp.getGeneratedKeys();
            int ID_Encuesta = 0;
            if(generatedKeys.next()){
                ID_Encuesta = generatedKeys.getInt(1);
            }
            return ID_Encuesta;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
    public static int añadirPregunta(String titulo, int ID_Encuesta){
        Connection conn = DBConnection.getConnection();
        String sql = "Insert Into pregunta(Texto, ID_Encuesta) Values( ?, ?)";
        try {
            PreparedStatement prp = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prp.setString(1, titulo);
            prp.setInt(2, ID_Encuesta);
            prp.executeUpdate();
            ResultSet generatedKeys = prp.getGeneratedKeys();
            int ID_Pregunta = 0;
            if(generatedKeys.next()){
                ID_Pregunta = generatedKeys.getInt(1);
            }

            return ID_Pregunta;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
    public static void añadirRespuesta(String texto, int ID_Pregunta){
        Connection conn = DBConnection.getConnection();
        String sql = "Insert into respuesta(ID_Pregunta, Texto) Values( ?, ? )";
        try {
            PreparedStatement prp = conn.prepareStatement(sql);
            prp.setInt(1,ID_Pregunta);
            prp.setString(2, texto);
            prp.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
