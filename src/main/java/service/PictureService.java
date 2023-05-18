package service;

import entity.Picture;
import lombok.RequiredArgsConstructor;
import repository.ConnectionFactory;
import repository.PictureRepository;
import java.sql.SQLException;
import java.util.Collection;

@RequiredArgsConstructor
public class PictureService {
    private static final String JAVA_COMP_ENV_JDBC_DB = "java:/comp/env/jdbc/PictureStorage";
    private final PictureRepository pictureRepository = new PictureRepository(new ConnectionFactory(JAVA_COMP_ENV_JDBC_DB));
    public Picture getById(Long id) throws SQLException {
        return pictureRepository.get(id);
    }

    public Collection<Picture> getAll() throws SQLException {
        return pictureRepository.getAll();
    }

    public void add(Picture picture) throws SQLException {
        pictureRepository.add(picture);
    }

    public void update(Picture picture) throws SQLException {
        pictureRepository.update(picture);
    }

    public void delete(long id) throws SQLException {
        pictureRepository.delete(id);
    }
}

