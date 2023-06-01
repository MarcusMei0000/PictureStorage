package controller.artist;

import entity.Artist;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ArtistService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/artist/select")
public class SelectController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(SelectController.class.getName());
    private final ArtistService artistService = new ArtistService();

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("idArtist"));
        try{
            Artist artist = artistService.getById(id);
            req.setAttribute("idArtist", artist.getIdArtist());
            req.setAttribute("lastName", artist.getLastName());

          //  req.getRequestDispatcher("/WEB-INF/picture/select.jsp").forward(req, resp);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        }
    }
}