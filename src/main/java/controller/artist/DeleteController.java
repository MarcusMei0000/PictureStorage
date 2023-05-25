package controller.artist;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ArtistService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/artist/delete")
public class DeleteController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(DeleteController.class.getName());
    private final ArtistService artistService = new ArtistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/artist/delete.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            artistService.delete(Long.parseLong(req.getParameter("id_artist")));
            req.getRequestDispatcher("/WEB-INF/artist/main.jsp").forward(req, resp);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            LOGGER.log(Level.SEVERE, "Artist is not founded", e);
            throw new RuntimeException(e);
        }
    }
}
