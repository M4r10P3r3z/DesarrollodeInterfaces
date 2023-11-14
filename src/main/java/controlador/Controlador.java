package controlador;

import modelo.Alquiler;
import servicio.AlquilerServicio;
import servicio.AlquilerServicioImpl;
import util.ConexionBBDD;
import vista.VentanaPrincipal;
import vista.VentanaTabla;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    Connection conn;
    VentanaPrincipal v;
    List<Alquiler> alquileres;
    AlquilerServicio alquilerServicio;

    public Controlador() {
        alquileres = new ArrayList<>();
        conectarBBDD();
        v = new VentanaPrincipal(this);
        v.setVisible(true);
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void consultaDatos() {
        try {
            alquilerServicio = new AlquilerServicioImpl(this.conn);
            this.alquileres = alquilerServicio.obtenerAlquileres(this.v.getFechaInicial(), this.v.getFechaFinal());
            mostrarDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problemas al conseguir los datos",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mostrarDatos() {
         if (this.alquileres.isEmpty()) {
             JOptionPane.showMessageDialog(null,"No hay datos que cumplan los requisotos de busqueda",
                     "NO HAY DATOS", JOptionPane.INFORMATION_MESSAGE);
         } else {
             VentanaTabla ventanaTabla = new VentanaTabla(this);
             ventanaTabla.setVisible(true);
         }
    }
    public void salir() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha cerrado",
                    "Todo bien", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cerrar la conexión",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }

    private void conectarBBDD() {
        try {
            this.conn = ConexionBBDD.getConnection();
            JOptionPane.showMessageDialog(null, "Conexión con la base de datos correcta",
                    "Todo bien", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            new JOptionPane("Error con el Driver Manager", JOptionPane.ERROR_MESSAGE);
        }
    }
}
