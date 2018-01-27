package pl.isa.autopartsJee.servlets.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.aztec.AtenaSessionReader;
import pl.isa.autoparts.aztec.AztecVehicle;
import pl.isa.autoparts.tools.JsonParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car-data")
public class CarDataServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CarDataServlet.class.getName());

    private static final String FORWARD_URL = "/vehiclesearch/vehicle-search.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AztecVehicle vehicle = null;
        String session = request.getAttribute("session").toString();

        if (session != null) {
            try {
                vehicle = loadAztecFromSession(session);
                verifySessionErrors(vehicle);
            }
            catch (IOException e) {
                forwardToPageWithError("Nie udało się załadować sesji Aztec",request, response);
                return;
            }
            catch (NullPointerException e) {
                forwardToPageWithError(vehicle.getAztecData().getErrorText(), request, response);
                return;
            }
        }

        else {
            try {
                vehicle = JsonParser.parseJsonFromFile("AztecCodeResult.json", AztecVehicle.class);
                logger.info("Json file loaded to servlet");

            } catch (IOException e) {
                forwardToPageWithError("Nie udało się załadować pliku z danymi.", request, response);
                return;
            }
        }

        String brandName = vehicle.getAztecData().getVehicleMakeField_D1();
        request.setAttribute("brandName", brandName);

        String modelName = vehicle.getAztecData().getVehicleModelField_D5();
        request.setAttribute("modelName", modelName);

        String productionYear = vehicle.getAztecData().getProductionYear();
        request.setAttribute("productionYear", productionYear);

        String vehicleVolume = vehicle.getAztecData().getCylinderCapacityField_P1();
        request.setAttribute("vehicleVolume", vehicleVolume);

        String fuelType = vehicle.getAztecData().getFuelTypeField_P3();
        request.setAttribute("fuelType", fuelType);

        RequestDispatcher dispatcher = request.getRequestDispatcher(FORWARD_URL);
        dispatcher.forward(request, response);
    }

    private AztecVehicle loadAztecFromFile() throws IOException {

        return JsonParser.parseJsonFromFile("AztecCodeResult.json", AztecVehicle.class);
    }

    private AztecVehicle loadAztecFromSession(String sessionKey) throws IOException {

        AtenaSessionReader atenaSession = new AtenaSessionReader(sessionKey);

        return atenaSession.parseAztecFromSession();
    }

    private void verifySessionErrors(AztecVehicle vehicle) throws NullPointerException {

        if(!vehicle.getAztecData().getErrorText().isEmpty()) {
           throw new NullPointerException();
        }
    }

    private void forwardToPageWithError(String errorMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.error("Could not load Aztec JSON");
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher(FORWARD_URL);
        dispatcher.forward(request, response);
    }

}
