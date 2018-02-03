package pl.isa.autopartsJee.servlets;

import org.hibernate.Session;
import pl.isa.autoparts.aztec.AtenaSessionReader;
import pl.isa.autoparts.aztec.AztecVehicle;
import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autopartsJee.repository.CarData;
import pl.isa.autopartsJee.repository.ICarRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find-by-aztec")
public class FindByAztec extends HttpServlet{

    @Inject
    ICarRepository carRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AtenaSessionReader sessionReader = new AtenaSessionReader(req.getParameter("search"));
//        try {
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

            req.setAttribute("vehicleMake", vehicleMake);
            req.setAttribute("vehicleModel", vehicleModel);
            req.setAttribute("vehicleVersion", vehicleVersion);
            req.setAttribute("vehicleVariant", vehicleVariant);
            req.setAttribute("fuel", fuel);
            req.setAttribute("capacity", capacity);
            req.setAttribute("power", power);
            req.setAttribute("prodYear", prodYear);
            req.setAttribute("vin", vin);
            req.setAttribute("registryNumber", registryNumber);
 //       } catch (Exception e) {
 //           throw new ServletException(e);
 //       }


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

        carRepository.addCar(carData);

        RequestDispatcher dispatcher = req.getRequestDispatcher("find-by-aztec-result.jsp");
        dispatcher.forward(req, resp);
    }


}
