package controller.picture;

import entity.Picture;
import exception.InvalidNameException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PictureService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/picture/add")
public class AddController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(AddController.class.getName());
    private final PictureService pictureService = new PictureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/picture/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            pictureService.add(Picture.builder()
                    .name(req.getParameter("name"))
                    .build());
            req.getRequestDispatcher("/WEB-INF/picture/main.jsp").forward(req, resp);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        } catch (InvalidNameException e) {
            resp.sendRedirect(req.getContextPath() + "/error?errorMessage=Invalid Picture Name");
            //throw new RuntimeException(e);
        }
    }
}
