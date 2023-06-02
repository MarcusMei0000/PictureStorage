package controller.logic;

import controller.TestData;
import exception.InvalidNameException;
import exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.ConnectionFactoryByManager;
import service.PictureService;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class PictureServiceTests {
    private final PictureService pictureService = new PictureService(new ConnectionFactoryByManager());
    @Test
    public void getByExistIdTest() {
        try {
            var expected = TestData.PICTURE_VALID;
            var actual = pictureService.getById(TestData.PICTURE_VALID.getIdPicture());
            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void getByNotExistIdTest() {
        try {
            long id = TestData.PICTURE_INVALID.getIdPicture();
            var actual = pictureService.getById(id);
            assertNull(actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void createTest() {
        try {
            var expected = TestData.PICTURE_VALID;
            long id = pictureService.add(expected);
            var actual = pictureService.getById(id);
            repository.Utils.checkEqualsNames(expected, actual);
        } catch (SQLException | InvalidNameException e) {
            fail(e);
        }
    }

    @Test
    public void saveInvalidNameTest() {
       Assertions.assertThrows(InvalidNameException.class,
               () -> pictureService.add(TestData.PICTURE_INVALID));
    }

    @Test
    public void deleteNotExists() {
        Assertions.assertThrows(NotFoundException.class,
                () -> pictureService.delete(TestData.PICTURE_INVALID.getIdPicture()));
    }
}
