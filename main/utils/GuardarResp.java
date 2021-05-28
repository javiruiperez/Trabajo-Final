package main.utils;

import main.DbConnections.DBConnection;
import main.models.Usuario;

import java.sql.*;

public class GuardarResp {
    /**
     * Esta clase tiene el objetivo de guardar las respuestas de las preguntas en una encuesta en la base de datos.
     * */
    public static boolean registro(int idpregunta, int respuestapreg) {
        Connection conn = null;
        Statement stmt = null;

        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            //aqui se llama a la instancia para obtener el usuario que está utilizando la aplicación en ese momento

            SesionUsuario sesion = SesionUsuario.getInstance();
            Usuario usr = sesion.getUsr();
            String nombre = usr.getNombre_usuario();

            //aqui se genera la consulta para trabajar con la base de datos

            String sql = "insert into respuesta_usuario values (?,?,?);";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            //aqui añadimos las variables que queremos guardar en la tabla de respuestas en la base de datos
            prpStatement.setInt(1, idpregunta);
            prpStatement.setString(2, nombre);
            prpStatement.setInt(3, respuestapreg);
            int row = prpStatement.executeUpdate();

            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
        return true;
    }
}
