package repository;

import exception.ConnectionException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static String connectionName;

    public ConnectionFactory(String jdbcConnectionName)
    {
        connectionName = jdbcConnectionName;
    }

    public Connection getConnection() throws ConnectionException{
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(connectionName);

            return dataSource.getConnection();
        } catch (SQLException | NamingException e) {
            LOGGER.log(Level.WARNING, "Error while getting connection", e);
            throw new ConnectionException(e);
        }
    }
}