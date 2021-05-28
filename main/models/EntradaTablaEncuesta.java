package main.models;

public class EntradaTablaEncuesta {
    int ID_Encuesta;
    int Numero_preguntas;
    double Remuneracion;
    String Titulo;

    /**
     * Esta clase obtiene los metodos get y set para la tabla de encuestas de la interfaz principal
     * */

    public EntradaTablaEncuesta(int ID_Encuesta, int numero_preguntas, double remuneracion, String titulo) {
        this.ID_Encuesta = ID_Encuesta;
        Numero_preguntas = numero_preguntas;
        Remuneracion = remuneracion;
        Titulo = titulo;
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
     * Se obtiene el numero de preguntas
     * */
    public int getNumero_preguntas() {
        return Numero_preguntas;
    }
    /**
     * Se genera el numero de preguntas
     * */
    public void setNumero_preguntas(int Numero_Preguntas) {
        this.Numero_preguntas = Numero_Preguntas;
    }
    /**
     * Se obtiene la remuneracion
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

    @Override
    public String toString() {
        return "EntradaTablaEncuesta{" +
                "ID_Encuesta=" + ID_Encuesta +
                ", Remuneracion=" + Remuneracion +
                ", Titulo='" + Titulo + '\'' +
                '}';
    }
}
