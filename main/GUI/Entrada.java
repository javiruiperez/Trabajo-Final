package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Entrada extends JFrame {

    Color asulitoresulon = new Color(0, 79, 255);

    Font letraBotones = new Font("Calibri", Font.PLAIN, 25);
    Font letraTitulos = new Font("Calibri", Font.PLAIN, 40);
    Font letraTexto = new Font("Calibri", Font.PLAIN, 20);

    JButton logo;
    JButton entrar;

    Entrada() {
        // Este metodo es la interfaz

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(1, 1));
        logo = new JButton();
        logo.setFont(letraBotones);
        panelPrincipal.add(logo);
        logo.setBackground(Color.white);
        Imagen_Logo Imagen = new Imagen_Logo();
        logo.add(Imagen);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        entrar = new JButton("ENTRAR");
        entrar.setFont(letraBotones);
        panel2.add(entrar);
        entrar.setBackground(asulitoresulon);
        entrar.setForeground(Color.white);
        entrar.addActionListener(new Entrada.acceso());

        add(panelPrincipal, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(2100, 2100);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private class acceso implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LogIn.main();
            dispose();
        }
    }

    public static void main() {
        Entrada i = new Entrada();
    }

}
