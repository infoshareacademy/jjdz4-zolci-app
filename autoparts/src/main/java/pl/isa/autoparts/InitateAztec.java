package pl.isa.autoparts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.aztec.*;
import pl.isa.autoparts.tools.InputScanner;
import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autoparts.tools.Printer;
import pl.isa.autoparts.vehiclesearch.*;

import java.io.IOException;
import java.util.List;

public class InitateAztec {

    private static Logger logger = LoggerFactory.getLogger(InitateAztec.class.getName());

    public static void executeAztecReader() {

        logger.info("Aztec Reader executed");

        Printer.println("Pokaż dane kodu aztec");
        Printer.println("1. Pobierz dane z pliku");
        Printer.println("2. Pobierz dane z sesji Atena");

        Printer.printInputRequest("Wybierz opcję");
        int option = InputScanner.scanForOption();

        switch (option) {

            case 1:
                readAztecFromFile();
                break;
            case 2:
                readAztecFromSession();
                break;
            default:
                Printer.printError("Wybrałeś złą opcję");
        }


    }

    public static void executeVehicleSearch() {

        logger.info("Vehicle Search executed");

        Printer.println("Identyfikacja auta po serii pytań");

        Printer.printInputRequest("Podaj markę szukanego auta");
        String brandName = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj model");
        String modelName = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj rocznik");
        String productionYear = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj pojemność");
        String cylinderVolume = InputScanner.scanForStringLine();

        VehicleSearch vehicleSearch = new VehicleSearch();

        List<VehicleData> models = null;

        try {

            models = vehicleSearch.findVehicleModels(brandName, modelName, productionYear);

        } catch (IOException e) {

            logger.error("Problem connecting with database");
            Printer.printError("Problem połączenia z bazą danych.");
            return;
        }

        if (models.size() > 1) {

            VehiclePrinter.printModels(models);
            modelName = InputScanner.scanForStringLine();

            for (VehicleData data : models) {
                if (data.getName().toUpperCase()
                        .contains(modelName.toUpperCase())) {
                    modelName = data.getName();
                    break;
                }
            }
        }
        else {
            if (!models.isEmpty())
                modelName = models.get(0).getName();

            else {
                logger.error("Searched item not found");
                Printer.printError("Nie udało się odnaleźć szukanego elementu");
                return;
            }
        }

        List<VehicleData> vehicles = vehicleSearch.foundVehicles(modelName, cylinderVolume);

        VehiclePrinter.printFoundVehicles(vehicleSearch, vehicles);
    }

    private InitateAztec() {}

    private static void readAztecFromFile() {

        AztecVehicle vehicle = null;

        try {
            vehicle = JsonParser.parseJsonFromFile("AztecCodeResult.json", AztecVehicle.class);
            logger.info("Json file loaded");
        } catch (IOException e) {
            logger.error("Could not load Json file");
            Printer.printError("Niepowodzenie parsowania json z pliku");
        }

        AztecPrinter.printAztecVehicleData(vehicle);
    }

    private static void readAztecFromSession() {

        Printer.printInputRequest("Podaj otrzymany kod sesji");
        AtenaSessionReader session = new AtenaSessionReader(InputScanner.scanForStringLine());

        AztecVehicle vehicle = null;

        try {
            vehicle = session.parseAztecFromSession();
        } catch (IOException e) {
            logger.error("Could not parse Json from URL session");
            Printer.printError("Błąd parsowania json");
        }


        if (vehicle != null) {
            if (vehicle.hasError())
                AztecPrinter.printSessionError(vehicle);
            else
                AztecPrinter.printAztecVehicleData(vehicle);
        }
    }
}