package repository.logic;

import entity.Picture;
import org.junit.jupiter.api.Test;
import repository.ConnectionFactoryByManager;
import repository.PictureRepository;
import repository.TestData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class PictureRepositoryTests {
    private final PictureRepository pictureRepository = new PictureRepository(new ConnectionFactoryByManager());

    @Test
    public void getByIdTest() {
        try {
            Picture expected = TestData.MORNING;
            Picture actual = pictureRepository.get(expected.getIdPicture());
            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void getAllTest() {
        try {
            var expected = new ArrayList<>(List.of(TestData.MORNING, TestData.EVERGREEN, TestData.FOREST));
            expected.sort(Comparator.comparingLong(Picture::getIdPicture));

            var actual = new ArrayList<>(pictureRepository.getAll());
            actual.sort(Comparator.comparingLong(Picture::getIdPicture));

            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    public void updateTest() {
        try {
            Picture expected = pictureRepository.get(TestData.MORNING.getIdPicture());
            expected.setName(TestData.WHEAT.getName());
            pictureRepository.update(expected);
            Picture actual = pictureRepository.get(expected.getIdPicture());

            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    //
    @Test
    public void deleteTest() {
        try {
            var picture = pictureRepository.get(TestData.MORNING.getIdPicture());
            pictureRepository.delete(picture.getIdPicture());
            var actual = pictureRepository.get(picture.getIdPicture());
            assertNull(actual);
        } catch (SQLException e) {
            fail(e);
        }
    }

    //GOTO: как проверить создание
    @Test
    public void createTest() {
        try {
            Picture expected = TestData.MORNING;
            pictureRepository.add(expected);
            Picture actual = pictureRepository.get(TestData.MORNING.getIdPicture());
            assertEquals(expected, actual);
        } catch (SQLException e) {
            fail(e);
        }
    }
}
