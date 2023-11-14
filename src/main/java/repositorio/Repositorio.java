package repositorio;

import java.sql.SQLException;

public interface Repositorio<T> {
    T porId(Long id) throws SQLException;
}
