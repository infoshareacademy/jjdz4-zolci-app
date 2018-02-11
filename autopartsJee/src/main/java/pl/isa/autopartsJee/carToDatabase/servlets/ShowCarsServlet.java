package pl.isa.autopartsJee.carToDatabase.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cars")
public class ShowCarsServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(ShowCarsServlet.class.getName());
    @Inject
    CarRepositoryDao carRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("cars",
                carRepository.findCarsByOwnerId(Long.parseLong(req.getSession().getAttribute("userId").toString())));

        logger.info("Cars of users id: " + req.getSession().getAttribute("userID") + " found");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/your-cars.jsp");
        dispatcher.forward(req, resp);
    }

}
