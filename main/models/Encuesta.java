package main.models;

import java.util.ArrayList;

public class Encuesta {
    int ID_Encuesta;
    String Titulo;
    double Remuneracion;
    String Nombre_Usuario;
    ArrayList<Pregunta> preguntas;

    public Encuesta(String titulo, double remuneracion, String nombre_Usuario) {
        Titulo = titulo;
        Remuneracion = remuneracion;
        Nombre_Usuario = nombre_Usuario;
        this.preguntas = this.preguntas;
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
                ", Remuneracion=" + Remuneracion +
                ", Nombre_Usuario='" + Nombre_Usuario + '\'' +
                ", preguntas=" + preguntas +
                '}';
    }
}
