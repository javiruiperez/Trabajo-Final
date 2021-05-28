package main.utils;

import java.util.Base64;

public class Encriptacion {

    public static String cifrar(String contrasenya) {
        String entradaOriginal = contrasenya;
        String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

        return cadenaCodificada;
    }
}
