package controller.artist;

import entity.Artist;
import entity.Picture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ConnectionFactory;
import repository.PictureRepository;
import service.ArtistService;
import service.PictureService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/artist/select")
public class SelectController extends HttpServlet {
    private final ArtistService pictureService = new ArtistService();

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("idArtist"));
        try{
            Artist artist = pictureService.getById(id);
            req.setAttribute("idArtist", artist.getIdArtist());
            req.setAttribute("lastName", artist.getLastName());

          //  req.getRequestDispatcher("/WEB-INF/picture/select.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}