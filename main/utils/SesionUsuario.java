package main.utils;

import main.models.Usuario;

public class SesionUsuario {
    private static Usuario usr;
    private static SesionUsuario SUsr;

    private SesionUsuario(Usuario usr) {
        this.usr = usr;
    }

    public static void cerrarSesion(){
            SUsr = null;
    }

    public static SesionUsuario iniciarSesion(Usuario usuario){
        if (SUsr == null){
            SUsr = new SesionUsuario(usuario);
        }
        else{

        }
        return SUsr;
    }

    public static SesionUsuario getInstance(){
        if (SUsr == null){
            return null;
        }
        return SUsr;
    }

    public Usuario getUsr() {
        return usr;
    }

    /*
    * Siempre ejecutar tras guardar el nuevo saldo en la BD
    * */
    public void actualizarSaldo(double newSaldo){
        usr.setSaldo(newSaldo);
    }
}
