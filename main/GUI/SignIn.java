package main.GUI;

import main.utils.Registro;
import main.utils.Verificar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame {

    JButton cancelar;
    JButton registrarse;

    JTextField usuario;
    JTextField correo;
    JPasswordField contrasenya;
    JPasswordField contrasenya_ok;

    Color asulitoresulon = new Color(0, 79, 255);
    Color rojitoresulon = new Color(255, 0, 0);

    Font letraBotones = new Font("Calibri", Font.PLAIN, 20);
    Font letraTitulos = new Font("Calibri", Font.PLAIN, 40);
    Font letraTexto = new Font("Calibri", Font.PLAIN, 20);
    Font vacio = new Font("Calibri", Font.PLAIN, 1);

    SignIn() {
        // Este metodo es la interfaz

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(15, 1));
        JLabel l1 = new JLabel("Registro de usuarios");
        l1.setFont(letraTitulos);
        panelPrincipal.add(l1);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(vacio);
        panelPrincipal.add(vacio3);
        JLabel l2 = new JLabel("Nombre de usuario");
        l2.setFont(letraTexto);
        panelPrincipal.add(l2);
        usuario = new JTextField();
        panelPrincipal.add(usuario);
        JLabel vacio4 = new JLabel("");
        vacio4.setFont(vacio);
        panelPrincipal.add(vacio4);
        JLabel l3 = new JLabel("Correo electronico");
        l3.setFont(letraTexto);
        panelPrincipal.add(l3);
        correo = new JTextField();
        panelPrincipal.add(correo);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(vacio);
        panelPrincipal.add(vacio5);
        JLabel l4 = new JLabel("Contraseña");
        l4.setFont(letraTexto);
        panelPrincipal.add(l4);
        contrasenya = new JPasswordField();
        panelPrincipal.add(contrasenya);
        JLabel vacio6 = new JLabel("");
        vacio6.setFont(vacio);
        panelPrincipal.add(vacio6);
        JLabel l5 = new JLabel("Repita la contraseña");
        l5.setFont(letraTexto);
        panelPrincipal.add(l5);
        contrasenya_ok = new JPasswordField();
        panelPrincipal.add(contrasenya_ok);
        JLabel vacio7 = new JLabel("");
        vacio7.setFont(vacio);
        panelPrincipal.add(vacio7);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 75, 0));
        cancelar = new JButton("CANCELAR");
        cancelar.setFont(letraBotones);
        panel2.add(cancelar);
        cancelar.setBackground(rojitoresulon);
        cancelar.setForeground(Color.white);
        cancelar.addActionListener(new SignIn.BotonCancelar());
        registrarse = new JButton("REGISTRARSE");
        registrarse.setFont(letraBotones);
        panel2.add(registrarse);
        registrarse.setBackground(asulitoresulon);
        registrarse.setForeground(Color.white);
        registrarse.addActionListener(new SignIn.BotonRegistrarse());



        panelPrincipal.add(panel2);
        add(panelPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(2000, 2000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main() {
        SignIn i = new SignIn();
    }

    private class BotonCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Entrada.main();
            dispose();
        }
    }

    private class BotonRegistrarse implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String usuarioText = usuario.getText();
            String correoText = correo.getText();
            String contrasenyaText = new String(contrasenya.getPassword());
            String verifica = new String(contrasenya_ok.getPassword());

            boolean comprobacionCorreo = Verificar.verificarCorreo(correoText);
            boolean comprobacionUsuarioCorreo = Verificar.verificarUsuarioCorreo(usuarioText, correoText);
            boolean verificarregistro = Registro.comprobacion(comprobacionCorreo, comprobacionUsuarioCorreo, usuarioText, correoText, contrasenyaText, verifica);

            if (verificarregistro) {
                Registro.registro(usuarioText, correoText, contrasenyaText);
                JOptionPane.showMessageDialog(null, "Su cuenta ha sido creada con éxito");
                dispose();
                MenuPrincipal.main();
            }
        }
    }
}
