package main.GUI;

import javax.swing.*;
import java.awt.*;

public class Imagen_logo extends javax.swing.JPanel {

    // Este codigo hace que se pueda añadir una imagen a un boton

    public Imagen_logo() {
        this.setSize(250, 500);
    }

    public void paint(Graphics grafico) {
        Dimension heigth = getSize();

        ImageIcon Img = new ImageIcon(getClass().getResource("logo prog.png"));

        grafico.drawImage(Img.getImage(), 0, 0, heigth.width, heigth.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
}
