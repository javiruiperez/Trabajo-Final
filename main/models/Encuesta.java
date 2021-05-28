package main.models;

import java.util.ArrayList;

public class Encuesta {
    int ID_Encuesta;
    String Titulo;
    int Numero_Preguntas;
    double Remuneracion;
    String Nombre_Usuario;
    ArrayList<Pregunta> preguntas;

    /**
     * Esta clase obtiene los metodos get y set para encuestas
     * */
    public Encuesta(int ID_Encuesta, String titulo, int numero_Preguntas, double remuneracion, String nombre_Usuario, ArrayList<Pregunta> preguntas) {
        this.ID_Encuesta = ID_Encuesta;
        Titulo = titulo;
        Numero_Preguntas = numero_Preguntas;
        Remuneracion = remuneracion;
        Nombre_Usuario = nombre_Usuario;
        this.preguntas = preguntas;
    }

    /**
     * Se obtiene el ID_Encuesta
     * */
    public int getID_Encuesta() {
        return ID_Encuesta;
    }
    /**
     * Se genera el ID_Encuesta
     * */
    public void setID_Encuesta(int ID_Encuesta) {
        this.ID_Encuesta = ID_Encuesta;
    }
    /**
     * Se obtiene el titulo de la encuesta
     * */
    public String getTitulo() {
        return Titulo;
    }
    /**
     * Se genera el titulo de la encuesta
     * */
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    /**
     * Se obtiene el numero de preguntas
     * */
    public int getNumero_Preguntas() {
        return Numero_Preguntas;
    }
    /**
     * Se genera el numero de preguntas
     * */
    public void setNumero_Preguntas(int numero_Preguntas) {
        Numero_Preguntas = numero_Preguntas;
    }
    /**
     * Se obtiene la remuneración
     * */
    public double getRemuneracion() {
        return Remuneracion;
    }
    /**
     * Se genera la remuneracion
     * */
    public void setRemuneracion(double remuneracion) {
        Remuneracion = remuneracion;
    }
    /**
     * Se obtiene el nombre del usuario
     * */
    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }
    /**
     * Se genera el nombre del usuario
     * */
    public void setNombre_Usuario(String nombre_Usuario) {
        Nombre_Usuario = nombre_Usuario;
    }
    /**
     * Se obtiene el arraylist de preguntas
     * */
    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }
    /**
     * Se genera el aaraylist de preguntas
     * */
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
