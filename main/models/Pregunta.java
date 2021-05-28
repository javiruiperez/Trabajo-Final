package main.models;

import java.util.ArrayList;

public class Pregunta {
    int ID_Pregunta;
    String texto;
    ArrayList<Respuesta> respuestas;

    /**
     * Esta clase obtiene los metodos get y set para generar preguntas
     * */

    public Pregunta(int ID_Pregunta, String texto, ArrayList<Respuesta> respuestas) {
        this.ID_Pregunta = ID_Pregunta;
        this.texto = texto;
        this.respuestas = respuestas;
    }

    /*public SoloPregunta(String texto) {
        Texto = texto;
    }*/
    /**
     * Se obtiene el ID_Pregunta
     * */
    public int getID_Pregunta() {
        return ID_Pregunta;
    }
    /**
     * Se genera el ID_Pregunta
     * */
    public void setID_Pregunta(int ID_Pregunta) {
        this.ID_Pregunta = ID_Pregunta;
    }
    /**
     * Se obtiene el titulo de la pregunta
     * */
    public String getTexto() {
        return texto;
    }
    /**
     * Se obtiene el titulo de la pregunta
     * */
    public void setTexto(String Texto) {
        Texto = texto;
    }
    /**
     * Se obtiene el array de las respuestas
     * */
    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }
    /**
     * Se genera el array de las respuestas
     * */
    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "ID_Pregunta=" + ID_Pregunta +
                ", Titulo='" + texto + '\'' +
                ", respuestas=" + respuestas +
                '}';
    }


}
