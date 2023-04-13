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

@WebServlet("/picture/all")
public class AllController extends HttpServlet {
    private final PictureService pictureService = new PictureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Collection<Picture> artistCollection = pictureService.getAll();
            req.setAttribute("pictures", artistCollection);
            req.getRequestDispatcher("/WEB-INF/picture/all.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

