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

@WebServlet("/artist/add")
public class AddController extends HttpServlet {
    private static final long serialVersionID = 1L;

    private final ArtistService artistService = new ArtistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/artist/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            artistService.add(Artist.builder()
                    .idArtist(Long.parseLong(req.getParameter("idArtist")))
                    .lastName(req.getParameter("last_name"))
                    .build());
            req.getRequestDispatcher("/WEB-INF/artist/add.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
