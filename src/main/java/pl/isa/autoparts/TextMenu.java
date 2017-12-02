package pl.isa.autoparts;

import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.tools.LinkGenerator;
import pl.isa.autoparts.tools.Printer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TextMenu {
    Scanner sc = new Scanner(System.in);
    int input;

    InitateAztec initateAztec = new InitateAztec();

    String[] menuOptions = {"Koniec programu", "Wydrukuj całe drzewo kategorii", "Wybierz kategorię szukanej części", "Pobierz dane kodu aztec ze zdjęcia",
            "Wyszukiwanie auta na podstawie serii pytań"};

    private void showOptions() {
        for (int i = 0; i < menuOptions.length; i++)
            System.out.println((i) + ". " + menuOptions[i]);

        System.out.print("\n" + "podaj numer opcji: ");
    }

    String stringInput = "";

    private int choseOptions() {
        stringInput = sc.nextLine();
        System.out.println();
        try {
            input = Integer.parseInt(stringInput);
        } catch (InputMismatchException e) {
            return 6;
        } catch (NumberFormatException e) {
            Printer.printError("dana nie jest indeksem");
            System.out.println("Podaj wartosc w zakresie 0-5!");
            return 6;
        }

        try {
            System.out.println("\nwybrano: " + menuOptions[input]);
        } catch (ArrayIndexOutOfBoundsException e) {
            Printer.printError("Wybrałeś złą opcję");
            System.out.println("Podaj wartosc w zakresie 0-5!");
        }
        return input;
    }

    public void options() throws IOException {
        TreeOperations treeOperations = new TreeOperations();
        LinkGenerator linkGenerator = new LinkGenerator();
        int checkOption;
        do {
            showOptions();
            checkOption = choseOptions();
            switch (checkOption) {
                case 1:
                    treeOperations.printWholeTree();
                    break;
                case 2:
                    linkGenerator.printAllegroLinkToCategory(treeOperations);
                    break;
                case 3:
                    initateAztec.executeAztecReader();
                    break;
                case 4:
                    initateAztec.executeVehicleFinder();

                    break;


                case 0:
                    break;
                default:

            }
            System.out.println("\n");
        } while (checkOption != 0);
    }


}



