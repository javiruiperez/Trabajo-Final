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
    JMenuItem menuItem_info;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;
    JMenuItem menuItem_inicio2;

    SesionUsuario sesion = SesionUsuario.getInstance();
    Usuario usr = sesion.getUsr();

    String nombreUsuario = usr.getNombre_usuario();
    String correo = usr.getCorreo();

    Color asulitoresulon = new Color(0, 79, 255);
    Color rojitoresulon = new Color(255, 0, 0);

    Font letraBotones = new Font("Calibri", Font.PLAIN, 25);
    Font letraTitulos = new Font("Calibri", Font.PLAIN, 40);
    Font letraTexto = new Font("Calibri", Font.PLAIN, 20);
    Font vacio = new Font("Calibri", Font.PLAIN, 1);

    JButton cerrarSesion;

    Perfil(){
        // Este metodo es la interfaz perfil que hace que el usuario pueda ver su informacion

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        JLabel l1 = new JLabel("Nombre de Usuario:  " + nombreUsuario);
        l1.setFont(letraTitulos);
        panelPrincipal.add(l1);
        JLabel l2 = new JLabel("Correo Electrónico: " + correo);
        l2.setFont(letraTitulos);
        panelPrincipal.add(l2);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 1));
        JLabel l3 = new JLabel("");
        l3.setFont(letraTexto);
        panel2.add(l3);
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(vacio);
        panel2.add(vacio1);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(vacio);
        panel2.add(vacio2);
        cerrarSesion = new JButton("CERRAR SESION");
        cerrarSesion.setFont(letraBotones);
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
        //Este metodo es para generar un menu en la interfaz

        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new verencuestas());
        menuItem_inicio2 = new JMenuItem("Crear Encuesta");
        menuItem_inicio2.addActionListener(new crearencuesta());
        menuItem_saldo = new JMenuItem("Mis Chukydolares");
        menuItem_saldo.addActionListener(new saldo());
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new informacion());

        barra.add(menu_inicio);
        barra.add(menu_saldo);
        barra.add(menu_perfil);
        menu_perfil.add(menuItem_info);
        menu_inicio.add(menuItem_inicio);
        menu_inicio.addSeparator();
        menu_inicio.add(menuItem_inicio2);
        menu_saldo.add(menuItem_saldo);
    }

    private class verencuestas implements ActionListener {
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
            int seleccion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(seleccion == JOptionPane.YES_OPTION) {
                SesionUsuario.cerrarSesion();
                LogIn.main();
                dispose();
            }else{
            }

        }
    }

    private class crearencuesta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CrearEncuesta.main();
            dispose();
        }
    }
}