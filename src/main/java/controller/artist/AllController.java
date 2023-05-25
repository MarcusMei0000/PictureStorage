package controller.artist;

import entity.Artist;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ArtistService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/artist/all")
public class AllController extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(AllController.class.getName());
    private final ArtistService artistService = new ArtistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Collection<Artist> artists = artistService.getAll();
            req.setAttribute("artists", artists.stream().map(Artist::toStringAttributes).toArray());
            req.getRequestDispatcher("/WEB-INF/artist/all.jsp").forward(req, resp);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        }
    }
}
