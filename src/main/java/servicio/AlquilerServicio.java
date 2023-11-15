package servicio;

import modelo.Alquiler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface AlquilerServicio {
    List<Alquiler> obtenerAlquileres(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException;
}
