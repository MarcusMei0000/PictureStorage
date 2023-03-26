package service;

import entity.Artist;
import lombok.RequiredArgsConstructor;
import repository.ArtistRepository;
import java.sql.SQLException;
import java.util.Collection;

@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;
    public Artist getById(Long id) throws SQLException {
        return artistRepository.get(id);
    }

    public Collection<Artist> getAll() throws SQLException {
        return artistRepository.getAll();
    }

    public void add(Artist artist) throws SQLException {
        artistRepository.add(artist);
    }
}

