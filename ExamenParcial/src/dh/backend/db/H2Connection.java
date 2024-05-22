package dh.backend.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String URL = "jdbc:h2:~/examen";
    private final static String USER = "sa";
    private final static String PASSWORD = "sa";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
