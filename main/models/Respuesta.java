package main.models;

public class Respuesta {
    int ID_Respuesta;
    String texto;

    /**
     * Esta clase obtiene los metodos get y set para las respuestas de las preguntas
     * */

    public Respuesta(int ID_Respuesta, String texto) {
        this.ID_Respuesta = ID_Respuesta;
        this.texto = texto;
    }

    /**
     * Se obtiene el ID_Respuesta
     * */
    public int getID_Respuesta() {
        return ID_Respuesta;
    }
    /**
     * Se genera el ID_Respuesta
     * */
    public void setID_Respuesta(int ID_Respuesta) {
        this.ID_Respuesta = ID_Respuesta;
    }
    /**
     * Se obtiene el titulo de la pregunta
     * */
    public String getTexto() {
        return texto;
    }
    /**
     * Se genera el titulo de la pregunta
     * */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "ID_Respuesta=" + ID_Respuesta +
                ", texto='" + texto + '\'' +
                '}';
    }
}
