package main.GUI;

import main.controladores.ControladorGrafico;
import main.models.Usuario;
import main.utils.SesionUsuario;
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
    Font letraBotones = new Font("Calibri", Font.PLAIN, 25);
    Color rojitoresulon = new Color(255, 0, 0);
    Color colorGrafico = new Color(71, 153, 255);
    Color colorLineasGrafico = new Color(0, 0, 0);

    SesionUsuario sesion = SesionUsuario.getInstance();
    Usuario usr = sesion.getUsr();
    String nombre = usr.getNombre_usuario();

    public Gráfico(int ID_Encuesta){
        setTitle("Respuestas de " + nombre);
        setSize(1850,1500);
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
                ("Respuestas encuesta seleccionada","Opción", "Veces respondida",
                        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(colorGrafico);
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(colorLineasGrafico);

        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

        cancelar = new JButton("CANCELAR");
        cancelar.setFont(letraBotones);
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