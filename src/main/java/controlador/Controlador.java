package controlador;

import modelo.Alquiler;
import repositorio.*;
import util.ConexionBBDD;
import vista.VentanaPrincipal;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    Connection conn;
    VentanaPrincipal v;
    List<Alquiler> alquileres;
    RepositorioAlquiler repositorioAlquiler;

    public Controlador() {
        alquileres = new ArrayList<>();
        conectarBBDD();
        conseguirDatos();
        v = new VentanaPrincipal(this);
    }

    private void conseguirDatos() {
        try {
            repositorioAlquiler = new RepositorioAlquilerImpl(this.conn);
            this.alquileres = repositorioAlquiler.obtenerDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problemas al conseguir los datos",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
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
    public void consultaDatos() {
        System.out.println("=======ALQUILERES=======");
        this.alquileres.forEach(System.out::println);
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
