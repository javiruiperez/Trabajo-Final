package main.models;

public class Usuario {
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    String nombre_usuario;
    String correo;
    double saldo;

    public Usuario(String nombre_usuario, String correo, double saldo) {
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
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
