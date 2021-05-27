package main.controladores;

import main.DbConnections.DBConnection;
import main.models.Encuesta;
import main.models.Pregunta;
import main.models.Respuesta;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.*;
import java.util.ArrayList;

public class ControladorGrafico {
    public static int getDatosRespuesta(int ID_Respuesta){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT Cantidad FROM vista_grafico WHERE ID_Respuesta = ?";
        try {
            PreparedStatement prp = conn.prepareStatement(sql);
            prp.setInt(1, ID_Respuesta);
            ResultSet rs = prp.executeQuery();
            while (rs.next()){
                int cantidad = rs.getInt("Cantidad");
                return cantidad;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static DefaultCategoryDataset getDataset(int ID_Encuesta){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Encuesta e = ControladorEncuesta.getEncuesta(ID_Encuesta);
        ArrayList<Pregunta> preguntas = e.getPreguntas();
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pre = preguntas.get(i);
            int ID_Pregunta = pre.getID_Pregunta();
            ArrayList<Respuesta> respuestas = pre.getRespuestas();
            for (int j = 0; j < respuestas.size(); j++) {
                Respuesta res = respuestas.get(j);
                int ID_Respuesta = res.getID_Respuesta();
                int cantidad = getDatosRespuesta(ID_Respuesta);
                //dataset.setValue(cantidad, Integer.toString(ID_Respuesta), Integer.toString(ID_Pregunta));
                dataset.setValue(cantidad, Integer.toString(j+1), Integer.toString(ID_Pregunta));
            }
        }
        return dataset;
    }


}
