package repositorio;

import modelo.Vivienda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RepositorioViviendaImpl implements Repositorio<Vivienda> {

    private final Connection conn;

    public RepositorioViviendaImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<Vivienda> obtenerDatos() throws SQLException {
        List<Vivienda> viviendas = new ArrayList<>();
        String sql = "select * from viviendas";
        try (Statement stm = conn.createStatement()) {
            try (ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    Long id = rs.getLong(1);
                    String ubicacion = rs.getString(2);
                    Double superficie = rs.getDouble(3);
                    Integer numeroHabitaciones = rs.getInt(4);
                    Integer numeroBanos = rs.getInt(5);
                    Double precio = rs.getDouble(6);
                    Vivienda vivienda = new Vivienda(id, ubicacion, superficie, numeroHabitaciones,
                            numeroBanos, precio);
                    viviendas.add(vivienda);
                }
            }
        }
    return viviendas;
    }
}
