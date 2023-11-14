package repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
    List<T> obtenerDatos() throws SQLException;

}
