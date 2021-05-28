package main.utils;

import java.util.Base64;

public class Encriptacion {
    /**
     * Esta clase tiene la funcion de encriptar las contraseñas para guardarlas en la base de datos de forma segura.
     * para la encriptacion hemos utilizado Base64 que es un metodo que encripta mediante el uso de la tabla ASCII y
     * código binario
     * */
    public static String cifrar(String contrasenya) {
        String entradaOriginal = contrasenya;
        String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

        return cadenaCodificada;
    }
}
