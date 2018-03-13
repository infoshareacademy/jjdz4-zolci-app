package pl.isa.autopartsJee.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageController {

    private final Logger logger = LoggerFactory.getLogger(PageController.class.getName());

    private static final String ERROR_PAGE = "vehicle-search.jsp";

    private HttpServletRequest request;
    private HttpServletResponse response;

    protected PageController(HttpServletRequest req, HttpServletResponse res) {

        request = req;
        response = res;
    }

    protected void forward(String page) {

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            logger.error("Servlet request dispatcher error." + e.toString());
        } catch (IOException e) {
            logger.error("IO Servlet request dispatcher error." + e.toString());
        }
    }

    protected void forwardWithError(String errorMessage) {

        request.setAttribute("errorMessage", errorMessage);
        forward(ERROR_PAGE);
    }
}
