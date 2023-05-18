package repository;

import entity.Picture;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class PictureRepository {
    private static String SELECT_BY_ID_QUERY =
            "SELECT id_picture, name FROM picture WHERE id_picture = ?;";
    private static String SELECT_ALL_QUERY =
            "SELECT id_picture, name FROM picture;";
    private static String INSERT_PICTURE =
            "INSERT INTO picture (name) VALUES (?);";


    private static String UPDATE_PICTURE =
            "UPDATE picture SET name = ? WHERE id_picture = ?;";
    private static String DELETE_PICTURE =
            "DELETE FROM picture WHERE id_picture = ?;";
    private ConnectionFactory connectionFactory;

    public Picture get(Long id) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return toPictureEntity(resultSet);
            }
            statement.close();

            return null;
        }
    }

    public Collection<Picture> getAll() throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Set<Picture> pictureSet = new HashSet<>();
            while (resultSet.next()) {
                pictureSet.add(toPictureEntity(resultSet));
            }
            statement.close();

            return pictureSet;
        }
    }

    public void add(Picture picture) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_PICTURE);
            statement.setString(1, picture.getName());

            statement.executeUpdate();
            statement.close();
        }
    }

    public void delete(long id) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_PICTURE);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        }
    }
    public void update(Picture picture) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PICTURE);
            statement.setLong(2, picture.getIdPicture());
            statement.setString(1, picture.getName());
            statement.executeUpdate();
            statement.close();
        }
    }

    private Picture toPictureEntity(ResultSet resultSet) throws SQLException {
        return Picture.builder()
                .idPicture(resultSet.getLong("id_picture"))
                .name(resultSet.getString("name"))
                .build();
    }
}