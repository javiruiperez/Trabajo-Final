package main.utils;

import main.DbConnections.DBConnection;
import main.controladores.ControladorEncuesta;
import main.models.Usuario;
import java.sql.*;

/**
 * Esta clase tiene doble funcionalidad. La primera parte (sacarSaldo) tiene la funcion de retirar el saldo
 * del usuario cuando este decida mediante la interfaz. La otra parte (actualizarSaldo) recoge el saldo que
 * tenga el usuario en la base de datos y lo actualiza despues de haber respondido a una encuesta con su respectiva
 * remuneración.
 */
public class Saldo {
    public static void sacarSaldo() {
        Connection conn = null;
        Statement stmt = null;

        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            //aqui se llama a la instancia para obtener el usuario que está utilizando la aplicación en ese momento
            SesionUsuario sesion = SesionUsuario.getInstance();
            Usuario usr = sesion.getUsr();
            String nombre = usr.getNombre_usuario();

            //aqui se genera la consulta que transforma el saldo del usuario a 0
            String sql = "update creador set Saldo = 0 where Nombre_Usuario = ? ;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            //aquí se introduce el nombre del usuario que esté utilizando la aplicación en ese momento
            prpStatement.setString(1, nombre);
            int row = prpStatement.executeUpdate();


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }

    public static void actualizarSaldo(int ID_Encuesta){
        Connection conn = null;
        Statement stmt = null;
        double newsaldo = 0;

        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            //aqui se llama a la instancia para obtener el usuario que está utilizando la aplicación en ese momento
            SesionUsuario sesion = SesionUsuario.getInstance();
            String nombre = sesion.getUsr().getNombre_usuario();
            //aqui se obtiene la remuneracion de la encuesta mediante el metodo encuesta
            double remuneracion = ControladorEncuesta.getEncuesta(ID_Encuesta).getRemuneracion();

            //aqui se genera la consulta en la que se obtiene el saldo del usuario
            String sql = "select Saldo from creador where Nombre_Usuario = ?;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            //aquí se introduce el nombre del usuario que esté utilizando la aplicación en ese momento
            prpStatement.setString(1, nombre);
            ResultSet rs = prpStatement.executeQuery();
            while(rs.next()){
                //aqui se crea una variable para obtener la suma entre el saldo actual del usuario y la remuneracion de la respectiva encuesta
                double saldo = rs.getDouble("Saldo");
                newsaldo = saldo + remuneracion;
            }
            //aquí se genera la segunda consulta en la que se actualiza el saldo del usuario mediante la nueva variable que se creo anteriormente
            String sql2 = "UPDATE creador SET Saldo = ? where Nombre_Usuario = ?;";
            PreparedStatement prpStatement2 = conn.prepareStatement(sql2);
            //aquí se introduce el nombre del usuario que esté utilizando la aplicación en ese momento y la nueva variable
            prpStatement2.setString(2, nombre);
            prpStatement2.setDouble(1, newsaldo);
            int rows = prpStatement2.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }
}
