package main.utils;

import PFP.main;

import java.util.Base64;

public class Encriptación {

    public static String cifrar(String contrasenya) {
        String entradaOriginal = contrasenya;
        String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

        System.out.println(cadenaCodificada);
        return cadenaCodificada;
    }
}
