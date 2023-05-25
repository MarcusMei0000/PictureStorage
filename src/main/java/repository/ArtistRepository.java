package repository;

import entity.Artist;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class ArtistRepository {
    private static final String SELECT_BY_ID_QUERY =
            "SELECT id_artist, last_name FROM artist WHERE id_artist = ?;";
    private static final String SELECT_ALL_QUERY =
            "SELECT id_artist, last_name FROM artist;";
    private static final String INSERT_ARTIST =
            "INSERT INTO artist (last_name, first_name) VALUES (?,?);";

    private static final String UPDATE_ARTIST =
            "UPDATE artist SET first_name = ? WHERE id_artist = ?;";
    private static final String DELETE_ARTIST =
            "DELETE FROM artist WHERE id_artist = ?;";

    private ConnectionFactory connectionFactory;



    public Artist get(Long id) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return toArtistEntity(resultSet);
            }
            statement.close();

            return null;
        }
    }

    public Collection<Artist> getAll() throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Set<Artist> artistSet = new HashSet<>();

            while (resultSet.next()) {
                artistSet.add(toArtistEntity(resultSet));
            }
            statement.close();

            return artistSet;
        }
    }

    public void add(Artist artist) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_ARTIST);
            statement.setString(1, artist.getLastName());
            statement.setString(2, artist.getFirstName());
            statement.executeUpdate();
            statement.close();
        }
    }

    public void update(Artist artist) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_ARTIST);
            statement.setLong(2, artist.getIdArtist());
            statement.setString(1, artist.getFirstName());
            statement.executeUpdate();
            statement.close();
        }
    }

    public void delete(long id) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_ARTIST);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        }
    }

    private Artist toArtistEntity(ResultSet resultSet) throws SQLException {
        return Artist.builder()
                .idArtist(resultSet.getLong("id_artist"))
                .lastName(resultSet.getString("last_name"))
                .build();
    }
}