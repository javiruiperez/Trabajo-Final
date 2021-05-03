package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Entrada extends JFrame {

    JButton logo;
    JButton entrar;

    Interfaz_Entrada() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(1, 1));
        logo = new JButton();
        logo.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
        panelPrincipal.add(logo);
        logo.setBackground(Color.white);
        Imagen_logo Imagen = new Imagen_logo();
        logo.add(Imagen);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        entrar = new JButton("ENTRAR");
        entrar.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
        panel2.add(entrar);
        entrar.setBackground(Color.white);
        entrar.addActionListener(new Interfaz_Entrada.ListenerButton());


        add(panelPrincipal, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        setSize(400, 400);
        setVisible(true);
    }

    private class ListenerButton implements ActionListener {
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
