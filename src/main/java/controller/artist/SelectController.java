package controller.artist;

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
    private final PictureService pictureService = new PictureService(new PictureRepository(new ConnectionFactory()));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String selectedId = req.getParameter("id");
        Long id = Long.valueOf(selectedId);
        try{
            Picture picture = pictureService.getById(id);
            req.setAttribute("pictureId", picture.getIdPicture());
            req.setAttribute("pictureName", picture.getName());

            req.getRequestDispatcher("/WEB-INF/picture/select.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}