package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Creador extends JFrame {

    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_saldo;
    JMenu menu_perfil;
    JMenuItem menuItem_configuracion;
    JMenuItem menuItem_info;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;
    JMenuItem menuItem_inicio2;


    Interfaz_Creador(){
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("¿QUIERES CREAR UNA ENCUESTA?");
        l1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 40));
        panelPrincipal.add(l1);

        add(panelPrincipal);
        crearMenu();
        setJMenuBar(barra);

        setSize(400, 400);
        setVisible(true);

    }

    private void crearMenu() {
        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new ListenerButton());
        menuItem_inicio2 = new JMenuItem("Crear Encuestas");
        menuItem_inicio2.addActionListener(new ListenerButton1());
        menuItem_saldo = new JMenuItem("Mis chukydolares");
        menuItem_saldo.addActionListener(new ListenerButton2());
        menuItem_configuracion = new JMenuItem("Configuracion");
        menuItem_configuracion.addActionListener(new ListenerButton3());
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new ListenerButton4());

        barra.add(menu_inicio);
        barra.add(menu_saldo);
        barra.add(menu_perfil);
        menu_perfil.add(menuItem_configuracion);
        menu_perfil.addSeparator();
        menu_perfil.add(menuItem_info);
        menu_inicio.add(menuItem_inicio);
        menu_inicio.addSeparator();
        menu_inicio.add(menuItem_inicio2);
        menu_saldo.add(menuItem_saldo);


    }

     public static void main() {
        Interfaz_Creador i = new Interfaz_Creador();
    }

    private class ListenerButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class ListenerButton1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class ListenerButton2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class ListenerButton3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class ListenerButton4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
