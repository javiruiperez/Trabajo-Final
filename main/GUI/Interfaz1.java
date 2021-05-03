package main.GUI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    JTable encuestas;

    JButton comfirmar;
    Color asulitoresulon = new Color(49, 112, 255);

    Interfaz1() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("                            ESTAS SON LAS ENCUESTAS DISPONIBLES");
        l1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 40));
        panelPrincipal.add(l1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3, 300, 200));
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio1);
        comfirmar = new JButton("CONTINUAR");
        comfirmar.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        comfirmar.setPreferredSize(new Dimension(100, 50));
        panel2.add(comfirmar);
        comfirmar.addActionListener(new ListenerButton3());
        comfirmar.setBackground(asulitoresulon);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio2);



        add(panelPrincipal, BorderLayout.NORTH);
        Tabla();
        add(panel2, BorderLayout.SOUTH);
        crearMenu();
        setJMenuBar(barra);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);

    }

    public static void main() {
        Interfaz1 i = new Interfaz1();
    }



    private void crearMenu() {
        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_saldo = new JMenu("Saldo");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new ListenerButton());
        menuItem_saldo = new JMenuItem("Mis chukydolares");
        menuItem_saldo.addActionListener(new ListenerButton1());
        menuItem_configuracion = new JMenuItem("Configuracion");
        menuItem_configuracion.addActionListener(new ListenerButton2());
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new ListenerButton4());



        barra.add(menu_inicio);
        barra.add(menu_saldo);
        barra.add(menu_perfil);
        menu_perfil.add(menuItem_configuracion);
        menu_perfil.addSeparator();
        menu_perfil.add(menuItem_info);
        menu_inicio.add(menuItem_inicio);
        menu_saldo.add(menuItem_saldo);


    }

    private void Tabla() {
        encuestas = new JTable();

        String[] columnNames = {"Encuesta", "Recompensa"};

        Object[][] data = {
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},
                {"Encuesta disponible", "0.50$"},
                {"Encuesta disponible", "0.25$"},


        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(950, 100));

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        for (int c = 0; c < table.getColumnCount(); c++)
        {
            Class<?> col_class = table.getColumnClass(c);
            table.setDefaultEditor(col_class, null); // remove editor
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
}