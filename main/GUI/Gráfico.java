package main.GUI;

import main.controladores.ControladorGrafico;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gráfico extends JFrame{
    JPanel panel;

    JButton cancelar;


    Color rojitoresulon = new Color(255, 0, 0);

    public Gráfico(int ID_Encuesta){
        setTitle("Como Hacer Graficos con Java");
        setSize(1200,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        this.setResizable(false);
        setSize(1650, 1080);
        init(ID_Encuesta);
    }

    private void init(int ID_Encuesta) {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset dataset = ControladorGrafico.getDataset(ID_Encuesta);
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
                ("Respuestas Encuesta 1","Opción", "Veces respondida",
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

    public static void main(int ID_Encuesta) {
        new Gráfico(ID_Encuesta).setVisible(true);
    }


    private class ListenerButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal.main();
            dispose();
        }
    }
}