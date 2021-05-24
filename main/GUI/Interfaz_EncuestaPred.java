package main.GUI;

import main.controladores.ControladorEncuesta;
import main.models.Encuesta;
import main.models.Pregunta;
import main.models.Respuesta;
import main.models.Usuario;
import main.utils.GuardarResp;
import main.utils.Saldo;
import main.utils.SesionUsuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz_EncuestaPred extends JFrame {
    private static ArrayList<JCheckBox> CheckBoxRespuestas = new ArrayList<JCheckBox>();
    private ArrayList<JLabel> LabelsPreguntas = new ArrayList<JLabel>();
    private ArrayList<JPanel> PanelesPreguntas = new ArrayList<JPanel>();
    private JPanel panelPrincipal2;
    private static Encuesta encuesta;

    JButton enviar;
    JButton cancelar;
    Color asulitoresulon = new Color(88, 148, 255);

    SesionUsuario sesion = SesionUsuario.getInstance();
    Usuario usr = sesion.getUsr();

    private void crearPaneles(Encuesta e) {
        ArrayList<Pregunta> preguntasEncuesta = e.getPreguntas();
        for (int i = 0; i < preguntasEncuesta.size(); i++) {
            Pregunta preg = preguntasEncuesta.get(i);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 1));
            JLabel tituloPregunta = new JLabel(preg.getTexto());
            panel.add(tituloPregunta);
            //Bucle para acceder a las respuestas de una pregunta siempre van de 3 en 3
            for (int j = i * 3; j < i * 3 + 3; j++) {
                panel.add(CheckBoxRespuestas.get(j));
            }
            JLabel vacio2 = new JLabel("");
            vacio2.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
            panel.add(vacio2);
            panelPrincipal2.add(panel);
        }
    }

    private static void añadirRespuestas(Encuesta e) {
        ArrayList<Pregunta> preguntas = e.getPreguntas();
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pre = preguntas.get(i);
            ArrayList<Respuesta> resp = pre.getRespuestas();
            for (int j = 0; j < resp.size(); j++) {
                Respuesta res = resp.get(j);
                CheckBoxRespuestas.add(new JCheckBox(res.getTexto()));
            }
        }
    }

    private void añadirPreguntas(Encuesta e) {
        ArrayList<Pregunta> pregs = e.getPreguntas();
        for (int i = 0; i < pregs.size(); i++) {
            Pregunta pre = pregs.get(i);
            LabelsPreguntas.add(new JLabel(pre.getTexto()));
        }
    }


    Interfaz_EncuestaPred(Encuesta e) {
        // Este metodo es la interfaz

        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("                                  CREA TU ENCUESTA");
        l1.setFont(new Font("Calibri", Font.PLAIN, 40));
        panelTitulo.add(l1);
        JLabel vacio1 = new JLabel("");
        vacio1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelTitulo.add(vacio1);


        panelPrincipal2 = new JPanel();
        panelPrincipal2.setLayout(new GridLayout(e.getPreguntas().size() + 1, 1));
        panelPrincipal2.setPreferredSize(new Dimension(panelPrincipal2.getHeight(), 1500));

        //Metodo para crear los paneles de las preguntas
        crearPaneles(e);

        JPanel panelbotones = new JPanel();
        panelbotones.setLayout(new GridLayout(1, 4));
        enviar = new JButton("ENVIAR");
        enviar.setFont(new Font("Calibri", Font.PLAIN, 20));
        panelbotones.add(enviar);
        enviar.addActionListener(new enviar());
        enviar.setBackground(asulitoresulon);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(80, 80, 1100, 650);
        scrollPane.getVerticalScrollBar().setUnitIncrement(13);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(panelPrincipal2);
        add(scrollPane);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelbotones, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1650, 1080);
        this.setResizable(false);
        setVisible(true);
    }

    public static void main(int idEncuesta) {
        Encuesta e = ControladorEncuesta.getEncuesta(idEncuesta);
        encuesta = e;
        añadirRespuestas(e);
        Interfaz_EncuestaPred i = new Interfaz_EncuestaPred(e);
    }

    private static void guardarRespuestas(){
        ArrayList<Pregunta> preguntasEncuesta = encuesta.getPreguntas();
        for (int i = 0; i < preguntasEncuesta.size(); i++) {
            Pregunta preg = preguntasEncuesta.get(i);
            ArrayList<Respuesta> respuestas = preg.getRespuestas();
            int idPregunta = preg.getID_Pregunta();
            int numeroRespuesta = 0;
            for (int j = i * 3; j < i * 3 + 3; j++) {
                if(CheckBoxRespuestas.get(j).isSelected()){
                    numeroRespuesta = j%3;
                }
            }
            Respuesta respuestaSeleccionada = respuestas.get(numeroRespuesta);
            GuardarResp.registro(idPregunta, respuestaSeleccionada.getID_Respuesta());
        }
    }

    private class enviar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            guardarRespuestas();
            Saldo.actualizarSaldo();
            double remuneracion = encuesta.getRemuneracion();
            double saldo = usr.getSaldo();
            saldo += remuneracion;
            JOptionPane.showMessageDialog(null, "¡Gracias por responder esta encuesta! Has conseguido " + remuneracion + "€");
            SesionUsuario.getInstance().actualizarSaldo(saldo);
            if (saldo == 3) {
                JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has superado los 3€ de saldo, por lo tanto, ya puedes retirarlo");
            }
            Interfaz1.main();
            //Gráfico.main();
            dispose();

        }
    }
}