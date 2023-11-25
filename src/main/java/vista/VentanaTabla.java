package vista;

import controlador.Controlador;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.time.LocalDate;

public class VentanaTabla extends JDialog {
    private JPanel contentPane;
    private JButton bVerInforme;
    private JButton bCerrar;
    private JTable tbDatos;
    private final Controlador controlador;

    public VentanaTabla(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Datos Consultados");
        setContentPane(contentPane);
        pack();
        setSize(900,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(bVerInforme);
        bCerrar.addActionListener(e -> this.dispose());
        bVerInforme.addActionListener(e -> reporte());
    }

    private void createUIComponents() {
        String [] columnas = new String[] {
            "Numero Expediente", "Fecha de Entrada", "Duración Estimada", "Código del Cliente",
                "Código de la Vivienda", "¿Ya Cobrado?"
        };
        Object [][] datos = new Object[this.controlador.getAlquileres().size()][6];
        for (int i = 0; i < this.controlador.getAlquileres().size(); i++) {
            datos [i][0] = this.controlador.getAlquileres().get(i).getNumeroExpediente();
            datos [i][1] = this.controlador.getAlquileres().get(i).getFechaEntrada();
            datos [i][2] = this.controlador.getAlquileres().get(i).getDuracionEstimada();
            datos [i][3] = this.controlador.getAlquileres().get(i).getCliente().getId();
            datos [i][4] = this.controlador.getAlquileres().get(i).getVivienda().getId();
            datos [i][5] = this.controlador.getAlquileres().get(i).getEstaCobrado();
        }
        DefaultTableModel modelo = new DefaultTableModel(datos,columnas) {
            private final Class[] claseColumnas = new Class[] {
                    Long.class, LocalDate.class, Integer.class, Long.class, Long.class, String.class
            };
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return claseColumnas[columnIndex];
            }
        };
        tbDatos = new JTable(modelo);
        DefaultTableCellRenderer centrarDatos = new DefaultTableCellRenderer();
        centrarDatos.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < 6; i++) {
            tbDatos.getColumnModel().getColumn(i).setCellRenderer(centrarDatos);
        }
    }

    private void reporte() {
        try {
            JasperReport informe = (JasperReport) JRLoader.
                    loadObject(new File("src/main/resources/reportes/Blank_A4.jasper"));
            JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(this.controlador.getAlquileres());
            JasperPrint jp = JasperFillManager.fillReport(informe, null, datos);
            JasperViewer ventanaInforme = new JasperViewer(jp, false);
            ventanaInforme.setSize(1200,700);
            ventanaInforme.setLocationRelativeTo(null);
            ventanaInforme.setVisible(true);
            ventanaInforme.setAlwaysOnTop(true);
            this.dispose();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null,"Problemas con el informe",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
