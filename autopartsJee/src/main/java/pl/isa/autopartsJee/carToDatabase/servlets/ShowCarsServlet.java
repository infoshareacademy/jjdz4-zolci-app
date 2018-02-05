package pl.isa.autopartsJee.carToDatabase.servlets;

import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@WebServlet("/cars")
public class ShowCarsServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(ShowCarsServlet.class.getName());
    @Inject
    CarRepositoryDao carRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("cars", carRepository.findCarsByOwnerId((int) req.getSession().getAttribute("userId")));
        logger.info("Cars of users id: " + req.getSession().getAttribute("userID") + " found");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/your-cars.jsp");
        dispatcher.forward(req, resp);
    }

}
