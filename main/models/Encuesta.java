package main.models;

import java.util.ArrayList;

public class Encuesta {
    int ID_Encuesta;
    String Titulo;
    int Numero_Preguntas;
    double Remuneracion;
    String Nombre_Usuario;
    ArrayList<Pregunta> preguntas;

    public Encuesta(int ID_Encuesta, String titulo, int numero_Preguntas, double remuneracion, String nombre_Usuario, ArrayList<Pregunta> preguntas) {
        this.ID_Encuesta = ID_Encuesta;
        Titulo = titulo;
        Numero_Preguntas = numero_Preguntas;
        Remuneracion = remuneracion;
        Nombre_Usuario = nombre_Usuario;
        this.preguntas = preguntas;
    }

    public int getID_Encuesta() {
        return ID_Encuesta;
    }

    public void setID_Encuesta(int ID_Encuesta) {
        this.ID_Encuesta = ID_Encuesta;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getNumero_Preguntas() {
        return Numero_Preguntas;
    }

    public void setNumero_Preguntas(int numero_Preguntas) {
        Numero_Preguntas = numero_Preguntas;
    }

    public double getRemuneracion() {
        return Remuneracion;
    }

    public void setRemuneracion(double remuneracion) {
        Remuneracion = remuneracion;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        Nombre_Usuario = nombre_Usuario;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "ID_Encuesta=" + ID_Encuesta +
                ", Titulo='" + Titulo + '\'' +
                ", Numero_Preguntas=" + Numero_Preguntas +
                ", Remuneracion=" + Remuneracion +
                ", Nombre_Usuario='" + Nombre_Usuario + '\'' +
                ", preguntas=" + preguntas +
                '}';
    }
}
