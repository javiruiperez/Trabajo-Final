package old;

import java.util.Scanner;
public class Tipousuario {
    public static void main(String[] args) {
        boolean buclemain = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre");
        String usrname = sc.nextLine();
        System.out.println("Introduce tu correo electrónico");
        String email = sc.nextLine();
        System.out.println("Introduce una contraseña");
        String passw = sc.nextLine();
        System.out.println("Bienvenido a SurveyDealer");
        System.out.println("presiona 1 para hacer la demo de responder la encuesta, o presiona 2 para la demo de crearla");
        int usrch = sc.nextInt();
        if (usrch >= 5 || usrch <= 0) {
            System.out.println("Introduce una respuesta válida");

        }
        if (usrch == 1) {
        respondedor.main(args);
        }

        if (usrch == 2) {
            System.out.println("Has creado una cuenta de old.creador particular, disfruta creando encuestas y publicándolas o compartiéndolas con tus amigos o familiares.");
            creador.main();
        }else{

            return;

        }







        }
    }

