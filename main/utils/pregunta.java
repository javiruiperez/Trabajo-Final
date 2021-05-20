package main.utils;

public class Pregunta {
    private int ID_Encuesta;
    private String titulo;
    private String r1;
    private String r2;
    private String r3;
    private String r4;


    public Pregunta(int ID_Encuesta, String titulo, String r1, String r2, String r3, String r4) {
        this.ID_Encuesta = ID_Encuesta;
        this.titulo = titulo;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;

    }

    public int getID_Encuesta() {
        return ID_Encuesta;
    }

    public void setID_Encuesta(int ID_Encuesta) {
        this.ID_Encuesta = ID_Encuesta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }


}

