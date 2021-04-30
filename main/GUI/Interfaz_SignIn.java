import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_SignIn extends JFrame {

    JButton cancelar;
    JButton registrarse;

    Color asulitoresulon = new Color(70, 117, 246);
    Color rojitoresulon = new Color(212, 41, 41, 255);

    Interfaz_SignIn() {
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(15, 1));
        JLabel l1 = new JLabel("Registro de usuarios");
        l1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 35));
        panelPrincipal.add(l1);
        JLabel vacio3 = new JLabel("");
        vacio3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio3);
        JLabel l2 = new JLabel("Nombre de usuario");
        l2.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l2);
        JTextField usuario = new JTextField();
        panelPrincipal.add(usuario);
        JLabel vacio4 = new JLabel("");
        vacio4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio4);
        JLabel l3 = new JLabel("Correo electronico");
        l3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l3);
        JTextField correo = new JTextField();
        panelPrincipal.add(correo);
        JLabel vacio5 = new JLabel("");
        vacio5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio5);
        JLabel l4 = new JLabel("Contraseña");
        l4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l4);
        JTextField contraseña = new JPasswordField();
        panelPrincipal.add(contraseña);
        JLabel vacio6 = new JLabel("");
        vacio6.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio6);
        JLabel l5 = new JLabel("Repita la contraseña");
        l5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        panelPrincipal.add(l5);
        JTextField contraseña_ok = new JPasswordField();
        panelPrincipal.add(contraseña_ok);
        JLabel vacio7 = new JLabel("");
        vacio7.setFont(new Font("Comic Sans Ms", Font.PLAIN, 1));
        panelPrincipal.add(vacio7);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 75, 0));
        cancelar = new JButton("CANCELAR");
        cancelar.setFont(new Font("Comic Sans Ms", Font.PLAIN, 15));
        panel2.add(cancelar);
        cancelar.setBackground(rojitoresulon);
        cancelar.addActionListener(new Interfaz_SignIn.ListenerButton());
        registrarse = new JButton("REGISTRARSE");
        registrarse.setFont(new Font("Comic Sans Ms", Font.PLAIN, 15));
        panel2.add(registrarse);
        registrarse.setBackground(asulitoresulon);
        registrarse.addActionListener(new Interfaz_SignIn.ListenerButton2());



        panelPrincipal.add(panel2);
        add(panelPrincipal);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main() {
        Interfaz_SignIn i = new Interfaz_SignIn();
    }

    private class ListenerButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz_Entrada.main();
            dispose();
        }
    }

    private class ListenerButton2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Interfaz1.main();
        }
    }

}
