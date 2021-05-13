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
        // Este metodo es la interfaz

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        JLabel l1 = new JLabel("CREA TU ENCUESTA");
        l1.setFont(new Font("Calibri", Font.PLAIN, 40));
        panelPrincipal.add(l1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout());

        panelPrincipal.add(panel2);

        add(panelPrincipal);
        crearMenu();
        setJMenuBar(barra);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(2100, 2100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void crearMenu() {
        // Este metodo es para crear un menu en la interfaz

        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new encuestas());
        menuItem_inicio2 = new JMenuItem("Crear Encuestas");
        menuItem_inicio2.addActionListener(new crearEncuesta());
        menuItem_saldo = new JMenuItem("Mis chukydolares");
        menuItem_saldo.addActionListener(new saldo());
        menuItem_configuracion = new JMenuItem("Configuracion");
        menuItem_configuracion.addActionListener(new configuracion());
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new informacion());

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

    private class encuestas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        Interfaz1.main();
        dispose();
        }
    }

    private class crearEncuesta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class saldo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class configuracion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

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
