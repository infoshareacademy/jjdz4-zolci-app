package pl.isa.autopartsJee.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autoparts.vehiclesearch.Vehicle;
import pl.isa.autoparts.vehiclesearch.VehicleData;
import pl.isa.autoparts.vehiclesearch.VehicleSearch;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet("vehicle-search")
public class VehicleSearchServlet extends HttpServlet{

    private final Logger LOG = LoggerFactory.getLogger(VehicleSearchServlet.class.getName());

    private static final String API_LINK = "/api/v2";
    private static final String MAKE_API = "makeApi";
    private static final String MAKE_NAME = "makeName";
    private static final String MODEL_API = "modelApi";
    private static final String MODEL_NAME = "modelName";
    private static final String ENGINE_NAME = "engineName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        PageController pageController = new PageController(req, res);
        Map<String, String> makes;

        try {
            Vehicle vehicle = VehicleSearch.getVehicleFromApi(API_LINK);
            makes = vehicle.getNamesAndApi();
        } catch (IOException e) {
            String errorMessage = "Could not parse vehicle names from database.";
            LOG.error(errorMessage);
            pageController.forwardWithError(errorMessage);
            return;
        }

        req.setAttribute("makes", makes);
        pageController.forward("vehicle-search.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        HttpSession session = req.getSession();
        PageController pageController = new PageController(req, res);

        Optional<String> engine = Optional.ofNullable(req.getParameter("engine"));
        if (engine.isPresent()) {

            // TODO Finish this nicely


            OptionValue value;
            Vehicle vehicle;
            try {
                value = parseParameters(engine.get());
                vehicle = VehicleSearch.getVehicleFromApi(value.getApi());
            } catch (IOException e) {
                String errorMessage = "Could not load Vehicle from given API";
                LOG.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }

            for (VehicleData vd : vehicle.getData()) {
                if (vd.getLink().equals(value.getApi())) {
                    session.setAttribute(ENGINE_NAME, value.getName());
                    pageController.forward("vehicle-search-step3.jsp");
                    return;
                }
            }
        }

        Optional<String> model = Optional.ofNullable(req.getParameter("model"));
        if (model.isPresent()) {

            OptionValue value;
            Map<String,String> engines;
            try {
                value = parseParameters(model.get());
                Vehicle vehicle = VehicleSearch.getVehicleFromApi(value.getApi());
                engines = vehicle.getNamesAndApi();
            } catch (IOException e) {
                String errorMessage = "Could not load engine names from API";
                LOG.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }

            session.setAttribute(MODEL_NAME, value.getName());
            session.setAttribute(MODEL_API, value.getApi());
            req.setAttribute("engines", engines);
            pageController.forward("vehicle-search-step2.jsp");
            return;
        }

        Optional<String> make = Optional.ofNullable(req.getParameter("make"));
        if (make.isPresent()) {

            OptionValue value;
            Map<String,String> models;
            try {
                value = parseParameters(make.get());
                Vehicle vehicle = VehicleSearch.getVehicleFromApi(value.getApi());
                models = vehicle.getNamesAndApi();
            } catch (IOException e) {
                String errorMessage = "Could not load model names from API";
                LOG.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }

            session.setAttribute(MAKE_NAME, value.getName());
            session.setAttribute(MAKE_API, value.getApi());
            req.setAttribute("models", models);
            pageController.forward("vehicle-search-step1.jsp");
            return;
        }

        pageController.forwardWithError("No option has been selected");
    }

    private OptionValue parseParameters(String value) throws IOException {

        return JsonParser.parseFromString(value, OptionValue.class);
    }
}
