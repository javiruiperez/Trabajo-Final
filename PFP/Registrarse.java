package PFP;

import main.utils.Encriptación;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Registrarse {
    static final String JDBC_Driver = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/prueba";
    static final String User = "root";
    static final String Pass = "Nicolevante21";
    public static void main(String[]args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        String contraseña;
        String verificar;
        String correo;
        String usuario;
        boolean bucle = true;

        System.out.print("\nIntroduce tu correo electrónico: ");
        correo = sc.nextLine();
        System.out.print("Introduce un nombre de usuario: ");
        usuario = sc.nextLine();

        while (bucle == true) {
            System.out.print("Introduce una contraseña: ");
            contraseña = sc.nextLine();
            System.out.print("Introduce de nuevo la contraseña: ");
            verificar = sc.nextLine();
            if (verificar.equals(contraseña)) {
                try {
                    Class.forName(JDBC_Driver);
                    conn = DriverManager.getConnection(DB_URL, User, Pass);
                    stmt = conn.createStatement();

                    String sql = "INSERT INTO usuario "
                            + "VALUES('" + usuario + "','" + correo + "','" + Encriptación.cifrar(contraseña, 3) + "')";
                    stmt.executeUpdate(sql);

                    System.out.println("\n¡Cuenta Creada con Éxito!");

                } catch (SQLException | ClassNotFoundException se) {
                    se.printStackTrace();
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
                bucle = false;
            }else{
                System.out.println("vuelve a introducir la contraseña");
            }
        }
    }
}
