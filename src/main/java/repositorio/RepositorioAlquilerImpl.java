package repositorio;

import modelo.Alquiler;
import modelo.Cliente;
import modelo.Vivienda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class RepositorioAlquilerImpl implements RepositorioAlquiler {

    private final Connection conn;
    private final List<Cliente> clientes;
    private final List<Vivienda> viviendas;

    public RepositorioAlquilerImpl(Connection conn) throws SQLException {
        this.clientes = new RepositorioClienteImpl(conn).obtenerDatos();
        this.viviendas = new RepositorioViviendaImpl(conn).obtenerDatos();
        this.conn = conn;
    }
    @Override
    public List<Alquiler> obtenerDatos() throws SQLException {
        List<Alquiler> alquileres = new ArrayList<>();
        String sql = "select * from alquileres";
        try (Statement stm = conn.createStatement()) {
            try (ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    Long numeroExpediente = rs.getLong(1);
                    LocalDate fechaEntrada = rs.getDate(2).toLocalDate();
                    Integer duracionEstimada = rs.getInt(3);
                    Long idCliente = rs.getLong(4);
                    Long idVivienda = rs.getLong(5);
                    Cliente cliente = clientes.stream().
                            filter(c -> Objects.equals(c.getId(), idCliente)).findAny().get();
                    Vivienda vivienda = viviendas.stream()
                            .filter(v -> Objects.equals(v.getId(), idVivienda)).findAny().get();
                    Boolean yaCobrado = rs.getBoolean(6);
                    Alquiler alquiler = new Alquiler(numeroExpediente, fechaEntrada, duracionEstimada,
                            cliente, vivienda, yaCobrado);
                    alquileres.add(alquiler);
                }
            }
        }
    return alquileres;
    }
}
