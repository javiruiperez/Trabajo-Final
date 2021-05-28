package main.GUI;


import main.models.Usuario;
import main.utils.SesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Perfil extends JFrame {

    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_saldo;
    JMenu menu_perfil;
    JMenuItem menuItem_informacion;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;

    SesionUsuario sesion = SesionUsuario.getInstance();
    Usuario usr = sesion.getUsr();

    String nombreUsuario = usr.getNombre_usuario();
    String correo = usr.getCorreo();

    Color asulitoresulon = new Color(0, 79, 255);
    Color rojitoresulon = new Color(255, 0, 0);

    JButton cerrarSesion;

    Perfil(){
        // Este metodo es la interfaz perfil que hace que el usuario pueda ver su informacion

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        JLabel l1 = new JLabel("Nombre de Usuario:  " + nombreUsuario);
        l1.setFont(new Font("Calibri", Font.PLAIN, 40));
        panelPrincipal.add(l1);
        JLabel l2 = new JLabel("Correo Electrónico: " + correo);
        l2.setFont(new Font("Calibri", Font.PLAIN, 40));
        panelPrincipal.add(l2);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 1));
        JLabel l3 = new JLabel("");
        l3.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel2.add(l3);
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(new Font("Calibri", Font.PLAIN, 1));
        panel2.add(vacio1);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(new Font("Calibri", Font.PLAIN, 1));
        panel2.add(vacio2);
        cerrarSesion = new JButton("CERRAR SESION");
        cerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 25));
        cerrarSesion.addActionListener(new cerrar());
        panel2.add(cerrarSesion);
        cerrarSesion.setBackground(rojitoresulon);
        cerrarSesion.setForeground(Color.white);
        panelPrincipal.add(panel2);


        crearMenu();
        setJMenuBar(barra);
        add(panelPrincipal, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(2100, 2100);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main() {
        Perfil i = new Perfil();
    }

    private void crearMenu() {
        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new encuesta());
        menuItem_saldo = new JMenuItem("Mis chukydolares");
        menuItem_saldo.addActionListener(new saldo());
        menuItem_informacion = new JMenuItem("Información");
        menuItem_informacion.addActionListener(new informacion());

        menu_perfil.add(menuItem_informacion);

        barra.add(menu_inicio);
        barra.add(menu_saldo);
        barra.add(menu_perfil);
        menu_inicio.add(menuItem_inicio);
        menu_saldo.add(menuItem_saldo);
    }

    private class encuesta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal.main();
            dispose();
        }
    }

    private class saldo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Saldo.main();
            dispose();
        }
    }

    private class informacion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Esta aplicación consiste en crear o contestar " +
                    "encuestas para así ganar dinero. Para poder retirar el saldo necesitaras un saldo mínimo retirable de 3€." +
                    " Si tienes alguna duda,no dudes en contactarnos con nuestro numero de ayuda al cliente (628216335).");
        }
    }

    private class cerrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SesionUsuario.cerrarSesion();
            LogIn.main();
            dispose();
        }
    }
}