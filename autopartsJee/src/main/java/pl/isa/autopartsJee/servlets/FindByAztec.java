package pl.isa.autopartsJee.servlets;

import pl.isa.autoparts.aztec.AtenaSessionReader;
import pl.isa.autoparts.aztec.AztecVehicle;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find-by-aztec")
public class FindByAztec extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AtenaSessionReader sessionReader = new AtenaSessionReader(req.getParameter("search"));
        AztecVehicle vehicle = sessionReader.parseAztecFromSession();

        req.setAttribute("vehicleMake", vehicle.getAztecData().getVehicleMakeField_D1());
        req.setAttribute("vehicleModel", vehicle.getAztecData().getVehicleModelField_D5());
        req.setAttribute("vehicleVersion", vehicle.getAztecData().getVehicleVersionField_D4());
        req.setAttribute("vehicleVariant", vehicle.getAztecData().getVehicleVariantField_D3());
        req.setAttribute("fuel", vehicle.getAztecData().getFuelTypeField_P3());
        req.setAttribute("capacity", vehicle.getAztecData().getCylinderCapacityField_P1());
        req.setAttribute("power", vehicle.getAztecData().getMaxNetEnginePowerField_P2());
        req.setAttribute("prodYear", vehicle.getAztecData().getProductionYear());
        req.setAttribute("vin", vehicle.getAztecData().getVehicleIdentificationNumberField_E());
        req.setAttribute("registryNumber", vehicle.getAztecData().getRegistryNumberField_A());

        RequestDispatcher dispatcher = req.getRequestDispatcher("find-by-aztec-result.jsp");
        dispatcher.forward(req, resp);


    }
}
