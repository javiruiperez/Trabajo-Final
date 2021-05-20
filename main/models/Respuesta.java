package main.models;

public class Respuesta {
    int ID_Respuesta;
    String texto;

    public Respuesta(int ID_Respuesta, String texto) {
        this.ID_Respuesta = ID_Respuesta;
        this.texto = texto;
    }


    public int getID_Respuesta() {
        return ID_Respuesta;
    }

    public void setID_Respuesta(int ID_Respuesta) {
        this.ID_Respuesta = ID_Respuesta;
    }

    public String getTexto() {
        return texto;
    }

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
