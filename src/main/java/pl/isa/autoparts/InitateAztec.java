package pl.isa.autoparts;

import pl.isa.autoparts.aztec.*;
import pl.isa.autoparts.tools.InputScanner;
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

    public static void readAztecFromFile() {

        AztecVehicle vehicle = null;

        try {
            vehicle = AztecJsonParser.parseAztecFromFile("AztecCodeResult.json");
        } catch (IOException e) {
            Printer.printError("Niepowodzenie parsowania json z pliku");
        }

        AztecPrinter.printAztecVehicleData(vehicle);
    }

    public static void readAztecFromSession() {

        Printer.printInputRequest("Podaj kod klienta [np. qY2?0Pw!]");
        AtenaUser user = new AtenaUser(InputScanner.scanForStringLine());

        Printer.printInputRequest("Podaj otrzymany kod sesji");
        AtenaSessionReader session = new AtenaSessionReader(InputScanner.scanForStringLine(), user);

        AztecVehicle vehicle = null;

        try {
            vehicle = session.parseAztecFromSession();
        } catch (IOException e) {
            Printer.printError("Błąd parsowania json");
        }

        if (vehicle.hasError())
            AztecPrinter.printSessionError(vehicle);
        else
            AztecPrinter.printAztecVehicleData(vehicle);
    }

    public static void executeVehicleFinder() {

        Printer.println("Identyfikacja auta po serii pytań");
        Printer.println("Aktualizacja bazy... Poczekaj chwilę...");

        Vehicle vehicle = null;

        try {
            vehicle = VehicleJsonParser.parseVehicleJsonFromURL(VehicleFinder.VEHICLE_DB_URL);
        } catch (IOException e) {
            Printer.printError("Niepowodzenie parsowania json");
            return;
        }

        Printer.printInputRequest("Podaj markę szukanego auta");
        String brandName = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj model");
        String modelName = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj rocznik");
        String productionYear = InputScanner.scanForStringLine();

        Printer.printInputRequest("Podaj pojemność");
        String cylinderVolume = InputScanner.scanForStringLine();

        VehicleFinder vehicleFinder = new VehicleFinder(vehicle);

        List<VehicleData> models = vehicleFinder.findVehicleModels(brandName, modelName, productionYear);
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
        } else {
            if (!models.isEmpty())
                modelName = models.get(0).getName();
        }

        List<VehicleData> vehicles = vehicleFinder.foundVehicles(modelName, cylinderVolume);

        VehiclePrinter.printFoundVehicles(vehicleFinder, vehicles);
    }
}
