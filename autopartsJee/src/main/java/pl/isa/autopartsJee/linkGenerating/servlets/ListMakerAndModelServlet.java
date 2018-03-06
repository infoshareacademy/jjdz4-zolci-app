package pl.isa.autopartsJee.linkGenerating.servlets;

import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
import pl.isa.autopartsJee.adminPanel.raportModule.rest.LogRequest;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("find-category")
public class ListMakerAndModelServlet extends HttpServlet {
    @Inject
    CarRepositoryDao carRepository;
    private Logger logger = Logger.getLogger(ListMakerAndModelServlet.class.getName());
    @Inject
    LogRequest logRequest;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getSession().setAttribute("cars",
                carRepository.findCarsByOwnerId(Long.parseLong(req.getSession().getAttribute("userId").toString())));
        logRequest.createLog("cars-displayed", (Long) req.getSession().getAttribute("userId"), "cars-display");
        logger.info("Cars of users id: " + req.getSession().getAttribute("userID") + " found");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category.jsp");
        requestDispatcher.forward(req, resp);
    }
}
