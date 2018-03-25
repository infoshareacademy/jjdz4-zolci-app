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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("vehicle-search")
public class VehicleSearchServlet extends HttpServlet{

    private final Logger LOG = LoggerFactory.getLogger(VehicleSearchServlet.class.getName());

    private static final String API_LINK = "/api/v2";
    private static final String MODEL_API = "modelApi";

    private OptionValue value;
    private Vehicle vehicle;
    private HttpSession session;
    private PageController pageController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        session = req.getSession();

        pageController = new PageController(req, res);
        Map<String, String> makes;

        try {
            vehicle = VehicleSearch.getVehicleFromApi(API_LINK);
            makes = vehicle.getNamesAndApi();
        } catch (IOException e) {
            String errorMessage = "Could not parse vehicle names from database.";
            LOG.error(errorMessage);
            pageController.forwardWithError(errorMessage);
            return;
        }

        session.setAttribute("makes", makes);
        pageController.forward("vehicle-search.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        session = req.getSession();
        pageController = new PageController(req, res);

        Optional<String> engine = Optional.ofNullable(req.getParameter("engine"));
        if (engine.isPresent()) {

            Optional<String> modelApi = Optional.ofNullable(session.getAttribute(MODEL_API).toString());
            if (!modelApi.isPresent()) {
                String errorMessage = "Could not load Vehicle model API";
                LOG.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }
            
            try {
                value = parseParameters(engine.get());
                vehicle = VehicleSearch.getVehicleFromApi(modelApi.get());
            } catch (IOException e) {
                String errorMessage = "Could not load Vehicle from given API";
                LOG.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }

            for (VehicleData vd : vehicle.getData()) {
                if (vd.getLink().equals(value.getApi())) {

                    session.setAttribute(VehicleAttributes.ENGINE_NAME, value.getName());
                    session.setAttribute(VehicleAttributes.HP, vd.getKw() + ",00KW");
                    session.setAttribute(VehicleAttributes.CCM, vd.getCcm() + ",00cm3");
                    session.setAttribute(VehicleAttributes.FUEL, vd.getFuel());
                    session.setAttribute("years", explodeToYearsList(vd.getStart_year(), vd.getEnd_year()));
                    pageController.forward("vehicle-search-step3.jsp");
                    return;
                }
            }
        }

        Optional<String> model = Optional.ofNullable(req.getParameter("model"));
        if (model.isPresent()) {

            Map<String,String> engines;
            try {
                value = parseParameters(model.get());
                vehicle = VehicleSearch.getVehicleFromApi(value.getApi());
                engines = vehicle.getNamesAndApi();
            } catch (IOException e) {
                String errorMessage = "Could not load engine names from API";
                LOG.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }


            session.setAttribute(VehicleAttributes.MODEL_NAME, value.getName());
            session.setAttribute(MODEL_API, value.getApi());

            if (engines.isEmpty()) {
                session.removeAttribute(VehicleAttributes.ENGINE_NAME);
                removeAttributes();
                pageController.forward("vehicle-search-step3-1.jsp");
                return;
            }

            session.setAttribute("engines", engines);
            pageController.forward("vehicle-search-step2.jsp");
            return;
        }

        Optional<String> make = Optional.ofNullable(req.getParameter("make"));
        if (make.isPresent()) {

            Map<String,String> models;
            try {
                value = parseParameters(make.get());
                vehicle = VehicleSearch.getVehicleFromApi(value.getApi());
                models = vehicle.getNamesAndApi();
            } catch (IOException e) {
                String errorMessage = "Could not load model names from API";
                LOG.error(errorMessage);
                pageController.forwardWithError(errorMessage);
                return;
            }

            session.setAttribute(VehicleAttributes.MAKE_NAME, value.getName());
            session.setAttribute("makeApi", value.getApi());

            if (models.isEmpty()) {
                session.removeAttribute(VehicleAttributes.MODEL_NAME);
                session.removeAttribute(VehicleAttributes.ENGINE_NAME);
                removeAttributes();
                pageController.forward("vehicle-search-step3-2.jsp");
                return;
            }

            session.setAttribute("models", models);
            pageController.forward("vehicle-search-step1.jsp");
            return;
        }

        pageController.forwardWithError("No option has been selected");
    }

    private OptionValue parseParameters(String value) throws IOException {

        return JsonParser.parseFromString(value, OptionValue.class);
    }

    private List<String> explodeToYearsList(String startYear, String endYear) {

        Integer startY = Integer.valueOf(startYear);
        Integer endY;

        Optional<String> end = Optional.ofNullable(endYear);
        if (end.isPresent()) {
            endY = Integer.valueOf(end.get());
        }
        else {
            LocalDate now = LocalDate.now();
            endY = Integer.valueOf(now.getYear());
        }

        List<String> years = new ArrayList<>();
        for (int i = startY; i <= endY; i++) {
            years.add(String.valueOf(i));
        }

        return years;
    }

    private void removeAttributes() {

        session.removeAttribute(VehicleAttributes.HP);
        session.removeAttribute(VehicleAttributes.CCM);
        session.removeAttribute(VehicleAttributes.FUEL);
    }


}
