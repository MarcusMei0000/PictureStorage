package controller.picture;

import entity.Picture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ConnectionFactory;
import repository.PictureRepository;
import service.PictureService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/picture/select")
public class SelectController extends HttpServlet {
    private final PictureService pictureService = new PictureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("pictureId"));
        try {
            Picture picture = pictureService.getById(id);
            req.setAttribute("pictureId", picture.getIdPicture());
            req.setAttribute("pictureName", picture.getName());

       //     req.getRequestDispatcher("/WEB-INF/picture/select.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
