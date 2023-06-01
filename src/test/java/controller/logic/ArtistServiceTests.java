package controller.logic;

import exception.AlreadyExistsException;
import exception.InvalidNameException;
import exception.NotFoundException;
import org.junit.jupiter.api.Test;
import service.ArtistService;
import controller.TestData;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class ArtistServiceTests {

/*
    private final ArtistService artistService = new ArtistService();
    @Test
    public void getByExistIdTest() {
        try {
            long artistId = TestData.ARTIST_VALID.getIdArtist();
            artistService.getById(artistId);
            fail("GetByArtistId is correct but game with id = " + artistId + " not exists");
        } catch (SQLException e) {
            fail(e);
        } catch (NotFoundException e) {
        }
    }
    @Test
    public void getByNotExistIdTest() {
        try {
            long artistId = TestData.ARTIST_INVALID.getIdArtist();
            artistService.getById(artistId);
            fail("GetByArtistId is correct but game with id = " + artistId + " not exists");
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void saveTest() {
        try {
            var expected = TestsData.TOPIC_TO_SAVE;
            var actual = artistService.save(expected);
            repository.Utils.checkEquals(expected, actual);
        } catch (InvalidNameException | AlreadyExistsException | SQLException e) {
            fail(e);
        }
    }

    @Test
    public void saveInvalidNameTest() {
        try {
            var expected = TestsData.TOPIC_INVALID;
            artistService.save(expected);
            fail("Save is correct but topic have empty name");
        } catch (AlreadyExistsException | SQLException e) {
            fail(e);
        } catch (InvalidNameException e) {
        }
    }

    @Test
    public void saveAlreadyExistsTest() {
        try {
            var expected = TestsData.TOPIC_WITH_APOSTROPHE;
            artistService.save(expected);
            fail("Save is correct but topic with name = " + expected.getName() + " already exists");
        } catch (InvalidNameException | SQLException e) {
            fail(e);
        } catch (AlreadyExistsException e) {
        }
    }

    @Test
    public void deleteNotExists() {
        try {
            int id = TestsData.GAME_INVALID.getId();
            artistService.delete(id);
            fail("delete is correct, but this entity not exists");
        } catch (SQLException e) {
            fail(e);
        } catch (NotFoundException e) {
        }
    }*/
}
