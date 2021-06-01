package main.GUI;

import main.models.Usuario;
import main.utils.SesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Aquí se muestra el saldo disponible ganado en las encuestas
//puedes sacar los fondos por tarjeta o por paypal
public class Saldo extends JFrame {

    //aquí se llama a la instancia para coger al usuario
    SesionUsuario sesion = SesionUsuario.getInstance();
    Usuario usr = sesion.getUsr();

    //aquí se utiliza un math.round para redondear el saldo que se muestra en la interfaz
    double mostrarsaldo = usr.getSaldo();
    double redondeo = Math.round(mostrarsaldo * 100.0) / 100.0;

    JMenuBar barra;
    JMenu menu_inicio;
    JMenu menu_perfil;
    JMenuItem menuItem_configuracion;
    JMenuItem menuItem_info;
    JMenuItem menuItem_inicio;
    JMenuItem menuItem_inicio2;


    private JButton uno;
    private JButton dos;
    private JButton saldo;

    Color asulitoresulon = new Color(0, 79, 255);
    Color colorSaldo = new Color(255, 213, 0);

    Font letraBotones = new Font("Calibri", Font.PLAIN, 25);
    Font letraTitulos = new Font("Calibri", Font.PLAIN, 40);
    Font letraTexto = new Font("Calibri", Font.PLAIN, 20);
    Font vacio = new Font("Calibri", Font.PLAIN, 1);

    Saldo(){
        // Este metodo es la interfaz

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        JLabel l1 = new JLabel("                            SALDO                    ");
        l1.setFont(letraTitulos);
        panelPrincipal.add(l1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 3));
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(vacio);
        panel2.add(vacio1);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(vacio);
        panel2.add(vacio2);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(vacio);
        panel2.add(vacio3);
        JLabel vacio4 = new JLabel("");
        vacio4.setFont(vacio);
        panel2.add(vacio4);

        saldo = new JButton(redondeo + "€");
        saldo.setFont(letraBotones);
        panel2.add(saldo);
        saldo.setBackground(colorSaldo);
        saldo.setForeground(Color.white);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(vacio);
        panel2.add(vacio5);
        JLabel vacio6 = new JLabel("");
        vacio6.setFont(vacio);
        panel2.add(vacio6);
        JLabel l2= new JLabel("Elige metodo de retirada");
        l2.setFont(letraTexto);
        panel2.add(l2);
        JLabel vacio8 = new JLabel("");
        vacio8.setFont(vacio);
        panel2.add(vacio8);
        JLabel vacio9 = new JLabel("");
        vacio9.setFont(vacio);
        panel2.add(vacio9);
        JLabel vacio10 = new JLabel("");
        vacio10.setFont(vacio);
        panel2.add(vacio10);
        JLabel vacio11 = new JLabel("");
        vacio11.setFont(vacio);
        panel2.add(vacio11);
        panelPrincipal.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2, 150, 400));
        uno = new JButton();
        uno.setFont(letraBotones);
        panel3.add(uno);
        uno.setBackground(Color.white);
        Imagen_Paypal Imagen = new Imagen_Paypal();
        uno.add(Imagen);
        uno.addActionListener(new imagen1());
        dos = new JButton();
        dos.setFont(letraBotones);
        panel3.add(dos);
        dos.setBackground(Color.white);
        Imagen_Tarjeta Imagen2 = new Imagen_Tarjeta();
        dos.add(Imagen2);
        dos.addActionListener(new imagen2());
        panelPrincipal.add(panel3);


        crearMenu();
        setJMenuBar(barra);
        add(panelPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(2100, 2100);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main() {
        Saldo i = new Saldo();
    }

    private void crearMenu() {
        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new encuestas());
        menuItem_inicio2 = new JMenuItem("Crear encuestas");
        menuItem_inicio2.addActionListener(new crearencuesta());
        menuItem_configuracion = new JMenuItem("Configuracion");
        menuItem_configuracion.addActionListener(new configuracion());
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new informacion());

        barra.add(menu_inicio);
        barra.add(menu_perfil);
        menu_perfil.add(menuItem_configuracion);
        menu_perfil.addSeparator();
        menu_perfil.add(menuItem_info);
        menu_inicio.add(menuItem_inicio);
    }

    private class encuestas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal.main();
            dispose();
        }
    }

    private class configuracion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        Perfil.main();
        }
    }

    private class imagen1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //aquí se retira el saldo de la base de datos y se hacen diferentes comparaciones
            if (usr.getSaldo() != 0) {
                if (usr.getSaldo() > 0 && usr.getSaldo() < 3) {
                    JOptionPane.showMessageDialog(null, "No has alcanzado el saldo mínimo retirable de 3€");
                }else{
                    main.utils.Saldo.sacarSaldo();
                    SesionUsuario.getInstance().actualizarSaldo(0.0);
                    JOptionPane.showMessageDialog(null, "Se ha retirado su saldo correctamente");
                    MenuPrincipal.main();
                    dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "No tienes saldo disponible para retirar");
            }
        }
    }

    private class imagen2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //aquí se retira el saldo de la base de datos y se hacen diferentes comparaciones
            if (usr.getSaldo() != 0) {
                if (usr.getSaldo() > 0 && usr.getSaldo() < 3) {
                    JOptionPane.showMessageDialog(null, "No has alcanzado el saldo mínimo retirable de 3€");
                }else{
                    main.utils.Saldo.sacarSaldo();
                    SesionUsuario.getInstance().actualizarSaldo(0.0);
                    JOptionPane.showMessageDialog(null, "Se ha retirado su saldo correctamente");
                    MenuPrincipal.main();
                    dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "No tienes saldo disponible para retirar");
            }
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

    private class crearencuesta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CrearEncuesta.main();
            dispose();
        }
    }
}