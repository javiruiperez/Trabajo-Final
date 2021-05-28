package main.models;

public class Usuario {

    String nombre_usuario;
    String correo;
    double saldo;
    /**
     * Esta clase obtiene los metodos get y set para generar un usuario
     * */
    public Usuario(String nombre_usuario, String correo, double saldo) {
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
        this.saldo = saldo;
    }
    /**
     * Se obtiene el nombre de usuario
     * */
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    /**
     * Se genera el nombre de usuario
     * */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    /**
     * Se obtiene el correo
     * */
    public String getCorreo() {
        return correo;
    }
    /**
     * Se genera el correo
     * */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Se obtiene el saldo
     * */
    public double getSaldo() {
        return saldo;
    }
    /**
     * Se genera el saldo
     * */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre_usuario='" + nombre_usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
