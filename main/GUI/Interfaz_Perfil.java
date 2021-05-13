package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Perfil extends JFrame {

    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_saldo;
    JMenu menu_perfil;
    JMenuItem menuItem_configuracion;
    JMenuItem menuItem_informacion;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;

    String nombreUsuario = "puto";
    String correo = "nico_es_tontisimo@gay.cum";

    JButton cerrarSesion;

    Interfaz_Perfil(){
        // Este metodo es la interfaz perfil que hace que el usuario pueda ver su informacion

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        JLabel l1 = new JLabel("BIENVENIDO " + nombreUsuario);
        l1.setFont(new Font("Calibri", Font.PLAIN, 40));
        panelPrincipal.add(l1);
        JLabel vacio = new JLabel("");
        JLabel l2 = new JLabel(correo);
        l2.setFont(new Font("Calibri", Font.PLAIN, 20));
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
        cerrarSesion.setBackground(Color.white);
        panelPrincipal.add(panel2);


        crearMenu();
        setJMenuBar(barra);
        add(panelPrincipal, BorderLayout.NORTH);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);
    }

    public static void main(String[] args) {
        Interfaz_Perfil i = new Interfaz_Perfil();
    }
    public static void main() {
        Interfaz_Perfil i = new Interfaz_Perfil();
    }

    private void crearMenu() {
        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new Interfaz_Perfil.encuesta());
        menuItem_saldo = new JMenuItem("Mis chukydolares");
        menuItem_saldo.addActionListener(new Interfaz_Perfil.saldo());
        menuItem_configuracion = new JMenuItem("Configuracion");
        menuItem_configuracion.addActionListener(new Interfaz_Perfil.configuracion());
        menuItem_informacion = new JMenuItem("Información");
        menuItem_informacion.addActionListener(new Interfaz_Perfil.informacion());

        menu_perfil.add(menuItem_configuracion);
        menu_perfil.add(menuItem_informacion);

        barra.add(menu_inicio);
        barra.add(menu_saldo);
        barra.add(menu_perfil);
        menu_perfil.add(menuItem_configuracion);
        menu_inicio.add(menuItem_inicio);
        menu_saldo.add(menuItem_saldo);
    }

    private class encuesta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz1.main();
            dispose();
        }
    }

    private class saldo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_Saldo.main();
            dispose();
        }
    }

    private class configuracion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class informacion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Esta aplicación consiste en rellenar o contestar " +
                    "encuestas (dependiendo del tipo de usuario que seas) para así ganar dinero. Si tienes alguna duda, " +
                    "no dudes en contactarnos con nuestro numero de ayuda al cliente (628216335).");
        }
    }

    private class cerrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_logIn.main();
            dispose();
        }
    }
}