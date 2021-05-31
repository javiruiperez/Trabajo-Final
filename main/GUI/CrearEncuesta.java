package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearEncuesta extends JFrame {

    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_saldo;
    JMenu menu_perfil;
    JMenuItem menuItem_configuracion;
    JMenuItem menuItem_info;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;
    JMenuItem menuItem_inicio2;


    Color asulitoresulon = new Color(0, 79, 255);
    Color rojitoresulon = new Color(255, 0, 0);

    Font letraBotones = new Font("Calibri", Font.PLAIN, 25);
    Font letraTitulos = new Font("Calibri", Font.PLAIN, 40);
    Font letraTexto = new Font("Calibri", Font.PLAIN, 20);
    Font vacio = new Font("Calibri", Font.PLAIN, 1);

    JButton importarCSV;

    CrearEncuesta(){
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1));
        JLabel l1 = new JLabel("IMPORTAR NUEVA ENCUESTA");
        l1.setFont(letraTitulos);
        panelPrincipal.add(l1);
        JLabel vacio1 = new JLabel();
        vacio1.setFont(vacio);
        panelPrincipal.add(vacio1);
        JLabel vacio2 = new JLabel();
        vacio2.setFont(vacio);
        panelPrincipal.add(vacio2);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,1));
        JLabel l2 = new JLabel("Importe su archivo csv para crear una nueva encuesta");
        l2.setFont(letraTexto);
        panel2.add(l2);
        importarCSV = new JButton("IMPORTAR");
        importarCSV.setFont(letraBotones);
        importarCSV.setPreferredSize(new Dimension(100, 50));
        panel2.add(importarCSV);
        importarCSV.addActionListener(new importarcsv());
        importarCSV.setBackground(asulitoresulon);
        importarCSV.setForeground(Color.white);
        panelPrincipal.add(panel2);


        add(panelPrincipal);
        crearMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(barra);
        this.setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(2100, 2100);
        setVisible(true);
    }

    public static void main() {
        CrearEncuesta i = new CrearEncuesta();
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
        menuItem_saldo.addActionListener(new versaldo());
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

    private class verencuestas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal.main();
            dispose();
        }
    }

    private class versaldo implements ActionListener {
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

    private class configuracion implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Perfil.main();
            dispose();
        }
    }

    private class crearencuesta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CrearEncuesta.main();
            dispose();
        }
    }

    private class importarcsv implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
