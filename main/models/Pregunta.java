package main.models;

import java.util.ArrayList;

public class Pregunta {
    int ID_Pregunta;
    String Texto;
    ArrayList<Respuesta> respuestas;

    public Pregunta(int ID_Pregunta, String texto, ArrayList<Respuesta> respuestas) {
        this.ID_Pregunta = ID_Pregunta;
        Texto = texto;
        this.respuestas = respuestas;
    }

    /*public SoloPregunta(String texto) {
        Texto = texto;
    }*/

    public int getID_Pregunta() {
        return ID_Pregunta;
    }

    public void setID_Pregunta(int ID_Pregunta) {
        this.ID_Pregunta = ID_Pregunta;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "ID_Pregunta=" + ID_Pregunta +
                ", Texto='" + Texto + '\'' +
                ", respuestas=" + respuestas +
                '}';
    }
}
