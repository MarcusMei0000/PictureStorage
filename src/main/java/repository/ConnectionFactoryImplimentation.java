package repository;

import exception.ConnectionException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactoryImplimentation implements ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String JAVA_COMP_ENV_JDBC_DB = "java:/comp/env/jdbc/PictureStorage";

    @Override
    public Connection getConnection() throws ConnectionException {
        try {
            Context context = new InitialContext();

           DataSource dataSource = (DataSource) context.lookup(JAVA_COMP_ENV_JDBC_DB);
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/PictureStorage", "postgres", "04022003ap");
           // return dataSource.getConnection();
        } catch (SQLException | NamingException e) {
            LOGGER.log(Level.WARNING, "Error while getting connection", e);
            throw new ConnectionException(e);
        }
    }
}
