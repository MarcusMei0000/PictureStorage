package controller.logic;

import repository.ConnectionFactoryByManager;
import service.PictureService;

public class PictureServiceTests {
    private final PictureService pictureService = new PictureService(new ConnectionFactoryByManager());

}
