package main.GUI;

import main.controladores.ControladorUsuario;
import main.models.Usuario;
import main.utils.Acceso;
import main.utils.Saldo;
import main.utils.SesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_logIn extends JFrame {

    public static double saldo;
    JButton confirmar;
    JButton registrarse;
    JTextField usuario;

    JPasswordField contrasenya;

    Color asulitoresulon = new Color(88, 148, 255);
    Color rojitoresulon = new Color(248, 105, 105);

    Interfaz_logIn() {
        //Este metodo es la interfaz

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(13, 1));
        JLabel l1 = new JLabel("Inicio de sesión");
        l1.setFont(new Font("Calibri", Font.PLAIN, 35));
        panelPrincipal.add(l1);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio3);
        JLabel l2 = new JLabel("Nombre de Usuario");
        l2.setFont(new Font("Calibri", Font.PLAIN, 20));
        panelPrincipal.add(l2);
        usuario = new JTextField();
        panelPrincipal.add(usuario);
        JLabel vacio4 = new JLabel("");
        vacio4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio4);
        JLabel l3 = new JLabel("Contraseña");
        l3.setFont(new Font("Calibri", Font.PLAIN, 20));
        panelPrincipal.add(l3);
        contrasenya = new JPasswordField();
        panelPrincipal.add(contrasenya);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio5);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 75, 0));
        registrarse = new JButton("Crear cuenta");
        registrarse.setFont(new Font("Calibri", Font.PLAIN, 15));
        panel2.add(registrarse);
        registrarse.setBackground(rojitoresulon);
        registrarse.addActionListener(new BotonCrearCuenta());

        confirmar = new JButton("CONFIRMAR");
        confirmar.setFont(new Font("Calibri", Font.PLAIN, 15));
        panel2.add(confirmar);
        confirmar.addActionListener(new BotonInicioSesion());
        confirmar.setBackground(asulitoresulon);


        panelPrincipal.add(panel2);
        add(panelPrincipal);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);
    }
    public static void main() {
        Interfaz_logIn i = new Interfaz_logIn();
    }

    private class BotonCrearCuenta implements ActionListener {
        @Override
            public void actionPerformed (ActionEvent e){
            Interfaz_SignIn.main();
            dispose();
        }
    }

    private class BotonInicioSesion implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            String usuarioText = usuario.getText();

            saldo = Saldo.verSaldo(usuarioText);
            String contrasenyaText = new String(contrasenya.getPassword());
            boolean correcto = Acceso.acceso(usuarioText, contrasenyaText);
            if (!usuarioText.equals("") && !contrasenyaText.equals("")) {
                if (correcto) {
                    Usuario usr = ControladorUsuario.getUsuario(usuarioText);
                    SesionUsuario.iniciarSesion(usr);
                    JOptionPane.showMessageDialog(null, "Bienvenido de nuevo " + usuario.getText());
                    Interfaz1.main();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error en acceso. Usuario o contraseña incorrectos.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Introduzca los datos");
            }
        }
    }
}