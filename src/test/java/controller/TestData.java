package controller;

import entity.Artist;
import entity.Picture;

public class TestData {
    public static Artist ARTIST_INVALID = new Artist(-1, "");
    public static Artist ARTIST_VALID = new Artist(1, "Шишкин");
    public static Artist ARTIST_WITH_APOSTROPHE = new Artist(2, "L'artist");

    public static Picture MORNING = new Picture(1,"Утро в сосновом лесу");
    public static Picture EVERGREEN = new Picture(2,"Одинокая сосна");
    public static Picture FOREST = new Picture(3,"Берёзовая роща");

    public static Picture WHEAT = new Picture(4,"Рожь");
}
