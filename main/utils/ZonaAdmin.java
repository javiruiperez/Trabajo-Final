package main.utils;

import main.DbConnections.DBConnection;
import java.sql.*;
import java.util.Scanner;

/**
 * Esta clase tiene la función de administrar diferentes funciones de forma sencilla y accesible para el administrador.
 * Entre las funciones disponibles se encuentran ver las encuestas, cambiar el nombre de una encuesta, cambiar la remuneracion
 * de una encuesta y borrar una encuesta.
 */
public class ZonaAdmin {
    static Connection conn;
    public static void main(String[] args) {
        conn = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        boolean bucle = true;
        System.out.println("\n\t\t\t\tZona Admin");
        while(bucle) {
            int id;
            int opcion;
            String nombre;

            //aqui se crea el menu principal donde el admin puede elegir
            System.out.println("\n\t\t\t¿Que desea hacer?\n");
            System.out.println("1- Ver encuestas");
            System.out.println("2- Cambiar nombre de encuesta");
            System.out.println("3- Cambiar Remuneración");
            System.out.println("4- Borrar encuesta");
            System.out.println("5- Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    //se inicia el método que muestra las encuestas
                    mostrarEncuestas();
                    break;
                case 2:
                    //aqui se pide al admin que introduzca el id y el nuevo nombre de la encuesta a modificar
                    System.out.print("Introduzca el id de la encuesta que desees modificar: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduce el nuevo nombre de la encuesta seleccionada: ");
                    nombre = sc.nextLine();
                    cambiarNombre(id,nombre);
                    break;
                case 3:
                    //aqui se pide al admin que introduzca el id y la nueva remuneración de la encuesta a modificar
                    System.out.print("Introduzca el id de la encuesta que desees modificar: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduzca la nueva remuneracion: ");
                    String remuneracion = sc.nextLine();
                    cambiarRemuneracion(id, Double.valueOf(remuneracion));

                    break;
                case 4:
                    //aqui se pide al admin que introduzca el id de la encuesta a modificar
                    System.out.print("Introduzca el id de la encuesta que desees borrar: ");
                    id = sc.nextInt();
                    borrarEncuesta(id);
                    break;
                case 5:
                    //aqui se cierra el bucle y finaliza el programa
                    System.out.println("\nHasta otra");
                    bucle = false;
                    break;
                default:
                    System.out.println("Introduzca una opción válida");
            }
        }
    }
    public static void mostrarEncuestas(){
        Statement stmt = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            //aqui se genera la consulta
            String sql = "select * from encuestas";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            ResultSet rs = prpStatement.executeQuery();
            while(rs.next()){
                System.out.println("Id encuesta: "+rs.getInt("ID_Encuesta")+" Titulo: "+rs.getString("Titulo"));
            }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        } finally {
        }
    }
    public static void cambiarNombre(int ID_Encuesta, String Nombre){
        Statement stmt = null;

        try {

            stmt = conn.createStatement();
            //aqui se genera la consulta
            String sql = "UPDATE encuestas SET Titulo = ? WHERE ID_Encuesta = ?;";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, Nombre);
            prpStatement.setInt(2,ID_Encuesta);
            int row = prpStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }
    public static void cambiarRemuneracion(int ID_Encuesta, Double remuneracion){
        try {

            //aqui se genera la consulta
            String sql = "update encuestas set Remuneracion=? where ID_Encuesta = ?;";
            PreparedStatement prp = conn.prepareStatement(sql);

            prp.setDouble(1,remuneracion);
            prp.setInt(2,ID_Encuesta);
            prp.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }
    public static void borrarEncuesta(int ID_Encuesta) {
        try {

            //aqui se genera la consulta
            String sql = "DELETE FROM encuestas WHERE ID_Encuesta = ?;";
            PreparedStatement prp = conn.prepareStatement(sql);
            prp.setInt(1,ID_Encuesta);
            prp.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
        }
    }
}
