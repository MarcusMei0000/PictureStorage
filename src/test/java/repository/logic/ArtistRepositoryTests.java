package repository.logic;

import entity.Artist;
import repository.Utils;
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
            expected.sort(Comparator.comparing(Artist::getLastName));

            var actual = new ArrayList<>(artistRepository.getAll());
            actual.sort(Comparator.comparing(Artist::getLastName));

            Utils.checkEqualsListsArtist(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void updateTest() {
        try {
            Artist expected = artistRepository.get(TestData.MONE.getIdArtist());
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
            var artist = artistRepository.get(TestData.MANE.getIdArtist());
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
            Artist expected = TestData.MANE;
            long id = artistRepository.add(expected);
            Artist actual = artistRepository.get(id);
            Utils.checkEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }
}