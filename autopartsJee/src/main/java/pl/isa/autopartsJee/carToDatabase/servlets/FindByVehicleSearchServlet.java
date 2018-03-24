package pl.isa.autopartsJee.carToDatabase.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.adminPanel.raportModule.rest.LogRequest;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.vehiclesearch.PageController;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@WebServlet("vs-car-add")
public class FindByVehicleSearchServlet extends HttpServlet {

    private final Logger LOG = LoggerFactory.getLogger(FindByVehicleSearchServlet.class.getName());
    private final String NO_ENTRY = "---";

    @Inject
    LogRequest logRequest;
    @Inject
    CarRepositoryDao carRepository;

    private HttpSession session;
    private PageController pageController;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        session = req.getSession();
        pageController = new PageController(req, res);

        CarData carData = new CarData();
        carData.setVehicleMake(getSessionAttribute("makeName"));
        carData.setProdYear(setOptional(Integer.valueOf(req.getParameter("year"))));
        carData.setVehicleVersion(NO_ENTRY);
        carData.setVin(setOptional(req.getParameter("vin")));
        carData.setRegistryNumber(setOptional(req.getParameter("registry")));
        carData.setOwnerId(getSessionAttributeLong("userId"));

        if (Optional.ofNullable(session.getAttribute("modelName")).isPresent()) {
            carData.setVehicleModel(setOptional(getSessionAttribute("modelName")));
        }
        else {
            carData.setVehicleModel(setOptional(req.getParameter("modelName")));
        }

        if (Optional.ofNullable(session.getAttribute("engineName")).isPresent()) {

            carData.setVehicleVariant(setOptional(getSessionAttribute("engineName")));
            carData.setFuel(setOptional(getSessionAttribute("fuel")));
            carData.setCapacity(setOptional(getSessionAttribute("ccm")));
            carData.setPower(setOptional(getSessionAttribute("hp")));
        }
        else {
            carData.setVehicleVariant(setOptional(req.getParameter("engineName")));
            carData.setFuel(setOptional(req.getParameter("fuel")));
            carData.setCapacity(setOptional(req.getParameter("ccm")));
            carData.setPower(setOptional(req.getParameter("hp")));
        }


        try {
            LOG.info("Car added");
            logRequest.createLog("car-added", (Long) req.getSession().getAttribute("userId"), "car-database");
            carRepository.addCar(carData);
        } catch (Exception e) {
            String errorMessage = "Could not add data to database.";
            LOG.error(errorMessage);
            pageController.forwardWithError(errorMessage);
            return;
        }

        req.setAttribute("vsOkMessage", "Car added to database.");
        pageController.forward("add-car-to-database.jsp");
    }

    private String getSessionAttribute(String attrName) {

        return session.getAttribute(attrName).toString();
    }

    private Long getSessionAttributeLong(String attrName) {

        return Long.valueOf(session.getAttribute(attrName).toString());
    }

    private String setOptional(String attribute) {

        return Optional.ofNullable(attribute).orElse(NO_ENTRY);
    }

    private Integer setOptional(Integer attribute) {

        return Optional.ofNullable(attribute).orElse(0);
    }
}
