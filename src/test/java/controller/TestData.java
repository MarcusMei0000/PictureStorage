package controller;

import entity.Artist;
import entity.Picture;

public class TestData {
    public static Artist ARTIST_INVALID = new Artist(-1, "");
    public static Artist SHISHKIN = new Artist(1, "Шишкин");
    public static Artist MONE = new Artist(2, "Моне");
    public static Artist MANE = new Artist(3, "Мане");
    public static Artist DALI = new Artist(4, "Дали");

    public static Picture MORNING = new Picture(1,"Утро в сосновом лесу");
    public static Picture EVERGREEN = new Picture(2,"Одинокая сосна");
    public static Picture FOREST = new Picture(3,"Берёзовая роща");

    public static Picture WHEAT = new Picture(4,"Рожь");
}
