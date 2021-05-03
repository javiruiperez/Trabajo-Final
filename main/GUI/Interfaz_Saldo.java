package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Saldo extends JFrame {
    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_saldo;
    JMenu menu_perfil;
    JMenuItem menuItem_configuracion;
    JMenuItem menuItem_info;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;
    JMenuItem menuItem_inicio2;


    private JButton uno;
    private JButton dos;
    private JButton saldo;

    Interfaz_Saldo(){
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        JLabel l1 = new JLabel("                   SALDO                    ");
        l1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 40));
        panelPrincipal.add(l1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 3));
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio1);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio2);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio3);
        JLabel vacio4 = new JLabel("");
        vacio4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio4);
        saldo = new JButton("2,47€");
        saldo.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
        panel2.add(saldo);
        saldo.setBackground(Color.white);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio5);
        JLabel vacio6 = new JLabel("");
        vacio6.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio6);
        JLabel vacio7 = new JLabel("");
        vacio7.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio7);
        JLabel vacio8 = new JLabel("");
        vacio8.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio8);
        JLabel vacio9 = new JLabel("");
        vacio9.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio9);
        JLabel vacio10 = new JLabel("");
        vacio10.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio10);
        JLabel vacio11 = new JLabel("");
        vacio11.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio11);
        panelPrincipal.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2, 150, 400));
        uno = new JButton();
        uno.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
        panel3.add(uno);
        uno.setBackground(Color.white);
        Imagen Imagen = new Imagen();
        uno.add(Imagen);
        uno.addActionListener(new ListenerButton3());
        dos = new JButton();
        dos.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
        panel3.add(dos);
        dos.setBackground(Color.white);
        Imagen2 Imagen2 = new Imagen2();
        dos.add(Imagen2);
        dos.addActionListener(new ListenerButton4());
        panelPrincipal.add(panel3);


        crearMenu();
        setJMenuBar(barra);
        add(panelPrincipal);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);
    }

    public static void main() {
        Interfaz_Saldo i = new Interfaz_Saldo();
    }

    private void crearMenu() {
        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new Interfaz_Saldo.ListenerButton());
        menuItem_saldo = new JMenuItem("Mis chukydolares");
        menuItem_saldo.addActionListener(new Interfaz_Saldo.ListenerButton1());
        menuItem_configuracion = new JMenuItem("Configuracion");
        menuItem_configuracion.addActionListener(new Interfaz_Saldo.ListenerButton2());
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new Interfaz_Saldo.ListenerButton5());

        barra.add(menu_inicio);
        barra.add(menu_saldo);
        barra.add(menu_perfil);
        menu_perfil.add(menuItem_configuracion);
        menu_perfil.addSeparator();
        menu_perfil.add(menuItem_info);
        menu_inicio.add(menuItem_inicio);
        menu_saldo.add(menuItem_saldo);
    }

    private class ListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz1.main();
            dispose();
        }
    }

    private class ListenerButton1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_Saldo.main();
            dispose();
        }
    }

    private class ListenerButton2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_Perfil.main();
            dispose();
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

    private class ListenerButton5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}