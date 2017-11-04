package pl.isa.autoparts;


import pl.isa.autoparts.aztec.*;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.tools.InputScanner;
import pl.isa.autoparts.tools.Printer;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        TreeOperations treeOperations = new TreeOperations();
        int chosenOption;

        TextMenu textMenu = new TextMenu();
        textMenu.showOptions();
        chosenOption = textMenu.choseOptions();

        switch (chosenOption) {
            case 1:
                treeOperations.printWholeTree();
                break;
            case 2:
                treeOperations.setSearchedPhrase("Silniczki szyb");
                for (AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
                    System.out.println(item.getName());
                }
                break;
            case 3:
                executeAztecReader();
                break;
            default:
                Printer.printError("Wybrałeś złą opcję");
        }
    }


    private static void executeAztecReader() {

        Printer.println("Pokaż dane kodu aztec");
        Printer.println("1. Pobierz dane z pliku");
        Printer.println("2. Pobierz dane z sesji Atena");

        Printer.inputRequest("Wybierz opcję", "np. 1");
        int option = InputScanner.scanForOption();

        AztecVehicle vehicle = null;

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

    private static void readAztecFromFile() {

        AztecVehicle vehicle = null;

        try {
            vehicle = AztecJsonParser.parseAztecFromFile("AztecCodeResult.json");
        } catch (IOException e) {
            Printer.printError("Niepowodzenie parsowania json z pliku");
        }

        AztecPrinter.printAztecVehicleData(vehicle);
    }

    private static void readAztecFromSession() {

        Printer.inputRequest("Podaj kod klienta", "np. qY2?0Pw!");
        AtenaUser user = new AtenaUser(InputScanner.scanForStringLine());

        Printer.inputRequest("Podaj otrzymany kod sesji", "np. g1sjjw");
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
}

