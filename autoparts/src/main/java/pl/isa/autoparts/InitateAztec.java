package pl.isa.autoparts;

import pl.isa.autoparts.aztec.*;
import pl.isa.autoparts.tools.InputScanner;
import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autoparts.tools.Printer;
import pl.isa.autoparts.vehiclefinder.*;

import java.io.IOException;
import java.util.List;

public class InitateAztec {

    public static void executeAztecReader() {

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

    private InitateAztec() {}

    private static void readAztecFromFile() {

        AztecVehicle vehicle = null;

        try {
            vehicle = JsonParser.parseJsonFromFile("AztecCodeResult.json", AztecVehicle.class);
        } catch (IOException e) {
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
            Printer.printError("Błąd parsowania json");
        }


        if (vehicle != null) {
            if (vehicle.hasError())
                AztecPrinter.printSessionError(vehicle);
            else
                AztecPrinter.printAztecVehicleData(vehicle);
        }
    }

    public static void executeVehicleFinder() {

        Printer.println("Identyfikacja auta po serii pytań");

        Printer.printInputRequest("Podaj markę szukanego auta");
        String brandName = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj model");
        String modelName = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj rocznik");
        String productionYear = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj pojemność");
        String cylinderVolume = InputScanner.scanForStringLine();

        VehicleFinder vehicleFinder = new VehicleFinder();

        List<VehicleData> models = null;

        try {

            models = vehicleFinder.findVehicleModels(brandName, modelName, productionYear);

        } catch (IOException e) {

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
                Printer.printError("Nie udało się odnaleźć szukanego elementu");
                return;
            }
        }

        List<VehicleData> vehicles = vehicleFinder.foundVehicles(modelName, cylinderVolume);

        VehiclePrinter.printFoundVehicles(vehicleFinder, vehicles);
    }
}