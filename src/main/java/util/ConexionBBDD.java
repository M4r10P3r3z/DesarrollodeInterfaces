package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
    private static Connection connection = null;

    private ConexionBBDD() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Interfaces",
                "postgres", "1234");
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            new ConexionBBDD();
        }
        return connection;
    }
}
