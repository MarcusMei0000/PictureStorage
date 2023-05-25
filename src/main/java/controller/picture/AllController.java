package controller.picture;

import entity.Picture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PictureService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/picture/all")
public class AllController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(AllController.class.getName());
    private final PictureService pictureService = new PictureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Collection<Picture> pictures = pictureService.getAll();
            req.setAttribute("pictures", pictures.stream().map(Picture::toStringAttributes).toArray());
            req.getRequestDispatcher("/WEB-INF/picture/all.jsp").forward(req, resp);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        }
    }
}

