package servicio;

import modelo.Alquiler;
import modelo.Cliente;
import modelo.Vivienda;
import repositorio.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AlquilerServicioImpl implements AlquilerServicio {

    Connection conn;
    Repositorio<Cliente> repoCliente;
    Repositorio<Vivienda> repoVivienda;
    RepositorioAlquiler repoAlquiler;

    public AlquilerServicioImpl(Connection conn) {
        this.conn = conn;
        repoCliente = new RepositorioClienteImpl(conn);
        repoVivienda = new RepositorioViviendaImpl(conn);
        repoAlquiler = new RepositorioAlquilerImpl(conn);
    }

    @Override
    public List<Alquiler> obtenerAlquileres() throws SQLException {
        List<Alquiler> alquileres = repoAlquiler.listaAlquileres();
        for (Alquiler a: alquileres) {
            a.setCliente(repoCliente.porId(a.getCliente().getId()));
            a.setVivienda(repoVivienda.porId(a.getVivienda().getId()));
        }
        return alquileres;
    }
}
