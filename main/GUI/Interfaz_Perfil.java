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
    JMenuItem menuItem_info;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;

    Interfaz_Perfil(){
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("Estas son las encuestas disponibles");
        l1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 40));
        panelPrincipal.add(l1);

        crearMenu();
        setJMenuBar(barra);
        add(panelPrincipal);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);
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
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new Interfaz_Perfil.informacion());

        menu_perfil.add(menuItem_configuracion);
        menu_perfil.addSeparator();
        menu_perfil.add(menuItem_info);

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
}