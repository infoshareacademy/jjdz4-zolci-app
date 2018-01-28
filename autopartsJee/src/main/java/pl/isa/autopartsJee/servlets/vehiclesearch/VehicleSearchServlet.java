package pl.isa.autopartsJee.servlets.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autoparts.vehiclesearch.Vehicle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("vehiclesearch/vehicle-search")
public class VehicleSearchServlet extends HttpServlet{

    private Logger logger = LoggerFactory.getLogger(VehicleSearchServlet.class.getName());

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        request = req;
        response = res;

        request.setAttribute("brand", request.getParameter("brand"));
        request.setAttribute("model", request.getParameter("model"));
        request.setAttribute("year", request.getParameter("year"));
        request.setAttribute("version", request.getParameter("version"));
        request.setAttribute("variant", request.getParameter("variant"));
        request.setAttribute("fuel", request.getParameter("fuel"));
        request.setAttribute("volume", request.getParameter("volume"));
        request.setAttribute("formattedVolume", request.getParameter("formattedVolume"));
        request.setAttribute("power", request.getParameter("power"));
        request.setAttribute("vin", request.getParameter("vin"));
        request.setAttribute("registry", request.getParameter("registry"));


        Vehicle vehicle = null;

        try {
            vehicle = JsonParser.parseJsonFromFile("VehicleSearchResult.json", Vehicle.class);
        } catch (IOException e) {
            forwardToPageWithError("Błąd pobrania dummy json");
            logger.error("Json file load error");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("found-vehicle.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void forwardToPageWithError(String errorMessage) {
        logger.error("Could not search vehicle");
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-search.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            logger.error("Servlet request dispatcher error." + e.toString());
        } catch (IOException e) {
            logger.error("IO Servlet request dispatcher error." + e.toString());
        }
    }
}
