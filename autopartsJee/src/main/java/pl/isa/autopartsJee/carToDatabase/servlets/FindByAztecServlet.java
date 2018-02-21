package pl.isa.autopartsJee.carToDatabase.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.aztec.AtenaSessionReader;
import pl.isa.autoparts.aztec.AztecVehicle;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.raportModule.rest.LogRequest;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-by-aztec")
public class FindByAztecServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(FindByAztecServlet.class.getName());
    @Inject
    CarRepositoryDao carRepository;
    @Inject
    UsersRepositoryDao usersRepositoryDao;
    @Inject
    LogRequest logRequest;
    private Boolean checkIfCarExists(HttpServletRequest req, HttpServletResponse resp, String vin) throws ServletException, IOException {
        List<CarData> cars = carRepository.findCarsByOwnerId(Long.parseLong(req.getSession().getAttribute("userId").toString()));

        for (CarData carData : cars) {
            if (carData.getVin().equals(vin)) {
                req.setAttribute("wrongCode", "Podane auto znajduje się w twojej bazie danych");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/find-car-by-aztec.jsp");
                dispatcher.forward(req, resp);

                logger.warn("Car is in user's database");
                return true;

            }
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AtenaSessionReader sessionReader = new AtenaSessionReader(req.getParameter("search"));
        try {
            AztecVehicle vehicle = sessionReader.parseAztecFromSession();
//            AztecVehicle vehicle = JsonParser.parseJsonFromFile("AztecCodeResult.json", AztecVehicle.class);

            String vehicleMake = vehicle.getAztecData().getVehicleMakeField_D1();
            String vehicleModel = vehicle.getAztecData().getVehicleModelField_D5();
            String vehicleVersion = vehicle.getAztecData().getVehicleVersionField_D4();
            String vehicleVariant = vehicle.getAztecData().getVehicleVariantField_D3();
            String fuel = vehicle.getAztecData().getFuelTypeField_P3();
            String capacity = vehicle.getAztecData().getCylinderCapacityField_P1();
            String power = vehicle.getAztecData().getMaxNetEnginePowerField_P2();
            Integer prodYear = Integer.parseInt(vehicle.getAztecData().getProductionYear());
            String vin = vehicle.getAztecData().getVehicleIdentificationNumberField_E();
            String registryNumber = vehicle.getAztecData().getRegistryNumberField_A();

            if (checkIfCarExists(req, resp, vin)) {
                return;
            }
            CarData carData = new CarData();
            carData.setVehicleMake(vehicleMake);
            carData.setVehicleModel(vehicleModel);
            carData.setVehicleVersion(vehicleVersion);
            carData.setVehicleVariant(vehicleVariant);
            carData.setFuel(fuel);
            carData.setCapacity(capacity);
            carData.setPower(power);
            carData.setProdYear(prodYear);
            carData.setVin(vin);
            carData.setRegistryNumber(registryNumber);
            carData.setOwnerId(Long.parseLong(req.getSession().getAttribute("userId").toString()));
            carRepository.addCar(carData);
            logRequest.createLog("car-added",(Long) req.getSession().getAttribute("userId"), "car-database");
            logger.info("Car added to users database");
        } catch (Exception e) {
            logRequest.createLog("atena-session-not-found",(Long) req.getSession().getAttribute("userId"), "car-database");
            logger.warn("Session code not found");
            req.setAttribute("wrongCode", "Nie znaleziono kodu sesji");
//            req.setAttribute("carAdded", false);
        }
        req.getSession().setAttribute("carAdded", "Auto poprawnie dodane do bazy danych");
//        req.getSession().setAttribute("carAdded", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/find-car-by-aztec.jsp");
        dispatcher.forward(req, resp);
    }


}
