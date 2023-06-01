package service;

import entity.Artist;
import exception.InvalidNameException;
import exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import repository.ArtistRepository;
import repository.ConnectionFactory;
import repository.ConnectionFactoryByDataSource;

import java.sql.SQLException;
import java.util.Collection;

@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService() {
        artistRepository = new ArtistRepository(new ConnectionFactoryByDataSource());
    }
    public ArtistService(ConnectionFactory factory) {
        artistRepository = new ArtistRepository(factory);
    }

    public Artist getById(Long id) throws SQLException {
        return artistRepository.get(id);
    }

    public Collection<Artist> getAll() throws SQLException {
        return artistRepository.getAll();
    }

    public long add(Artist artist) throws SQLException, InvalidNameException {
        if (artist.getLastName().equals("")) {
            throw new InvalidNameException("Имя не может быть пустым");
        }
        return artistRepository.add(artist);
    }

    public void update(Artist artist) throws SQLException, InvalidNameException, NotFoundException {
        if (artistRepository.get(artist.getIdArtist()) == null) {
            throw new NotFoundException("Художника с id = " + artist.getIdArtist() + " не существует");
        }
        if (artist.getFirstName().equals("")) {
            throw new InvalidNameException("Имя не может быть пустым");
        }
        artistRepository.update(artist);
    }
    public void delete(long  id) throws SQLException, NotFoundException {
        if (artistRepository.get(id) == null) {
            throw new NotFoundException("Художника с id = " + id + " не существует");
        }
        artistRepository.delete(id);
    }
}

