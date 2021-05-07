package main.controladores;

import main.models.*;


import java.util.ArrayList;

public class pruebaControladores {
    public static void main(String[] args) {
        //PruebaRespuestas();
        //PruebaPreguntas();
        PruebaEncuesta();
        //PruebaEntradas();
    }

    private static void PruebaEntradas(){
        ArrayList<EntradaTablaEncuesta> entradas = ControladorEncuesta.getEntradas();
        for (int i = 0; i < entradas.size(); i++) {
            EntradaTablaEncuesta enc = entradas.get(i);
            System.out.println(enc);
        }
    }

    private static void PruebaEncuesta(){
        Encuesta enc = ControladorEncuesta.getEncuesta(2);
        System.out.println(enc.toString());
    }

   /* private static void PruebaPreguntas(){
        ArrayList<Pregunta> preguntas = ControladorEncuesta.getPreguntas(1);
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pre = preguntas.get(i);
            System.out.println(pre.toString());
        }
    }

    private static void PruebaRespuestas() {
        ArrayList<Respuesta> respuestas = ControladorEncuesta.getRespuestas(1);
        for (int i = 0; i < respuestas.size(); i++) {
            Respuesta res = respuestas.get(i);
            System.out.println(res.toString());
        }
    }*/
}
