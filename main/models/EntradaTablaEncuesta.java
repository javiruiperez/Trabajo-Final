package main.models;

public class EntradaTablaEncuesta {
    int ID_Encuesta;
    int Numero_preguntas;
    double Remuneracion;
    String Titulo;

    public EntradaTablaEncuesta(int ID_Encuesta, int numero_preguntas, double remuneracion, String titulo) {
        this.ID_Encuesta = ID_Encuesta;
        Numero_preguntas = numero_preguntas;
        Remuneracion = remuneracion;
        Titulo = titulo;
    }

    public int getID_Encuesta() {
        return ID_Encuesta;
    }

    public void setID_Encuesta(int ID_Encuesta) {
        this.ID_Encuesta = ID_Encuesta;
    }

    public int getNumero_preguntas() {
        return Numero_preguntas;
    }

    public void setNumero_preguntas(int Numero_Preguntas) {
        this.Numero_preguntas = Numero_Preguntas;
    }

    public double getRemuneracion() {
        return Remuneracion;
    }

    public void setRemuneracion(double remuneracion) {
        Remuneracion = remuneracion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    @Override
    public String toString() {
        return "EntradaTablaEncuesta{" +
                "ID_Encuesta=" + ID_Encuesta +
                ", Remuneracion=" + Remuneracion +
                ", Titulo='" + Titulo + '\'' +
                '}';
    }
}
