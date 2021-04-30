package PFP;

import java.util.Scanner;

public class ResponderEncuestaDemo {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ahora eres respondedor, podrás responder encuestas y percibir ingresos por ello");
        System.out.println("A continuación vas a responder a tu primera encuesta, considérala una DEMO");
        System.out.println("Responde con el número de la opción que consideres correcta (ejemplo, si es la opción uno, introduce 1)");

        System.out.println("Primera Pregunta");
        System.out.println("¿Qué opinas de la superliga?");

        System.out.println("1) Me parece una gran idea, sin duda mejorará el fútbol");
        System.out.println("2) BASURA, definitivamente ha muerto el futbol");
        System.out.println("3) Mientras haya fútbol no me importa lo que pase");
        System.out.println("4) No me interesa el fútbol");
        int a1 = sc.nextInt();
        if (a1 < 5) {
            System.out.println("Segunda Pregunta");
            System.out.println("¿Cuál es tu color favorito?");

            System.out.println("1) Azul");
            System.out.println("2) Rojo");
            System.out.println("3) Verde");
            System.out.println("4) Morado");
            int a2 = sc.nextInt();

            System.out.println("Tercera Pregunta");
            System.out.println(" De las siguientes opciones ¿Qué tipo de películas te gustan más?");

            System.out.println("1) Románticas");
            System.out.println("2) de Terror");
            System.out.println("3) comedia");
            System.out.println("4) Acción");
            System.out.println("5) No me gusta el cine");
            int a3 = sc.nextInt();

            System.out.println("Cuarta Pregunta");
            System.out.println("¿A Cuál de estos partidos votarías?");

            System.out.println("1) PSOE");
            System.out.println("2) PP");
            System.out.println("3) VOX");
            System.out.println("4) PODEMOS");
            System.out.println("5) Los Vengadores");

            int a4 = sc.nextInt();

            System.out.println("Quinta pregunta");
            System.out.println("¿Esperas el futuro con optimismo?");


            System.out.println("1) Sí, la verdad es que tengo esperanzas");
            System.out.println("2) Definitivamente no, creo que es mejor refugiarse en el pasado");
            System.out.println("3) Creo que es Irrelevante, según el ETERNO RETORNO, de Nietszche, la historia está condenada a repetirse una y otra vez pero nosotros jamás lo veremos porque no vivimos tanto");
            System.out.println("4) XD");

            int a5 = sc.nextInt();

            System.out.println("Buen trabajo, acabas de completar tu primera encuesta");
        }else return;
    }
}
