package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Entrada extends JFrame {

    JButton logo;
    JButton entrar;

    Interfaz_Entrada() {
        // Este metodo es la interfaz

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(1, 1));
        logo = new JButton();
        logo.setFont(new Font("Calibri", Font.PLAIN, 25));
        panelPrincipal.add(logo);
        logo.setBackground(Color.white);
        Imagen_logo Imagen = new Imagen_logo();
        logo.add(Imagen);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        entrar = new JButton("ENTRAR");
        entrar.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel2.add(entrar);
        entrar.setBackground(Color.white);
        entrar.addActionListener(new Interfaz_Entrada.acceso());


        add(panelPrincipal, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(2100, 2100);
        setVisible(true);
    }

    private class acceso implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           Interfaz_logIn.main();
           dispose();
        }
    }

    public static void main() {
        Interfaz_Entrada i = new Interfaz_Entrada();
    }


}
