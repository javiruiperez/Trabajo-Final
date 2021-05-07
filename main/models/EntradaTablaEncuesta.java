package main.models;

public class EntradaTablaEncuesta {
    int ID_Encuesta;
    double Remuneracion;
    String Titulo;

    public EntradaTablaEncuesta(int ID_Encuesta, double remuneracion, String titulo) {
        this.ID_Encuesta = ID_Encuesta;
        Remuneracion = remuneracion;
        Titulo = titulo;
    }

    public int getID_Encuesta() {
        return ID_Encuesta;
    }

    public void setID_Encuesta(int ID_Encuesta) {
        this.ID_Encuesta = ID_Encuesta;
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
