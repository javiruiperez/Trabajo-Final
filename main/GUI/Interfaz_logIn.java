package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interfaz_logIn extends JFrame {

    JButton confirmar;
    JButton registrarse;
    JTextField usuario;

    String contraseña;

    Color asulitoresulon = new Color(49, 112, 255);
    Color rojitoresulon = new Color(255, 43, 43);

    Interfaz_logIn() {
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(13, 1));
        JLabel l1 = new JLabel("Inicio de sesión");
        l1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 35));
        panelPrincipal.add(l1);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio3);
        JLabel l2 = new JLabel("Nombre de usuario");
        l2.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l2);
        usuario = new JTextField();
        panelPrincipal.add(usuario);
        JLabel vacio4 = new JLabel("");
        vacio4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio4);
        JLabel l3 = new JLabel("Contraseña");
        l3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l3);
        JTextField contraseña = new JPasswordField();
        panelPrincipal.add(contraseña);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio5);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 75, 0));
        registrarse = new JButton("Crear cuenta");
        registrarse.setFont(new Font("Comic Sans Ms", Font.PLAIN, 15));
        panel2.add(registrarse);
        registrarse.setBackground(rojitoresulon);
        registrarse.addActionListener(new BotonCrearCuenta());

        confirmar = new JButton("CONFIRMAR");
        confirmar.setFont(new Font("Comic Sans Ms", Font.PLAIN, 15));
        panel2.add(confirmar);
        confirmar.addActionListener(new BotonInicioSesion());
        confirmar.setBackground(asulitoresulon);


        panelPrincipal.add(panel2);
        add(panelPrincipal);
        setSize(400, 400);
        setVisible(true);
    }
    public static void main(String[] args) {
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
        public void actionPerformed (ActionEvent e){
            String usuarioText = usuario.getText();
            System.out.println(usuarioText);

            new String(contraseña.getPassword());

            /*Boolean correcto = Acceder.comprobarUsuario(usuario, contraseña);
            if (correcto){
                Interfaz_SignIn.main();
                dispose();
            }else {

            }*/

        }
    }



}