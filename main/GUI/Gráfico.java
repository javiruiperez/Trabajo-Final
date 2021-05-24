package main.GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gráfico extends JFrame{
    JPanel panel;

    JButton cancelar;


    Color rojitoresulon = new Color(255, 0, 0);

    public Gráfico(){
        setTitle("Como Hacer Graficos con Java");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        init();
    }

    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(8, "Mujeres", "Respuesta 1");
        dataset.setValue(7, "Hombres", "Respuesta 1");
        dataset.setValue(25, "no binario", "Respuesta 1");

        dataset.setValue(9, "Mujeres", "Respuesta 2");
        dataset.setValue(4, "Hombres", "Respuesta 2");

        dataset.setValue(4, "Mujeres", "Respuesta 3");
        dataset.setValue(5, "Hombres", "Respuesta 3");

        dataset.setValue(8, "Mujeres", "Respuesta 4");
        dataset.setValue(9, "Hombres", "Respuesta 4");

        dataset.setValue(7, "Mujeres", "Respuesta 5");
        dataset.setValue(8, "Hombres", "Respuesta 5");
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
                ("Respuestas pregunta 1","Opción", "Veces respondida",
                        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.pink);
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

        cancelar = new JButton("CANCELAR");
        cancelar.setFont(new Font("Calibri", Font.PLAIN, 20));
        cancelar.addActionListener(new ListenerButton());
        cancelar.setBackground(rojitoresulon);
        cancelar.setForeground(Color.white);
        panel.add(cancelar);
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