package repository;

import entity.Artist;
import entity.Picture;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {
    public static void checkEquals(Artist expected, Artist actual) {
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getFirstName(), actual.getFirstName());
    }

    public static void checkEqualsSurname(Artist expected, Artist actual) {
        assertEquals(expected.getLastName(), actual.getLastName());
    }

    public static void checkEqualsListsArtist(List<Artist> expected, List<Artist> actual) {
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            checkEqualsSurname(expected.get(0), actual.get(0));
        }
    }

    public static void checkEqualsNames(Picture expected, Picture actual) {
        assertEquals(expected.getName(), actual.getName());
    }

    public static void checkEqualsListsPicture(List<Picture> expected, List<Picture> actual) {
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            checkEqualsNames(expected.get(0), actual.get(0));
        }
    }
}
