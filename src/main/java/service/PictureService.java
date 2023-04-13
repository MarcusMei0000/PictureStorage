package service;

import entity.Picture;
import lombok.RequiredArgsConstructor;
import repository.ConnectionFactory;
import repository.PictureRepository;
import java.sql.SQLException;
import java.util.Collection;

@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository = new PictureRepository(new ConnectionFactory());;
    public Picture getById(Long id) throws SQLException {
        return pictureRepository.get(id);
    }

    public Collection<Picture> getAll() throws SQLException {
        return pictureRepository.getAll();
    }

    public void add(Picture picture) throws SQLException {
        pictureRepository.add(picture);
    }
}

