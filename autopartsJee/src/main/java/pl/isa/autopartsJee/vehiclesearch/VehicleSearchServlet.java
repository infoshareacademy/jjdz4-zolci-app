package pl.isa.autopartsJee.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autoparts.vehiclesearch.Vehicle;
import pl.isa.autoparts.vehiclesearch.VehicleData;
import pl.isa.autoparts.vehiclesearch.VehicleSearch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@WebServlet("vehicle-search")
public class VehicleSearchServlet extends HttpServlet{

    private static final String API_LINK = "/api/v2";

    private final Logger logger = LoggerFactory.getLogger(VehicleSearchServlet.class.getName());

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        request = req;
        response = res;

        Map<String, String> makes = new TreeMap<>();

        try {
            makes = VehicleSearch.getVehicleMakesFromApi(API_LINK);
        } catch (IOException e) {
            String errorMessage = "Could not parse vehicle names from database.";
            logger.error(errorMessage);
            forwardToPageWithError(errorMessage);
        }

        req.setAttribute("makes", makes);
        forwardToPage("vehicle-search.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        request = req;
        response = res;

        Optional<String> make = Optional.ofNullable(request.getParameter("make"));
        if (make.isPresent()) {

        }
    }

    private void forwardToPage(String page) {

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            logger.error("Servlet request dispatcher error." + e.toString());
        } catch (IOException e) {
            logger.error("IO Servlet request dispatcher error." + e.toString());
        }
    }

    private void forwardToPageWithError(String errorMessage) {

        request.setAttribute("errorMessage", errorMessage);
        forwardToPageWithError("vehicle-search.jsp");
    }
}
