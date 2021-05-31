package main.GUI;

import main.controladores.ControladorEncuesta;
import main.models.EntradaTablaEncuesta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame {

    ArrayList<EntradaTablaEncuesta> entradasTabla;

    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_saldo;
    JMenu menu_perfil;
    JMenuItem menuItem_configuracion;
    JMenuItem menuItem_info;
    JMenuItem menuItem_saldo;
    JMenuItem menuItem_inicio;
    JMenuItem menuItem_inicio2;


    JTable encuestas;

    JButton comfirmar;
    JButton grafico;

    Color asulitoresulon = new Color(0, 79, 255);

    Font letraBotones = new Font("Calibri", Font.PLAIN, 25);
    Font letraTitulos = new Font("Calibri", Font.PLAIN, 40);
    Font letraTexto = new Font("Calibri", Font.PLAIN, 20);
    Font vacio = new Font("Calibri", Font.PLAIN, 1);

    MenuPrincipal() {
        // Este metodo es la interfaz

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("ESTAS SON LAS ENCUESTAS DISPONIBLES");
        l1.setFont(letraTitulos);
        panelPrincipal.add(l1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 5, 150, 100));
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(vacio);
        panel2.add(vacio1);
        grafico = new JButton("GRAFICO");
        grafico.setFont(letraBotones);
        grafico.setPreferredSize(new Dimension(100, 50));
        panel2.add(grafico);
        grafico.addActionListener(new graficos());
        grafico.setBackground(asulitoresulon);
        grafico.setForeground(Color.white);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(vacio);
        panel2.add(vacio2);
        comfirmar = new JButton("CONTINUAR");
        comfirmar.setFont(letraBotones);
        comfirmar.setPreferredSize(new Dimension(100, 50));
        panel2.add(comfirmar);
        comfirmar.addActionListener(new continuar());
        comfirmar.setBackground(asulitoresulon);
        comfirmar.setForeground(Color.white);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(vacio);
        panel2.add(vacio3);


        add(panelPrincipal, BorderLayout.NORTH);
        Tabla();
        add(panel2, BorderLayout.SOUTH);
        crearMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(barra);
        this.setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(2100, 2100);
        setVisible(true);

    }

    public static void main() {
        MenuPrincipal i = new MenuPrincipal();
    }

    private void crearMenu() {
        //Este metodo es para generar un menu en la interfaz

        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new verencuestas());
        menuItem_inicio2 = new JMenuItem("Crear Encuestas");
        menuItem_inicio2.addActionListener(new crearencuestas());
        menuItem_saldo = new JMenuItem("Mis chukydol ares");
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

        entradasTabla = ControladorEncuesta.getEntradas();

        encuestas = new JTable();


        String col[] = {"Encuestas Disponibles", "Número de Preguntas" ,"Recompensa"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        encuestas = new JTable(tableModel);
        encuestas.setPreferredScrollableViewportSize(new Dimension(950, 100));
        JScrollPane scrollPane = new JScrollPane(encuestas);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        encuestas.setBounds(780, 422, -612, -284);

        for (int i = 0; i < entradasTabla.size(); i++) {
            String titulo = entradasTabla.get(i).getTitulo();
            double remuneracion = entradasTabla.get(i).getRemuneracion();
            int numpregs = entradasTabla.get(i).getNumero_preguntas();


            Object[] encuesta = {titulo, numpregs,remuneracion + "€"};
            tableModel.addRow(encuesta);

        }
        for (int c = 0; c < encuestas.getColumnCount(); c++) {
            Class<?> col_class = encuestas.getColumnClass(c);
            encuestas.setDefaultEditor(col_class, null); // remove editor
        }
    }

    private class verencuestas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal.main();
            dispose();
        }
    }

    private class crearencuestas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_Creador.main();
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

    private class continuar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = encuestas.getSelectedRow();
            EntradaTablaEncuesta entrada = entradasTabla.get(row);
            int idEncuesta = entrada.getID_Encuesta();
        Encuesta.main(idEncuesta);
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

    private class graficos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = encuestas.getSelectedRow();
            EntradaTablaEncuesta entrada = entradasTabla.get(row);
            int idEncuesta = entrada.getID_Encuesta();
            Gráfico.main(idEncuesta);
            dispose();
        }
    }
}