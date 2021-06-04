package main.utils;

import main.DbConnections.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class ZonaAdmin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bucle = true;
        System.out.println("\n\t\t\t\tZona Admin");
        while(bucle) {
            System.out.println("\n\t\t\t¿Que desea hacer?\n");
            System.out.println("1- Ver encuestas");
            System.out.println("2- Cambiar nombre de encuesta");
            System.out.println("3- Borrar encuestas");
            System.out.println("4- Borrar resultados");
            System.out.println("5- Salir");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    mostrarEncuestas();
                    break;
                case 2:
                    cambiarNombre();
                    break;
                case 3:
                    borrarEncuesta();
                    break;
                case 4:
                    borrarResultados();
                    break;
                case 5:
                    System.out.println("\nHasta otra");
                    bucle = false;
                    break;
            }
        }
    }
    public static void mostrarEncuestas(){
        Connection conn = null;
        Statement stmt = null;
        try {

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String sql = "select * from encuestas";
            PreparedStatement prpStatement = conn.prepareStatement(sql);
            ResultSet rs = prpStatement.executeQuery();
            while(rs.next()){
                System.out.println("\nId encuesta: "+rs.getInt("ID_Encuesta")+"\nTitulo: "+rs.getString("Titulo")+"\nNumero de preguntas: "+rs.getInt("Numero_Preguntas")+"\nRemuneracion: "+rs.getDouble("Remuneracion"));
            }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
        }
    }
    public static void cambiarNombre(){
        System.out.print("Introduzca el id de la encuesta que desees modificar: ");
    }
    public static void borrarEncuesta(){
        System.out.print("Introduzca el id de la encuesta que desees eliminar: ");
    }
    public static void borrarResultados(){
        System.out.print("Introduzca el id de la encuesta que desees modificar: ");
    }
}
