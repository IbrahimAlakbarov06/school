package az.edu.turing.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/school";
        String username = "postgres";
        String password = "123";
        return DriverManager.getConnection(url, username, password);
    }
}
