package PFP;

import java.sql.*;
import java.util.Scanner;

public class Acceder {
    static final String JDBC_Driver = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/prueba";
    static final String User = "root";
    static final String Pass = "Nicolevante21";
    public static void main() {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        String contraseña;
        String verificacion;
        String usuario;
        boolean bucle = true;

        while (bucle == true) {
            System.out.print("\nIntroduce tu nombre de usuario: ");
            usuario = sc.nextLine();

            System.out.print("Introduce una contraseña: ");
            contraseña = sc.nextLine();

            verificacion = Encriptación.cifrar(contraseña, 3);

            try {

                conn = DriverManager.getConnection(DB_URL, User, Pass);
                stmt = conn.createStatement();

                String sql = "select * from usuario where Contraseña=? AND NombreUsuario=?;";
                PreparedStatement prpStatement = conn.prepareStatement(sql);
                prpStatement.setString(1, verificacion);
                prpStatement.setString(2, usuario);
                ResultSet rs = prpStatement.executeQuery();
                if (rs.next()) {
                    System.out.println("Sesion iniciada\n");
                    System.out.println("Bienvenido de vuelta " + usuario+ "\n");
                    bucle = false;
                } else {
                    System.out.println("Datos incorrectos");

                }

            } catch (SQLException throwables) {
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

            if (verificacion.equals(contraseña)) {

            }
        }
    }
}
