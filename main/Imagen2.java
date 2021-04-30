package main;

import javax.swing.*;
import java.awt.*;

class Imagen2 extends JPanel {

    public Imagen2() {
        this.setSize(250, 500);
    }

    public void paint(Graphics grafico) {
        Dimension heigth = getSize();

        ImageIcon Img = new ImageIcon(getClass().getResource("tarjeta.png"));

        grafico.drawImage(Img.getImage(), 0, 0, heigth.width, heigth.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
}