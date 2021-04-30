package main.GUI;

import javax.swing.*;
import java.awt.*;

public class Interfaz_Principal extends JFrame {

    JLabel body;

    public Interfaz_Principal() {
        JPanel panelprincipal = new JPanel();

        panelprincipal.add(body = new JLabel());
        body.setText("<html><p style = 'background-image: '>Genera tus passwords seguros con un solo CLICK!</p><br><p> -Sin tener que pensar</p><br><p> -Elige de que tipo quieres que sea (Signos, mayusculas, etc.)</p><br><p> -Sencilo y rapido ¡A QUE ESPERAS!</p></html>");
        body.setFont(new Font("Serif", Font.PLAIN, 13));


        add(panelprincipal);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Interfaz_Principal i = new Interfaz_Principal();
    }
}


