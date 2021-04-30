import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;

@SuppressWarnings("WrongPackageStatement")
public class Gráfico extends JFrame{
    JPanel panel;

    public Gráfico(){
        setTitle("Grafico");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);


        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Nico", 99);
        data.setValue("Javi", 0.5);
        data.setValue("Lucas", 0.5);

        JFreeChart chart = ChartFactory.createPieChart("Quien es mas tonto", data, true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }

    public static void main(String args[]){
        new Gráfico().setVisible(true);
    }
}