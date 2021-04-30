package PFP;

import java.util.*;

public class Saldo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Revisión de Saldo");
        System.out.println("2- Retirar saldo");
        int opcion = sc.nextInt();
        double saldo = 0.8;
        if (opcion == 1) {
            System.out.println("Tu saldo actual es de " + saldo + "€");
        }
        if (opcion == 2) {
            System.out.println("Su saldo ha sido retirado");
            saldo = 0;
        }
    }
}