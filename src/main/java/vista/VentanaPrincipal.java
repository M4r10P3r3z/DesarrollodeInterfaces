package vista;

import controlador.Controlador;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    protected final Controlador controlador;
    private JPanel panelMainPanel;
    private JButton bConsulta;
    private JButton bSalir;

    public VentanaPrincipal(Controlador controlador) throws HeadlessException {
        this.controlador = controlador;
        setContentPane(panelMainPanel);
        setTitle("Proyecto de Servicios y procesos");
        pack();
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        bSalir.addActionListener(e -> this.controlador.salir());
        bConsulta.addActionListener(e -> this.controlador.consultaDatos());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ( (VentanaPrincipal) e.getSource()).controlador.salir();
            }
        });
    }
}
