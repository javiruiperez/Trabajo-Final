package PFP;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1- Acceder");
        System.out.println("2- Registrarse");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
            Acceder.main();
            CrearEncuestaDemo.main();
            ResponderEncuestaDemo.main();
            break;
            case 2:
            Registrarse.main();
            break;
        }
    }
}