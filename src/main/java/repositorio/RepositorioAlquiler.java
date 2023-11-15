package repositorio;

import modelo.Alquiler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface RepositorioAlquiler {
    List<Alquiler> listaAlquileres(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException;
}
