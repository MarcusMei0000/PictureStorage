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

@WebServlet("/picture/add")
public class AddController extends HttpServlet {
    private static final long serialVersionID = 1L;

    private final PictureService pictureService = new PictureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/picture/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            pictureService.add(Picture.builder()
                    .idPicture(Long.parseLong(req.getParameter("id_picture")))
                    .name(req.getParameter("name"))
                    .build());
            req.getRequestDispatcher("/WEB-INF/picture/add.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
