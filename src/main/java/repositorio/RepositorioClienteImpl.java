package repositorio;

import modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepositorioClienteImpl implements Repositorio<Cliente> {

    private final Connection conn;

    public RepositorioClienteImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<Cliente> obtenerDatos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "select * from clientes";
        try (Statement stm = conn.createStatement()) {
            try (ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    Long id = rs.getLong(1);
                    String nombre = rs.getString(2);
                    String direccion = rs.getString(3);
                    String datosFacturacion = rs.getString(4);
                    Cliente cliente = new Cliente(id, nombre, direccion, datosFacturacion);
                    clientes.add(cliente);
                }
            }
        }
    return clientes;
    }
}
