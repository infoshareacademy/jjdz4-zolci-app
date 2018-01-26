package pl.isa.autopartsJee.servlets.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AztecVehicle vehicle = null;

        try {
            vehicle = JsonParser.parseJsonFromFile("AztecCodeResult.json", AztecVehicle.class);
            logger.info("Json file loaded to servlet");

        } catch (IOException e) {

            logger.error("Could not load Json file to servlet");
            request.setAttribute("errorMessage", "Nie udało się załadować pliku z danymi auta");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vehiclesearch/vehicle-search.jsp");
            dispatcher.forward(request, response);
            return;
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/vehiclesearch/vehicle-search.jsp");
        dispatcher.forward(request, response);
    }

}
