package main.GUI;

import javax.swing.*;
import java.awt.*;

class Imagen_Paypal extends javax.swing.JPanel {

    // Este codigo hace que se pueda añadir una imagen a un boton

    public Imagen_Paypal() {
        this.setSize(250, 500);
    }

    public void paint(Graphics grafico) {
        Dimension heigth = getSize();

        java.net.URL imgURL = getClass().getResource("img/paypal.png");

        ImageIcon Img = new ImageIcon(imgURL);

        grafico.drawImage(Img.getImage(), 0, 0, heigth.width, heigth.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
}