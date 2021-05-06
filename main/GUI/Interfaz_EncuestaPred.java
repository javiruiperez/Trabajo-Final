package main.GUI;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        panelPrincipal.setLayout(new GridLayout(7, 1));
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
        r1.addActionListener(new ListenerButton());
        r2.addActionListener(new ListenerButton1());
        r3.addActionListener(new ListenerButton2());
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
        r4.addActionListener(new ListenerButton4());
        r5.addActionListener(new ListenerButton4());
        r6.addActionListener(new ListenerButton5());
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
        r7.addActionListener(new ListenerButton6());
        r8.addActionListener(new ListenerButton7());
        r9.addActionListener(new ListenerButton8());
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
        r10.addActionListener(new ListenerButton9());
        r11.addActionListener(new ListenerButton10());
        r12.addActionListener(new ListenerButton11());
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
        r13.addActionListener(new ListenerButton12());
        r14.addActionListener(new ListenerButton13());
        r15.addActionListener(new ListenerButton14());
        panelPrincipal.add(panel6);


        //add(panelPrincipal);
        JScrollPane deslizador = new JScrollPane(panelPrincipal);
        //deslizador.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_NEEDED );
        //deslizador.setViewportView(panelPrincipal);
        add( deslizador );
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Interfaz_EncuestaPred i = new Interfaz_EncuestaPred();
    }

    private class ListenerButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r1.isSelected()) {
                r2.setSelected(false);
                r3.setSelected(false);
            }
        }
    }

    private class ListenerButton1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r2.isSelected()) {
                r1.setSelected(false);
                r3.setSelected(false);
            }
        }
    }

    private class ListenerButton2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r3.isSelected()) {
                r1.setSelected(false);
                r2.setSelected(false);
            }
        }
    }

    private class ListenerButton3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r4.isSelected()) {
                r5.setSelected(false);
                r6.setSelected(false);
            }
        }
    }

    private class ListenerButton4 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r5.isSelected()) {
                r4.setSelected(false);
                r6.setSelected(false);
            }
        }
    }

    private class ListenerButton5 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r6.isSelected()) {
                r4.setSelected(false);
                r5.setSelected(false);
            }
        }
    }

    private class ListenerButton6 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r7.isSelected()) {
                r8.setSelected(false);
                r9.setSelected(false);
            }
        }
    }

    private class ListenerButton7 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r8.isSelected()) {
                r7.setSelected(false);
                r9.setSelected(false);
            }
        }
    }

    private class ListenerButton8 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r9.isSelected()) {
                r7.setSelected(false);
                r8.setSelected(false);
            }
        }
    }

    private class ListenerButton9 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r10.isSelected()) {
                r11.setSelected(false);
                r12.setSelected(false);
            }
        }
    }

    private class ListenerButton10 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r11.isSelected()) {
                r10.setSelected(false);
                r12.setSelected(false);
            }
        }
    }

    private class ListenerButton11 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r12.isSelected()) {
                r10.setSelected(false);
                r11.setSelected(false);
            }
        }
    }

    private class ListenerButton12 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r13.isSelected()) {
                r14.setSelected(false);
                r15.setSelected(false);
            }
        }
    }

    private class ListenerButton13 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r14.isSelected()) {
                r13.setSelected(false);
                r15.setSelected(false);
            }
        }
    }

    private class ListenerButton14 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r15.isSelected()) {
                r13.setSelected(false);
                r14.setSelected(false);
            }
        }
    }


}
