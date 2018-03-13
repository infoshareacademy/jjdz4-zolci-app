package pl.isa.autopartsJee.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.vehiclesearch.Vehicle;
import pl.isa.autoparts.vehiclesearch.VehicleSearch;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        Map<String, String> makes;

        try {
            Vehicle vehicle = VehicleSearch.getVehicleFromApi(API_LINK);
            makes = vehicle.getNamesAndApi();
        } catch (IOException e) {
            String errorMessage = "Could not parse vehicle names from database.";
            logger.error(errorMessage);
            new PageController(req, res).forwardWithError(errorMessage);
            return;
        }

        req.setAttribute("makes", makes);
        new PageController(req, res).forward("vehicle-search.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        PageController pageController = new PageController(req, res);

        Optional<String> engine = Optional.ofNullable(req.getParameter("engine"));
        if (engine.isPresent()) {
            logger.info("ENGINE NOT IMPLEMENTED YET");
        }

        Optional<String> model = Optional.ofNullable(req.getParameter("model"));
        if (model.isPresent()) {

            Map<String,String> engines;
            try {
                Vehicle vehicle = VehicleSearch.getVehicleFromApi(model.get());
                engines = vehicle.getNamesAndApi();
            } catch (IOException e) {
                String errorMessage = "Could not load engine names from API";
                logger.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }

            req.setAttribute("engines", engines);
            pageController.forward("vehicle-search-step2.jsp");
            return;
        }

        Optional<String> make = Optional.ofNullable(req.getParameter("make"));
        if (make.isPresent()) {

            Map<String,String> models;
            try {
                Vehicle vehicle = VehicleSearch.getVehicleFromApi(make.get());
                models = vehicle.getNamesAndApi();
            } catch (IOException e) {
                String errorMessage = "Could not load model names from API";
                logger.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }

            req.setAttribute("models", models);
            pageController.forward("vehicle-search-step1.jsp");
            return;
        }

        pageController.forwardWithError("No option has been selected");
    }
}
