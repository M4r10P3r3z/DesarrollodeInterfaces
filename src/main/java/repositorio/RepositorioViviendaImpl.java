package repositorio;

import modelo.Vivienda;

import java.sql.*;

public class RepositorioViviendaImpl implements Repositorio<Vivienda> {
    private final Connection conn;

    public RepositorioViviendaImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public Vivienda porId(Long id) throws SQLException {
        Vivienda vivienda = null;
        try (PreparedStatement stm = conn.prepareStatement("select * from viviendas where id=?")) {
            stm.setLong(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    String ubicacion = rs.getString(2);
                    Double superficie = rs.getDouble(3);
                    Integer numeroHabitaciones = rs.getInt(4);
                    Integer numeroBanos = rs.getInt(5);
                    Double precio = rs.getDouble(6);
                    vivienda = new Vivienda(id, ubicacion, superficie, numeroHabitaciones,
                            numeroBanos, precio);
                }
            }
        }
    return vivienda;
    }
}
