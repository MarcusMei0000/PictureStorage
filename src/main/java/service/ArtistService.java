package service;

import entity.Artist;
import lombok.RequiredArgsConstructor;
import repository.ArtistRepository;
import repository.ConnectionFactory;

import java.sql.SQLException;
import java.util.Collection;

@RequiredArgsConstructor
public class ArtistService {

    private static final String JAVA_COMP_ENV_JDBC_DB = "java:/comp/env/jdbc/PictureStorage";
    private final ArtistRepository artistRepository = new ArtistRepository(new ConnectionFactory(JAVA_COMP_ENV_JDBC_DB));
    public Artist getById(Long id) throws SQLException {
        return artistRepository.get(id);
    }

    public Collection<Artist> getAll() throws SQLException {
        return artistRepository.getAll();
    }

    public void add(Artist artist) throws SQLException {
        artistRepository.add(artist);
    }

    public void update(Artist artist) throws SQLException {
        artistRepository.update(artist);
    }
    public void delete(long id) throws SQLException {
        artistRepository.delete(id);
    }
}

