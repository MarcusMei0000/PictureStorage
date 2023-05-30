package java.repository.logic;

import entity.Artist;
import org.junit.jupiter.api.Test;
import repository.ArtistRepository;
import repository.ConnectionFactory;
import repository.ConnectionFactoryImplimentation;
import java.repository.TestData;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ArtistRepositoryTests {

    private final ArtistRepository artistRepository = new ArtistRepository(new ConnectionFactoryImplimentation());

    @Test
    public void getByIdTest() {
        try {
            Artist expected = TestData.ARTIST_VALID;
            Artist actual = artistRepository.get(expected.getIdArtist());
            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }
}
