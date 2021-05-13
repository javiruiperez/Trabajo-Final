package main.GUI;

import main.controladores.ControladorEncuesta;
import main.models.Encuesta;
import main.models.EntradaTablaEncuesta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz1 extends JFrame {

    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_saldo;
    JMenu menu_perfil;
    JMenuItem menuItem_configuracion;
    JMenuItem menuItem_info;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;
    JMenuItem menuItem_inicio2;

    ArrayList<EntradaTablaEncuesta> encuesta1 = ControladorEncuesta.getEntradas();

    JTable encuestas;

    JButton comfirmar;
    Color asulitoresulon = new Color(88, 148, 255);

    Interfaz1() {
        // Este metodo es la interfaz

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("ESTAS SON LAS ENCUESTAS DISPONIBLES");
        l1.setFont(new Font("Calibri", Font.PLAIN, 40));
        panelPrincipal.add(l1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3, 300, 200));
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio1);
        comfirmar = new JButton("CONTINUAR");
        comfirmar.setFont(new Font("Calibri", Font.PLAIN, 20));
        comfirmar.setPreferredSize(new Dimension(100, 50));
        panel2.add(comfirmar);
        comfirmar.addActionListener(new continuar());
        comfirmar.setBackground(asulitoresulon);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(new Font("Calibri", Font.PLAIN, 1));
        panel2.add(vacio2);

        /*JScrollPane scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setBounds(50,50,300,300);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);*/

        add(panelPrincipal, BorderLayout.NORTH);
        Tabla();
        add(panel2, BorderLayout.SOUTH);
        crearMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(barra);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);

    }

    public static void main() {
        Interfaz1 i = new Interfaz1();
    }

    private void crearMenu() {
        // Este metodo es para generar un menu en la interfaz

        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new ListenerButton());
        menuItem_inicio2 = new JMenuItem("Crear Encuestas");
        menuItem_inicio2.addActionListener(new ListenerButton1());
        menuItem_saldo = new JMenuItem("Mis chukydolares");
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

    private void Tabla() {
        // Este metodo es para generar una tabla en la interfaz

        ArrayList<EntradaTablaEncuesta> entradasTabla = ControladorEncuesta.getEntradas();
        encuestas = new JTable();


        String col[] = {"Encuestas Disponibles", "Recompensa"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        encuestas = new JTable(tableModel);
        encuestas.setPreferredScrollableViewportSize(new Dimension(950, 100));
        JScrollPane scrollPane = new JScrollPane(encuestas);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        for (int i = 0; i < entradasTabla.size(); i++) {
            String titulo = entradasTabla.get(i).getTitulo();
            double remuneracion = entradasTabla.get(i).getRemuneracion();


            Object[] encuesta = {titulo, remuneracion + "€"};
            tableModel.addRow(encuesta);
        }
        for (int c = 0; c < encuestas.getColumnCount(); c++) {
            Class<?> col_class = encuestas.getColumnClass(c);
            encuestas.setDefaultEditor(col_class, null); // remove editor
        }
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
            Interfaz_Creador.main();
            dispose();
        }
    }

    private class versaldo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_Saldo.main();
            dispose();
        }
    }

    private class continuar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        //Interfaz_EncuestaPred.main();
        //dispose();
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
    private class configuracion implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        Interfaz_Perfil.main();
        dispose();
        }
    }
}