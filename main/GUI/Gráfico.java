package main.GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gráfico extends JFrame{
    JPanel panel;

    // Esta clase es para generar un grafico de tarta para las respuestas de las encuestas

    public Gráfico(){
        setTitle("Grafico");
        setSize(800,600);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();


    }

    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);


        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Grupo Sergio, Angel, Antonio", 35);
        data.setValue("Grupo Nico, Lucas, Javi", 50);
        data.setValue("Grupo Salva, Lucia, Carmen", 15);


        JFreeChart chart = ChartFactory.createPieChart("A quien le vas a poner mejor nota en el trabajo", data, true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

        JButton volver = new JButton("VOlVER");
        panel.add(volver);
        volver.addActionListener(new ListenerButton());
    }

    public static void main(String[] args) {
        new Gráfico().setVisible(true);
    }

    public static void main(){
        new Gráfico().setVisible(true);
    }

    private class ListenerButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz1.main();
            dispose();
        }
    }
}