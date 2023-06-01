package controller;

import entity.Artist;
import entity.Picture;

public class TestData {
    public static Artist ARTIST_INVALID = new Artist(-1, "");
    public static Artist ARTIST_VALID = new Artist(1, "Шишкин");


    public static Picture PICTURE_INVALID = new Picture(-1, "");
    public static Picture PICTURE_VALID = new Picture(1, "Утро в сосновом лесу");
}
