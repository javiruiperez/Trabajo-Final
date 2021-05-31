package old;

import java.util.Scanner;
public class respondedor {
    static Scanner sc = new Scanner(System.in);



        public static void main (String[]args){


            System.out.println("Ahora eres old.respondedor, podrás responder encuestas y percibir ingresos por ello");
            System.out.println("A continuación vas a responder a tu primera encuesta, considérala una DEMO");
            System.out.println("Responde con el número de la opción que consideres correcta (ejemplo, si es la opción uno, introduce 1)");
            pregunta1();
            pregunta2();
            pregunta3();
            pregunta4();
            pregunta5();
        }
        public static void pregunta1 () {
            boolean buclep1 = true;
            boolean entradaNumerica = true;
            System.out.println("Primera Pregunta");
            while (buclep1 == true) {
                System.out.println("¿Qué opinas de la superliga?");
                System.out.println("1) Me parece una gran idea, sin duda mejorará el fútbol");
                System.out.println("2) BASURA, definitivamente ha muerto el futbol");
                System.out.println("3) No me interesa el fútbol");
                System.out.println("4) La verdad es que ambas opciones me parecen bien");
                int a1 = sc.nextInt();
                for (int i = 0; i < a1; i++) {

                }
                if (a1 >= 5 || a1 <= 0 || Character.isDigit(a1) == false) {

                    System.out.println("Introduce una respuesta válida");
                    entradaNumerica = false;
                    break;
                } else {
                    buclep1 = false;

                }
            }
        }
        public static void pregunta2 () {
            boolean buclep2 = true;
            System.out.println("Segunda Pregunta");
            while (buclep2 == true) {
                System.out.println("¿Crees que Pedro Sánchez es un buen presidente?");
                System.out.println("1) Sin duda, es el mejor presidente de la democracia española");
                System.out.println("2) No, lo odio");
                System.out.println("3) Me parece un presidente aceptable, aunque no sea perfecto");
                System.out.println("4) No tengo una opinión realmente formada al respecto");

                int a2 = sc.nextInt();
                if (a2 >= 5 || a2 <= 0) {


                    System.out.println("Introduce una respuesta válida");
                } else {
                    buclep2 = false;
                }
            }
        }
        public static void pregunta3 () {
            boolean buclep3 = true;
            System.out.println("Tercera Pregunta");
            while (buclep3 == true) {
                System.out.println("Tercera Pregunta");
                System.out.println(" De las siguientes opciones ¿Qué tipo de películas te gustan más?");
                System.out.println("1) Románticas");
                System.out.println("2) de Terror");
                System.out.println("3) comedia");
                System.out.println("4) Acción");
                System.out.println("5) no me gusta el cine");
                int a3 = sc.nextInt();
                if (a3 >= 6 || a3 <= 0) {
                    System.out.println("Introduce una respuesta válida");
                } else {
                    buclep3 = false;
                }
            }
        }

        public static void pregunta4 () {
            boolean buclep4 = true;
            System.out.println("Cuarta Pregunta");
            while (buclep4 == true) {
                System.out.println("¿A Cuál de estos partidos votarías?");

                System.out.println("1) PSOE");
                System.out.println("2) PP");
                System.out.println("3) VOX");
                System.out.println("4) PODEMOS");
                System.out.println("5) Los Vengadores");
                int a4 = sc.nextInt();
                if (a4 >= 6 || a4 <= 0) {
                    System.out.println("Introduce una respuesta válida");
                } else {
                    buclep4 = false;
                }
            }
        }

        public static void pregunta5 () {
            boolean buclep5 = true;
            System.out.println("Quinta Pregunta");
            while (buclep5 == true) {
                System.out.println("¿Esperas el futuro con optimismo?");


                System.out.println("1) Sí, la verdad es que tengo esperanzas");
                System.out.println("2) Definitivamente no, creo que es mejor refugiarse en el pasado");
                System.out.println("3) Creo que es Irrelevante, según el ETERNO RETORNO, de Nietszche, la historia está condenada a repetirse una y otra vez pero nosotros jamás lo veremos porque no vivimos tanto");
                System.out.println("4) XD");

                int a5 = sc.nextInt();
                if (a5 >= 6 || a5 <= 0) {
                    System.out.println("Introduce una respuesta válida");
                } else {
                    buclep5 = false;
                }
                System.out.println("Enhorabuena, has completado tu primera encuesta");
            }
        }


    }
//esta es la versión para responder, originalmente pensamos en hacer 3 usuarios, perfil respuesta, perfil old.creador y perfil empresa
//decidimos concentrar todas las funciones en un usuario.




