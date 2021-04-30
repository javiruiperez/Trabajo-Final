package main.GUI;

import javax.swing.*;
import java.awt.*;

class Imagen extends javax.swing.JPanel {

    public Imagen() {
        this.setSize(250, 500);
    }

    public void paint(Graphics grafico) {
        Dimension heigth = getSize();

        ImageIcon Img = new ImageIcon(getClass().getResource("paypal.png"));

        grafico.drawImage(Img.getImage(), 0, 0, heigth.width, heigth.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
}