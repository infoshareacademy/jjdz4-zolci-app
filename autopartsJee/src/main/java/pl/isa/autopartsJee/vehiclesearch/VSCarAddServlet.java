package pl.isa.autopartsJee.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
import pl.isa.autopartsJee.carToDatabase.domain.CarData;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("vs-car-add")
public class VSCarAddServlet extends HttpServlet {

    private final Logger LOG = LoggerFactory.getLogger(VSCarAddServlet.class.getName());

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
        carData.setVehicleModel(getSessionAttribute("modelName"));
        carData.setVehicleVersion("---");
        carData.setVehicleVariant(getSessionAttribute("engineName"));
        carData.setFuel(getSessionAttribute("fuel"));
        carData.setCapacity(getSessionAttribute("ccm"));
        carData.setPower(getSessionAttribute("hp"));
        Integer year = Integer.valueOf(req.getParameter("year"));
        carData.setProdYear(year);
        carData.setVin(req.getParameter("vin"));
        carData.setRegistryNumber(req.getParameter("registry"));
        carData.setOwnerId(getSessionAttributeLong("userId"));

        try {
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
}
