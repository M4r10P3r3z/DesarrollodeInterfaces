package servicio;

import modelo.Alquiler;

import java.sql.SQLException;
import java.util.List;

public interface AlquilerServicio {
    List<Alquiler> obtenerAlquileres() throws SQLException;
}
