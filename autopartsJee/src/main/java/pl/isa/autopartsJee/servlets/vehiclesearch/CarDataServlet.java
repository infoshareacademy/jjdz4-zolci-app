package pl.isa.autopartsJee.servlets.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.aztec.AtenaSessionReader;
import pl.isa.autoparts.aztec.AztecData;
import pl.isa.autoparts.aztec.AztecVehicle;
import pl.isa.autoparts.tools.JsonParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("vehiclesearch/car-data")
public class CarDataServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CarDataServlet.class.getName());

    private static final String FORWARD_URL = "vehicle-search.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.request = request;
        this.response = response;

        String sessionKey = request.getParameter("atenaSessionKey");

        AztecVehicle vehicle = null;
        if (sessionKey != null) {
            try {
                vehicle = loadAztecFromSession(sessionKey);
                verifySessionErrors(vehicle);
            }
            catch (IOException e) {
                forwardToPageWithError("Nie udało się załadować sesji Aztec");
                return;
            }
            catch (NullPointerException e) {
                forwardToPageWithError(vehicle.getAztecData().getErrorText());
                return;
            }
        }

        else {
            try {
                vehicle = loadAztecFromFile();
                logger.info("Json file loaded to servlets");

            } catch (IOException e) {
                forwardToPageWithError("Nie udało się załadować pliku z danymi.");
                return;
            }
        }

        AztecData v = vehicle.getAztecData();
        setVehicleAttribute("brand", v.getVehicleMakeField_D1());
        setVehicleAttribute("model", v.getVehicleModelField_D5());
        setVehicleAttribute("year", v.getProductionYear());
        setVehicleAttribute("version", v.getVehicleVersionField_D4());
        setVehicleAttribute("variant", v.getVehicleVariantField_D3());
        String fuel = v.getFuelTypeField_P3();
        setVehicleAttribute("fuel", v.getFuelTypeField_P3());
        if (fuel.equals("P")) {
            setVehicleAttribute("checkFuel", fuel);
        }
        String volume = v.getCylinderCapacityField_P1();
        setVehicleAttribute("volume", volume);
        setVehicleAttribute("formattedVolume", reformatVolumeFromAztec(volume));
        setVehicleAttribute("power", v.getMaxNetEnginePowerField_P2());
        setVehicleAttribute("vin", v.getVehicleIdentificationNumberField_E());
        setVehicleAttribute("registry", v.getRegistryNumberField_A());

        RequestDispatcher dispatcher = request.getRequestDispatcher(FORWARD_URL);
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            logger.error("Servlet request dispatcher error." + e.toString());
        } catch (IOException e) {
            logger.error("IO Servlet request dispatcher error." + e.toString());
        }
    }

    private AztecVehicle loadAztecFromFile() throws IOException {

        return JsonParser.parseJsonFromFile("AztecCodeResult.json", AztecVehicle.class);
    }

    private AztecVehicle loadAztecFromSession(String sessionKey) throws IOException {

        AtenaSessionReader atenaSession = new AtenaSessionReader(sessionKey);

        return atenaSession.parseAztecFromSession();
    }

    private void verifySessionErrors(AztecVehicle vehicle) {

        if(vehicle.hasError()) {
           throw new NullPointerException();
        }
    }

    private void forwardToPageWithError(String errorMessage) {
        logger.error("Could not load Aztec JSON");
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher(FORWARD_URL);
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            logger.error("Servlet request dispatcher error." + e.toString());
        } catch (IOException e) {
            logger.error("IO Servlet request dispatcher error." + e.toString());
        }
    }

    private void setVehicleAttribute(String attributeName, String attributeValue) {
        request.setAttribute(attributeName, attributeValue);
    }

    private String reformatVolumeFromAztec(String volume) {

        Pattern pattern = Pattern.compile("^(\\d+).(\\d+)(cm3)");
        Matcher matcher = pattern.matcher(volume);

        if (matcher.find()) {
            Double vol = Double.parseDouble(matcher.group(1));
            String f = changeFormat(vol);
            return f;
        }

        return volume;
    }

    private String changeFormat(Double value) {

        if (value >= 1000) {

            return new BigDecimal(value/1000).setScale(1, BigDecimal.ROUND_HALF_UP).toString();
        }

        return value.toString();
    }

}
