package vista;

import controlador.Controlador;
import fechaPerso.JrangoFechas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;

public class VentanaPrincipal extends JFrame {
    protected final Controlador controlador;
    private JPanel panelMainPanel;
    private JButton bConsulta;
    private JButton bSalir;
    private JPanel panelSelectorFechas;
    private JTable tbResultado;
    private final JrangoFechas jrangoFechas;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;

    public VentanaPrincipal(Controlador controlador) throws HeadlessException {
        this.controlador = controlador;
        setContentPane(panelMainPanel);
        setTitle("SmartOcupation App");
        pack();
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        jrangoFechas = new JrangoFechas();
        panelSelectorFechas.add(jrangoFechas);
        bSalir.addActionListener(e -> this.controlador.salir());
        bConsulta.addActionListener(e -> accionarConsulta());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ( (VentanaPrincipal) e.getSource()).controlador.salir();
            }
        });
    }

    private void accionarConsulta() {
        if (jrangoFechas.getFechaInicial().getDate()==null || jrangoFechas.getFechaFinal().getDate()==null) {
            JOptionPane.showMessageDialog(null,"Los campos de las fechas deben rellenarse",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            fechaInicial = jrangoFechas.getFechaInicial().getDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            fechaFinal = jrangoFechas.getFechaFinal().getDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            if (fechaInicial.isBefore(fechaFinal)) {
                this.controlador.consultaDatos();
            } else {
                JOptionPane.showMessageDialog(null,"La fecha final debe ser posterior a la inicial",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public LocalDate getFechaInicial() {return fechaInicial;}
    public LocalDate getFechaFinal() {return fechaFinal;}
}
