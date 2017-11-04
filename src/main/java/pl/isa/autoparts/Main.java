package pl.isa.autoparts;


import pl.isa.autoparts.aztec.AtenaSessionReader;
import pl.isa.autoparts.aztec.AtenaUser;
import pl.isa.autoparts.aztec.AztecPrinter;
import pl.isa.autoparts.aztec.AztecVehicle;
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

        Printer.println("Pobieranie danych kodu aztec ze zdjęcia");

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

