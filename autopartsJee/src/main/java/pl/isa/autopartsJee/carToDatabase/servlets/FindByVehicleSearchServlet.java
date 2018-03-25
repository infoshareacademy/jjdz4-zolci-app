package pl.isa.autopartsJee.carToDatabase.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.adminPanel.raportModule.rest.LogRequest;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.vehiclesearch.PageController;
import pl.isa.autopartsJee.vehiclesearch.VehicleAttributes;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@WebServlet("vs-car-add")
public class FindByVehicleSearchServlet extends HttpServlet {

    private static final String USER_ID = "userId";
    private final Logger LOG = LoggerFactory.getLogger(FindByVehicleSearchServlet.class.getName());
    private final String NO_ENTRY = "---";

    @Inject
    LogRequest logRequest;
    @Inject
    CarRepositoryDao carRepository;

    private HttpSession session;
    private HttpServletRequest request;
    private PageController pageController;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        request = req;
        session = req.getSession();
        pageController = new PageController(req, res);

        CarData carData = new CarData();

        carData.setVehicleMake(getSessionAttribute(VehicleAttributes.MAKE_NAME));

        carData.setVehicleVersion(NO_ENTRY);

        carData.setProdYear(getParameterInteger(VehicleAttributes.YEAR));
        carData.setVin(getParameter(VehicleAttributes.VIN));
        carData.setRegistryNumber(getParameter(VehicleAttributes.REGISTRY));

        carData.setOwnerId(getSessionId());

        if (attributeIsPresent(VehicleAttributes.MODEL_NAME)) {
            carData.setVehicleModel(getSessionAttribute(VehicleAttributes.MODEL_NAME));
        }
        else {
            carData.setVehicleModel(getParameter(VehicleAttributes.MODEL_NAME));
        }

        if (attributeIsPresent(VehicleAttributes.ENGINE_NAME)) {

            carData.setVehicleVariant(getSessionAttribute(VehicleAttributes.ENGINE_NAME));
            carData.setFuel(getSessionAttribute(VehicleAttributes.FUEL));
            carData.setCapacity(getSessionAttribute(VehicleAttributes.CCM));
            carData.setPower(getSessionAttribute(VehicleAttributes.HP));
        }
        else {
            carData.setVehicleVariant(getParameter(VehicleAttributes.ENGINE_NAME));
            carData.setFuel(getParameter(VehicleAttributes.FUEL));
            carData.setCapacity(getParameter(VehicleAttributes.CCM));
            carData.setPower(getParameter(VehicleAttributes.HP));
        }


        try {
            LOG.info("Car added");
            logRequest.createLog("car-added", (Long) req.getSession().getAttribute(USER_ID), "car-database");
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

    private boolean attributeIsPresent(String attributeName) {
        return ofNullable(session.getAttribute(attributeName))
                .isPresent();
    }

    private String getParameter(String parameterName) {
        return ofNullable(request.getParameter(parameterName))
                .orElse(NO_ENTRY);
    }

    private Integer getParameterInteger(String parameterName) {

        final Integer defaultValue = 0;
        Integer value;

        Optional parameter = ofNullable(request.getParameter(parameterName));
        if (parameter.isPresent()) {
            try {
                value = Integer.valueOf(parameter.get().toString());
            } catch (NumberFormatException e) {
                value = defaultValue;
            }
        }
        else {
            value = defaultValue;
        }

        return value;
    }

    private String getSessionAttribute(String attrName) {

        return ofNullable(session.getAttribute(attrName).toString())
                .orElse(NO_ENTRY);
    }


    private Long getSessionId() {

        return Long.valueOf(session.getAttribute(USER_ID).toString());
    }

    private void removeAttributes() {

        session.removeAttribute(VehicleAttributes.MODEL_NAME);
        session.removeAttribute(VehicleAttributes.MAKE_NAME);
        session.removeAttribute(VehicleAttributes.ENGINE_NAME);
        session.removeAttribute(VehicleAttributes.FUEL);
        session.removeAttribute(VehicleAttributes.HP);
        session.removeAttribute(VehicleAttributes.CCM);
    }
}
