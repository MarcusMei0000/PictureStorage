package repository.logic;

import entity.Artist;
import org.junit.jupiter.api.Test;
import repository.ArtistRepository;
import repository.ConnectionFactoryByManager;
import repository.TestData;

import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistRepositoryTests {
    private final ArtistRepository artistRepository = new ArtistRepository(new ConnectionFactoryByManager());

    @Test
    public void getByIdTest() {
        try {
            Artist expected = TestData.SHISHKIN;
            Artist actual = artistRepository.get(expected.getIdArtist());
            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void getAllTest() {
        try {
            var expected = new ArrayList<>(List.of(TestData.SHISHKIN, TestData.MONE, TestData.MANE));
            expected.sort(Comparator.comparingLong(Artist::getIdArtist));

            var actual = new ArrayList<>(artistRepository.getAll());
            actual.sort(Comparator.comparingLong(Artist::getIdArtist));

            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void updateTest() {
        try {
            Artist expected = artistRepository.get(TestData.SHISHKIN.getIdArtist());
            expected.setFirstName("ABCDEFG");
            artistRepository.update(expected);
            Artist actual = artistRepository.get(expected.getIdArtist());

            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void deleteTest() {
        try {
            var artist = artistRepository.get(TestData.SHISHKIN.getIdArtist());
            artistRepository.delete(artist.getIdArtist());
            var actual = artistRepository.get(artist.getIdArtist());
            assertNull(actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    //GOTO: как проверить создание
    @Test
    public void createTest() {
        try {
            Artist expected = TestData.SHISHKIN;
            artistRepository.add(expected);
            Artist actual = artistRepository.get(TestData.SHISHKIN.getIdArtist());
            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }
}