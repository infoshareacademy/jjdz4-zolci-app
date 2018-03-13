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

@WebServlet("vehiclesearch/vehicle-search")
public class VehicleSearchServlet extends HttpServlet{

    private Logger logger = LoggerFactory.getLogger(VehicleSearchServlet.class.getName());

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {


        request = req;
        response = res;



        Vehicle vehicle = null;
        String brand = request.getParameter("brand");

        if (brand != null) {
            if (!brand.equals("KIA")) {
                try {
                    vehicle = VehicleSearch.searchVehicleFromURL();
                } catch (IOException e) {
                    forwardToPageWithError("Nie udało się połączyć z bazą danych");
                    logger.error("Could not connect to database.");
                    return;
                }
            }
        }

        try {
            vehicle = JsonParser.parseJsonFromFile("VehicleSearchResult.json", Vehicle.class);
        } catch (IOException e) {
            forwardToPageWithError("Nie udało się pobrać dummy json. " + e.toString());
            logger.error("Json file load error");
            return;
        }

        VehicleData[] d = vehicle.getData();
        request.setAttribute("fBrand", d[0].getBrand_id());
        request.setAttribute("fModel", d[0].getModel_id());
        request.setAttribute("fYear", d[0].getEnd_year());
        request.setAttribute("fVolume", d[0].getCcm());
        request.setAttribute("fHp", d[0].getHp());
        request.setAttribute("fCylinders", d[0].getCylinders());
        request.setAttribute("fEngtype", d[0].getEngine());
        request.setAttribute("fFuel", d[0].getFuel());
        request.setAttribute("fAxle", d[0].getAxle());
        request.setAttribute("fWeight", d[0].getMax_weight());

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
