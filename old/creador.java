package old;//Primera versión del programa sin interfaz, hecho a consola
import java.util.Scanner;
public class creador {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("presione 1 para crear una nueva encuesta, o presiona 2 para salir");
        int creachs = sc.nextInt();

        if(creachs == 1) {
            System.out.println("Bienvenido al creador de encuestas");
            System.out.println("A continuación vamos a hacerle una serie de preguntas para crear su encuesta");
            System.out.println("antes de nada haremos un tutorial para la creación de encuestas");
            System.out.println("En una encuesta normal, sería usted quien escogería el número de preguntas, pero para esta vez estableceremos unas 5 preguntas para comenzar");


            System.out.println("Introduce tu primera pregunta");
           sc.nextLine();
            String q1 = sc.nextLine();

            System.out.println("Introduce la primera opción");
            String a11 = sc.nextLine();
            System.out.println("Introduce la segunda opción");
            String a12 = sc.nextLine();
            System.out.println("Introduce la tercera opción");
            String a13 = sc.nextLine();
            System.out.println("Introduce la cuarta opción");
            String a14 = sc.nextLine();



            System.out.println("Introduce la segunda pregunta");
            String q2 = sc.nextLine();

            System.out.println("Introduce la primera opción");
            String a21 = sc.nextLine();
            System.out.println("Introduce la segunda opción");
            String a22 = sc.nextLine();
            System.out.println("Introduce la tercera opción");
            String a23 = sc.nextLine();
            System.out.println("Introduce la cuarta opción");
            String a24 = sc.nextLine();



            System.out.println("Ya estamos a mitad de camino, introduce la tercera pregunta");
            String q3 = sc.nextLine();

            System.out.println();
            System.out.println("Introduce la primera opción");
            String a31 = sc.nextLine();
            System.out.println("Introduce la segunda opción");
            String a32 = sc.nextLine();
            System.out.println("Introduce la tercera opción");
            String a33 = sc.nextLine();
            System.out.println("Introduce la cuarta opción");
            String a34 = sc.nextLine();



            System.out.println("un poquito más, Introduce la cuarta pregunta");
            String q4 = sc.nextLine();

            System.out.println("Introduce la primera opción");
            String a41 = sc.nextLine();
            System.out.println("Introduce la segunda opción");
            String a42 = sc.nextLine();
            System.out.println("Introduce la tercera opción");
            String a43 = sc.nextLine();
            System.out.println("Introduce la cuarta opción");
            String a44 = sc.nextLine();



            System.out.println("una más, Introduce la última pregunta");
            String q5 = sc.nextLine();

            System.out.println("Introduce la primera opción");
            String a51 = sc.nextLine();
            System.out.println("Introduce la segunda opción");
            String a52 = sc.nextLine();
            System.out.println("Introduce la tercera opción");
            String a53 = sc.nextLine();
            System.out.println("Introduce la cuarta opción");
            String a54 = sc.nextLine();

            System.out.println("Enhorabuena, has creado tu primera encuesta");
            System.out.println("presiona 1 para probarla, o 2 para salir (nota: esta encuesta es una demo, se borrará en cuanto abandones la aplicación");
            int tryqu = sc.nextInt();
            if (tryqu == 1){
                System.out.println("comienza la prueba");
                System.out.println("primera pregunta:");
                System.out.println(q1);
                System.out.println("presione 1 para " + a11);
                System.out.println("presione 2 para " + a12);
                System.out.println("presione 3 para " + a13);
                System.out.println("presione 4 para " + a14);
                int OP1 = sc.nextInt();

                System.out.println(q2);
                System.out.println("presione 1 para " + a21);
                System.out.println("presione 2 para " + a22);
                System.out.println("presione 3 para " + a23);
                System.out.println("presione 4 para " + a24);
                int OP2 = sc.nextInt();

                System.out.println(q3);
                System.out.println("presione 1 para " + a31);
                System.out.println("presione 2 para " + a32);
                System.out.println("presione 3 para " + a33);
                System.out.println("presione 4 para " + a34);
                int OP3 = sc.nextInt();

                System.out.println(q4);
                System.out.println("presione 1 para " + a41);
                System.out.println("presione 2 para " + a42);
                System.out.println("presione 3 para " + a43);
                System.out.println("presione 4 para " + a44);
                int OP4 = sc.nextInt();

                System.out.println(q5);
                System.out.println("presione 1 para " + a51);
                System.out.println("presione 2 para " + a52);
                System.out.println("presione 3 para " + a53);
                System.out.println("presione 4 para " + a54);
                int OP5 = sc.nextInt();

                System.out.println("la encuesta ha finalizado");
            }
            if (tryqu == 2){
                System.exit(tryqu);
            }
        }

        if(creachs == 2){
            System.out.println("De acuerdo, ya nos veremos :D");
            System.exit(creachs);
        }

        else{
            System.out.println("Por favor, introduce una opción correcta");
        }
    }
}
//En esta versión podemos apreciar que las preguntas están hechas a hardcode, es decir, únicamente se introducen los textos en forma de scanner
//sin un bucle que regule el número de preguntas.
//pusimos un if que regulase las preguntas para que las respuestas fuesen válidas
//El programa consiste en que al creador se le solicita mediante println que introduzca una serie de preguntas con sus respuestas (5 pregs y 4 respuestas cada una
//una vez el usuario las ha introducido el programa le pregunta si quiere continuar o por el contrario desea salir.