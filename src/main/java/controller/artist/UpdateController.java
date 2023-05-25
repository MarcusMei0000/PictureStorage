package controller.artist;

import entity.Artist;
import exception.InvalidNameException;
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

@WebServlet("/artist/update")
public class UpdateController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(UpdateController.class.getName());
    private final ArtistService artistService = new ArtistService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/artist/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            artistService.update(Artist.builder()
                    .idArtist(Long.parseLong(req.getParameter("id_artist")))
                    .firstName(req.getParameter("first_name"))
                    .build());
            req.getRequestDispatcher("/WEB-INF/artist/main.jsp").forward(req, resp);
        } catch (NotFoundException e) {
            LOGGER.log(Level.SEVERE, "Artist is not founded", e);
            resp.sendRedirect(req.getContextPath() + "/error?errorMessage=Artist is not founded");
            //throw new RuntimeException(e);
        } catch (InvalidNameException e) {
            LOGGER.log(Level.SEVERE, "Invalid artist name", e);
            resp.sendRedirect(req.getContextPath() + "/error?errorMessage=Invalid artist name");
            //throw new RuntimeException(e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        }
    }
}
