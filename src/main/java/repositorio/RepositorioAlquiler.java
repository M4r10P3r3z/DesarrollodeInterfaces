package repositorio;

import modelo.Alquiler;

import java.sql.SQLException;
import java.util.List;

public interface RepositorioAlquiler {
    List<Alquiler> obtenerDatos() throws SQLException;
}