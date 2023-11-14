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

public class RepositorioAlquilerImpl implements RepositorioAlquiler {

    private final Connection conn;
    private final Repositorio<Cliente> repoCliente;
    private final Repositorio<Vivienda> repoVivienda;

    public RepositorioAlquilerImpl(Connection conn) throws SQLException {
        this.repoCliente = new RepositorioClienteImpl(conn);
        this.repoVivienda = new RepositorioViviendaImpl(conn);
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
                    Cliente cliente = repoCliente.porId(rs.getLong(4));
                    Vivienda vivienda = repoVivienda.porId(rs.getLong(5));
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
