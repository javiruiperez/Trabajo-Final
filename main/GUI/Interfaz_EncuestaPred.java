package main.GUI;

import javax.swing.*;
import java.awt.*;

public class Interfaz_EncuestaPred extends JFrame {

    JCheckBox r1 = new JCheckBox("RESPUESTA 1");
    JCheckBox r2 = new JCheckBox("RESPUESTA 2");
    JCheckBox r3 = new JCheckBox("RESPUESTA 3");

    JCheckBox r4 = new JCheckBox("RESPUESTA 1");
    JCheckBox r5 = new JCheckBox("RESPUESTA 2");
    JCheckBox r6 = new JCheckBox("RESPUESTA 3");

    JCheckBox r7 = new JCheckBox("RESPUESTA 1");
    JCheckBox r8 = new JCheckBox("RESPUESTA 2");
    JCheckBox r9 = new JCheckBox("RESPUESTA 3");

    JCheckBox r10 = new JCheckBox("RESPUESTA 1");
    JCheckBox r11 = new JCheckBox("RESPUESTA 2");
    JCheckBox r12 = new JCheckBox("RESPUESTA 3");

    JCheckBox r13 = new JCheckBox("RESPUESTA 1");
    JCheckBox r14 = new JCheckBox("RESPUESTA 2");
    JCheckBox r15 = new JCheckBox("RESPUESTA 3");

    Interfaz_EncuestaPred(){
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1));
        JLabel l1 = new JLabel("CREA TU ENCUESTA");
        l1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 40));
        panelPrincipal.add(l1);
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 1));
        JLabel p1 = new JLabel("¿Qué opinas de la superliga?");
        panel2.add(p1);
        panel2.add(r1);
        panel2.add(r2);
        panel2.add(r3);
        JLabel vacio2 = new JLabel("");
        vacio2.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel2.add(vacio2);
        panelPrincipal.add(panel2);


        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(5, 1));
        JLabel p2 = new JLabel("¿Crees que Pedro Sánchez es un buen presidente?");
        panel3.add(p2);
        panel3.add(r4);
        panel3.add(r5);
        panel3.add(r6);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel3.add(vacio3);
        panelPrincipal.add(panel3);


        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(5, 1));
        JLabel p3 = new JLabel("¿Qué tipo de películas te gustan más?");
        panel4.add(p3);
        panel4.add(r7);
        panel4.add(r8);
        panel4.add(r9);
        JLabel vacio4 = new JLabel("");
        vacio4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel4.add(vacio4);
        panelPrincipal.add(panel4);


        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(5, 1));
        JLabel p4 = new JLabel("¿A cuál de estos partidos votarías?");
        panel5.add(p4);
        panel5.add(r10);
        panel5.add(r11);
        panel5.add(r12);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel5.add(vacio5);
        panelPrincipal.add(panel5);


        JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayout(4, 1));
        JLabel p5 = new JLabel("¿Esperas el futuro con optimismo?");
        panel6.add(p5);
        panel6.add(r13);
        panel6.add(r14);
        panel6.add(r15);
        JLabel vacio6 = new JLabel("");
        vacio6.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panel6.add(vacio6);
        panelPrincipal.add(panel6);



        JScrollPane deslizador = new JScrollPane();
        deslizador.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_NEEDED );
        deslizador.setViewportView(panelPrincipal);
        getContentPane().add( deslizador );
        add(panelPrincipal);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Interfaz_EncuestaPred i = new Interfaz_EncuestaPred();
    }
}
