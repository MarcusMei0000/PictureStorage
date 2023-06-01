package controller.logic;

import exception.InvalidNameException;
import exception.NotFoundException;
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
        try {
            var expected = TestData.ARTIST_INVALID;
            artistService.add(expected);
        } catch (InvalidNameException e) {
            fail("Save is correct, but name is empty");
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void deleteNotExists() {
        try {
            long id = TestData.ARTIST_INVALID.getIdArtist();
            artistService.delete(id);
        } catch (NotFoundException e) {
            fail("delete is correct, but this entity not exists");
        } catch (SQLException e) {
            fail(e);
        }
    }
}
