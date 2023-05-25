package controller.picture;

import entity.Picture;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PictureService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/picture/select")
public class SelectController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(SelectController.class.getName());
    private final PictureService pictureService = new PictureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("idPicture"));
        try {
            Picture picture = pictureService.getById(id);
            req.setAttribute("idPicture", picture.getIdPicture());
            req.setAttribute("name", picture.getName());

       //     req.getRequestDispatcher("/WEB-INF/picture/select.jsp").forward(req, resp);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        }
    }
}
