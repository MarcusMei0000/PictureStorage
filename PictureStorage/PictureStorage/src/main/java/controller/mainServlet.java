package controller;

import entity.Artist;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ArtistService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet("/hello")
public class mainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Collection<Artist> artists = new ArtistService().getAll();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/random.jsp");

            //беда в ломбоке
            req.setAttribute("friends", artists.stream().map(Artist::toString).toArray());
            requestDispatcher.forward(req, resp);

        } catch (ServletException e) {
            throw new RuntimeException(e);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


