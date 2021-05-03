package main.GUI;

import main.utils.Registro;

import javax.lang.model.util.SimpleTypeVisitor7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_SignIn extends JFrame {

    JButton cancelar;
    JButton registrarse;

    JTextField usuario;
    JTextField correo;
    JPasswordField contraseña;
    JPasswordField contraseña_ok;

    Color asulitoresulon = new Color(70, 117, 246);
    Color rojitoresulon = new Color(212, 41, 41, 255);

    Interfaz_SignIn() {
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(15, 1));
        JLabel l1 = new JLabel("Registro de usuarios");
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
        JLabel l3 = new JLabel("Correo electronico");
        l3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l3);
        correo = new JTextField();
        panelPrincipal.add(correo);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio5);
        JLabel l4 = new JLabel("Contraseña");
        l4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l4);
        contraseña = new JPasswordField();
        panelPrincipal.add(contraseña);
        JLabel vacio6 = new JLabel("");
        vacio6.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio6);
        JLabel l5 = new JLabel("Repita la contraseña");
        l5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l5);
        contraseña_ok = new JPasswordField();
        panelPrincipal.add(contraseña_ok);
        JLabel vacio7 = new JLabel("");
        vacio7.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio7);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 75, 0));
        cancelar = new JButton("CANCELAR");
        cancelar.setFont(new Font("Comic Sans Ms", Font.PLAIN, 15));
        panel2.add(cancelar);
        cancelar.setBackground(rojitoresulon);
        cancelar.addActionListener(new Interfaz_SignIn.BotonCancelar());
        registrarse = new JButton("REGISTRARSE");
        registrarse.setFont(new Font("Comic Sans Ms", Font.PLAIN, 15));
        panel2.add(registrarse);
        registrarse.setBackground(asulitoresulon);
        registrarse.addActionListener(new Interfaz_SignIn.BotonRegistrarse());



        panelPrincipal.add(panel2);
        add(panelPrincipal);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);
    }

    public static void main() {
        Interfaz_SignIn i = new Interfaz_SignIn();
    }

    private class BotonCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_Entrada.main();
            dispose();
        }
    }

    private class BotonRegistrarse implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuarioText = usuario.getText();
            String correoText = correo.getText();
            String contraseñaText = new String(contraseña.getPassword());
            String verifica = new String(contraseña_ok.getPassword());

            if (contraseñaText.equals(verifica)){
                Registro.registro(usuarioText, correoText, contraseñaText);
                JOptionPane.showMessageDialog(null, "Su cuenta ha sido creada con éxito");
                dispose();
                Interfaz1.main();
            }else{
                JOptionPane.showMessageDialog(null, "Introduzca la contraseña correctamente");
            }
        }
    }
}
