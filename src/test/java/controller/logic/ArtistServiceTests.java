package controller.logic;

import exception.InvalidNameException;
import exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.ConnectionFactoryByManager;
import service.ArtistService;
import controller.TestData;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistServiceTests {

    private final ArtistService artistService = new ArtistService(new ConnectionFactoryByManager());

    @Test
    public void getByExistIdTest() {
        try {
            var expected = TestData.ARTIST_VALID;
            var actual = artistService.getById(TestData.ARTIST_VALID.getIdArtist());
            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void getByNotExistIdTest() {
        try {
            long artistId = TestData.ARTIST_INVALID.getIdArtist();
            var actual = artistService.getById(artistId);
            assertNull(actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void createTest() {
        try {
            var expected = TestData.ARTIST_VALID;
            long id = artistService.add(expected);
            var actual = artistService.getById(id);
            repository.Utils.checkEquals(expected, actual);
        } catch (SQLException | InvalidNameException e) {
            fail(e);
        }
    }

    @Test
    public void saveInvalidNameTest() {
        Assertions.assertThrows(InvalidNameException.class,
                () -> artistService.add(TestData.ARTIST_INVALID));
    }

    @Test
    public void deleteNotExists() {
        Assertions.assertThrows(NotFoundException.class,
                () -> artistService.delete(TestData.ARTIST_INVALID.getIdArtist()));
    }
}
