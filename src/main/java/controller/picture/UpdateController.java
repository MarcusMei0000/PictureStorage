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

@WebServlet("/picture/update")
public class UpdateController extends HttpServlet {
    private final PictureService pictureService = new PictureService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/picture/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            pictureService.update(Picture.builder()
                    .idPicture(Long.parseLong(req.getParameter("id_picture")))
                    .name(req.getParameter("name"))
                    .build());
            req.getRequestDispatcher("/WEB-INF/picture/main.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}