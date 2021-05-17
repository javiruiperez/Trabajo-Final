package main.GUI;

import main.models.Usuario;
import main.utils.Saldo;
import main.utils.SesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Aquí se muestra el saldo disponible ganado en las encuestas
//puedes sacar los fondos por tarjeta o por paypal
public class Interfaz_Saldo extends JFrame {

    SesionUsuario sesion = SesionUsuario.getInstance();
    Usuario usr = sesion.getUsr();

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

    Interfaz_Saldo(){
        // Este metodo es la interfaz

        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        JLabel l1 = new JLabel("                            SALDO                    ");
        l1.setFont(new Font("Calibri", Font.PLAIN, 40));
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

        saldo = new JButton(redondeo + "€");
        saldo.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel2.add(saldo);
        saldo.setBackground(Color.white);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio5);
        JLabel vacio6 = new JLabel("");
        vacio6.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio6);
        JLabel l2= new JLabel("Elige metodo de retirada");
        l2.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel2.add(l2);
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
        uno.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel3.add(uno);
        uno.setBackground(Color.white);
        Imagen Imagen = new Imagen();
        uno.add(Imagen);
        uno.addActionListener(new imagen1());
        dos = new JButton();
        dos.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel3.add(dos);
        dos.setBackground(Color.white);
        Imagen2 Imagen2 = new Imagen2();
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
        Interfaz_Saldo i = new Interfaz_Saldo();
    }

    private void crearMenu() {
        barra = new JMenuBar();

        menu_inicio = new JMenu("Inicio");
        menu_perfil = new JMenu("Perfil");

        menuItem_inicio = new JMenuItem("Ver Encuestas");
        menuItem_inicio.addActionListener(new Interfaz_Saldo.encuestas());
        menuItem_configuracion = new JMenuItem("Configuracion");
        menuItem_configuracion.addActionListener(new Interfaz_Saldo.configuracion());
        menuItem_info = new JMenuItem("Información");
        menuItem_info.addActionListener(new Interfaz_Saldo.informacion());

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
            Interfaz1.main();
            dispose();
        }
    }

    private class configuracion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        Interfaz_Perfil.main();
        }
    }

    private class imagen1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (usr.getSaldo() != 0) {
                if (usr.getSaldo() > 0 && usr.getSaldo() < 3) {
                    JOptionPane.showMessageDialog(null, "No has alcanzado el saldo mínimo retirable de 3€");
                }else{
                    Saldo.sacarSaldo();
                    SesionUsuario.getInstance().actualizarSaldo(0.0);
                    JOptionPane.showMessageDialog(null, "Se ha retirado su saldo correctamente");
                    Interfaz1.main();
                }
            }else{
                JOptionPane.showMessageDialog(null, "No tienes saldo disponible para retirar");
            }
        }
    }

    private class imagen2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (usr.getSaldo() != 0) {
                if (usr.getSaldo() > 0 && usr.getSaldo() < 3) {
                    JOptionPane.showMessageDialog(null, "No has alcanzado el saldo mínimo retirable de 3€");
                }else{
                    Saldo.sacarSaldo();
                    SesionUsuario.getInstance().actualizarSaldo(0.0);
                    JOptionPane.showMessageDialog(null, "Se ha retirado su saldo correctamente");
                    Interfaz1.main();
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
}