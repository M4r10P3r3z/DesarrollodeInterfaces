package repositorio;

import modelo.Cliente;

import java.sql.*;

public class RepositorioClienteImpl implements Repositorio<Cliente> {
    private final Connection conn;

    public RepositorioClienteImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public Cliente porId(Long id) throws SQLException {
        Cliente cliente = null;
        try (PreparedStatement stm = conn.prepareStatement("select * from clientes where id=?")) {
            stm.setLong(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    String nombre = rs.getString(2);
                    String direccion = rs.getString(3);
                    String datosFacturacion = rs.getString(4);
                    cliente = new Cliente(id, nombre, direccion, datosFacturacion);
                }
            }
        }
    return cliente;
    }
}
