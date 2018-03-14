package pl.isa.autopartsJee.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class PageController {

    private final Logger logger = LoggerFactory.getLogger(PageController.class.getName());

    private static final String ERROR_PAGE = "add-car-to-database.jsp";

    private HttpServletRequest request;
    private HttpServletResponse response;

    PageController(HttpServletRequest req, HttpServletResponse res) {

        request = req;
        response = res;
    }

    void forward(String page) {

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            logger.error("Servlet request dispatcher error." + e.toString());
        } catch (IOException e) {
            logger.error("IO Servlet request dispatcher error." + e.toString());
        }
    }

    void forwardWithError(String errorMessage) {

        request.setAttribute("vsErrorMessage", errorMessage);
        forward(ERROR_PAGE);
    }
}
