package repository;

import exception.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactoryByManager implements ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

    public Connection getConnection() throws ConnectionException {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/PictureStorage", "postgres", "04022003ap");

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error while getting connection", e);
            throw new ConnectionException(e);
        }
    }
}
