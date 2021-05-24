package main.controladores;


import main.DbConnections.DBConnection;
import main.models.Encuesta;
import main.models.EntradaTablaEncuesta;
import main.models.Pregunta;
import main.models.Respuesta;

import java.sql.*;
import java.util.ArrayList;

public class ControladorEncuesta {
    public static ArrayList<EntradaTablaEncuesta> getEntradas(){
        ArrayList<EntradaTablaEncuesta> entradas = new ArrayList<EntradaTablaEncuesta>();
        Connection conn = DBConnection.getConnection();
        String sql = "Select ID_Encuesta, Numero_Preguntas, Remuneracion, Titulo FROM encuestas";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id_encuesta = rs.getInt("ID_Encuesta");
                int numpregs = rs.getInt("Numero_Preguntas");
                double remuneracion = rs.getDouble("Remuneracion");
                String titulo = rs.getString("Titulo");
                EntradaTablaEncuesta ent = new EntradaTablaEncuesta(id_encuesta, numpregs, remuneracion, titulo);
                entradas.add(ent);
            }
            return entradas;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static Encuesta getEncuesta(int ID_Encuesta) {
        Encuesta encuesta = null;
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT Titulo, Numero_Preguntas, Remuneracion, Nombre_Usuario FROM encuestas WHERE ID_Encuesta = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID_Encuesta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String titulo = rs.getString("Titulo");
                int numero_preguntas = rs.getInt("Numero_Preguntas");
                double remuneracion = rs.getDouble("Remuneracion");
                String nombre_usuario = rs.getString("Nombre_usuario");
                ArrayList<Pregunta> preguntas = getPreguntas(ID_Encuesta);
                Encuesta enc = new Encuesta(ID_Encuesta, titulo, numero_preguntas, remuneracion, nombre_usuario, preguntas);
                return enc;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Pregunta> getPreguntas(int ID_Encuesta) {
        ArrayList<Pregunta> resultado = new ArrayList<Pregunta>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT ID_Pregunta, Texto FROM pregunta WHERE ID_Encuesta = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID_Encuesta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int ID_Pregunta = rs.getInt("ID_Pregunta");
                String Texto = rs.getString("Texto");
                ArrayList<Respuesta> respuestas = getRespuestas(ID_Pregunta);
                Pregunta pre = new Pregunta(ID_Pregunta, Texto, respuestas);
                resultado.add(pre);
            }
            return resultado;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Respuesta> getRespuestas(int ID_Pregunta) {
        ArrayList<Respuesta> resultado = new ArrayList<Respuesta>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT ID_Respuesta, Texto FROM respuesta WHERE ID_Pregunta = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID_Pregunta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int ID_Respuesta = rs.getInt("ID_Respuesta");
                String Texto = rs.getString("Texto");
                Respuesta res = new Respuesta(ID_Respuesta, Texto);
                resultado.add(res);
            }
            return resultado;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    /*public static getSoloPreguntas(int ID_Encuesta, int ID_Pregunta){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT Texto FROM pregunta WHERE ID_Encuesta = ? AND ID_Pregunta = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID_Encuesta);
            stmt.setInt(2, ID_Pregunta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               String texto = rs.getString("Texto");
                Respuesta res = new Respuesta(texto);
                resultado.add(res);
            }
            return resultado;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }*/
}
