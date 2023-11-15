package repositorio;

import modelo.Alquiler;
import modelo.Cliente;
import modelo.Vivienda;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAlquilerImpl implements RepositorioAlquiler {

    private final Connection conn;
    public RepositorioAlquilerImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Alquiler> listaAlquileres(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        List<Alquiler> alquileres = new ArrayList<>();
        try (PreparedStatement stm = conn
                .prepareStatement("select * from alquileres where fecha_entrada between ? and ? order by fecha_entrada")) {
            stm.setDate(1, Date.valueOf(fechaInicial));
            stm.setDate(2, Date.valueOf(fechaFinal));
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Long numeroExpediente = rs.getLong(1);
                    LocalDate fechaEntrada = rs.getDate(2).toLocalDate();
                    Integer duracionEstimada = rs.getInt(3);
                    Cliente cliente = new Cliente (rs.getLong(4));
                    Vivienda vivienda = new Vivienda (rs.getLong(5));
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
