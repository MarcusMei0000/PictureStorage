package controller.picture;

import entity.Picture;
import exception.InvalidNameException;
import exception.NotFoundException;
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

@WebServlet("/picture/update")
public class UpdateController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(UpdateController.class.getName());
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
        }catch (InvalidNameException e) {
            LOGGER.log(Level.SEVERE, "Invalid picture name", e);
            resp.sendRedirect(req.getContextPath() + "/error?errorMessage=Invalid picture name");
            //throw new RuntimeException(e);
        } catch (NotFoundException e) {
            LOGGER.log(Level.SEVERE, "Picture is not founded", e);
            resp.sendRedirect(req.getContextPath() + "/error?errorMessage=Picture is not founded");
            //throw new RuntimeException(e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            throw new RuntimeException(e);
        }
    }
}