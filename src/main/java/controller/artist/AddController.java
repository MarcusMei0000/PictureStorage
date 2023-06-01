package controller.artist;

import entity.Artist;
import exception.InvalidNameException;
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

@WebServlet("/artist/add")
public class AddController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(AddController.class.getName());
    private final ArtistService artistService = new ArtistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/artist/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            artistService.add(Artist.builder()
                    .lastName(req.getParameter("last_name"))
                    .firstName(req.getParameter("first_name"))
                    .build());
            req.getRequestDispatcher("/WEB-INF/artist/main.jsp").forward(req, resp);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        } catch (InvalidNameException e) {
            resp.sendRedirect(req.getContextPath() + "/error?errorMessage=Invalid Artist Name");
            //throw new RuntimeException(e);
        }
    }
}
