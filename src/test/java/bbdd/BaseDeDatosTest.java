package bbdd;

import modelo.Alquiler;
import modelo.Cliente;
import modelo.Vivienda;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repositorio.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseDeDatosTest {
    static Connection connection;

    @BeforeAll
    static void beforeAll() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Interfaces",
                    "postgres", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterAll
    static void afterAll() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void clientePorIdTest() {
        Repositorio<Cliente> repositorioCliente = new RepositorioClienteImpl(connection);
        assertDoesNotThrow(() -> {
            Cliente cliente = repositorioCliente.porId(1L);
            assertEquals("Mario", cliente.getNombre());
            assertEquals("Calle 1", cliente.getDireccion());
            assertEquals("Calle 1", cliente.getDatosFacturacion());
        });
    }
    @Test
    void viviendaPorIdTest() {
        Repositorio<Vivienda> repositorioVivienda = new RepositorioViviendaImpl(connection);
        assertDoesNotThrow(() -> {
            Vivienda cliente = repositorioVivienda.porId(1L);
            assertEquals(cliente.getUbicacion(), "Málaga");
            assertEquals(100, cliente.getSuperficie());
            assertEquals(2, cliente.getNumeroBanos());
            assertEquals(4, cliente.getNumeroHabitaciones());
            assertEquals(1000, cliente.getPrecioAlquilerMensual());
        });
    }
    @Test
    void alquilerTest() {
        RepositorioAlquiler repositorioAlquiler = new RepositorioAlquilerImpl(connection);
        assertDoesNotThrow(() -> {
            List<Alquiler> alquileres = repositorioAlquiler.listaAlquileres(
                    LocalDate.of(2000,1,1), LocalDate.now());
            assertFalse(alquileres.isEmpty());
            assertEquals(5, alquileres.size());
            assertEquals(3, alquileres.get(0).getNumeroExpediente());
            assertEquals(15, alquileres.get(0).getDuracionEstimada());
            assertEquals(2, alquileres.get(0).getCliente().getId());
            assertEquals(3, alquileres.get(0).getVivienda().getId());
            assertEquals("SÍ", alquileres.get(0).getEstaCobrado());
        });
    }
}