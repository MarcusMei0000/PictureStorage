package service;

import entity.Picture;
import exception.InvalidNameException;
import exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import repository.ConnectionFactory;
import repository.ConnectionFactoryByManager;
import repository.PictureRepository;
import java.sql.SQLException;
import java.util.Collection;

@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;

    public PictureService() {
        pictureRepository = new PictureRepository(new ConnectionFactoryByManager());
    }
    public  PictureService(ConnectionFactory factory) {
        pictureRepository = new PictureRepository(factory);
    }

    public Picture getById(Long id) throws SQLException {
        return pictureRepository.get(id);
    }

    public Collection<Picture> getAll() throws SQLException {
        return pictureRepository.getAll();
    }

    public long add(Picture picture) throws SQLException, InvalidNameException {
        if (picture.getName().equals("")) {
            throw new InvalidNameException("Имя не может быть пустым");
        }
        return pictureRepository.add(picture);
    }

    public void update(Picture picture) throws SQLException, NotFoundException, InvalidNameException {
        if (pictureRepository.get(picture.getIdPicture()) == null) {
            throw new NotFoundException("Картина с id = " + picture.getIdPicture() + " не существует");
        }
        if (picture.getName().equals("")) {
            throw new InvalidNameException("Имя не может быть пустым");
        }
        pictureRepository.update(picture);
    }

    public void delete(long id) throws SQLException, NotFoundException {
        if (pictureRepository.get(id) == null) {
            throw new NotFoundException("Картина с id = " + id + " не существует");
        }
        pictureRepository.delete(id);
    }
}

