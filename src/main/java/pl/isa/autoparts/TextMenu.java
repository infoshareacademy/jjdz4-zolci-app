package pl.isa.autoparts;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.tools.Printer;
import pl.isa.autoparts.tools.StringNormalizer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TextMenu {
    Scanner sc = new Scanner(System.in);
    int input;

    InitateAztec initateAztec = new InitateAztec();

    String[] menuOptions = {"Wydrukuj całe drzewo kategorii", "Wydrukuj rodziców szukanej kategorii", "Pobierz dane kodu aztec ze zdjęcia",
            "Wybór części na podstawie serii pytań", "Wyszukiwanie auta na podstawie serii pytań", "Wydrukuj link do Allegro dla szukanej kategorii"};


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
        int checkOption;
        do {
            showOptions();
            checkOption = choseOptions();
            switch (checkOption) {
                case 1:
                    treeOperations.printWholeTree();
                    break;
//                case 2:
//                    System.out.println("Wpisz szukaną kategorię. Wpisz 'back' aby wrócić");
//                    Scanner scanner = new Scanner(System.in);
//                    String phrase = scanner.nextLine();
//                    if (phrase.equals("back")) {
//                        break;
//                    }
//
//                    treeOperations.setSearchedPhrase(phrase.toLowerCase());
//                    treeOperations.printParents();
//
//                    break;
                case 3:
                    initateAztec.executeAztecReader();
                    break;
                case 4:
                    Questionary questionary = new Questionary();
                    questionary.questionOptions();
                    break;
                case 5:
                    initateAztec.executeVehicleFinder();
                    break;
                case 2:
                    printAllegroLinkToCategory(treeOperations);
                    break;
                case 0:
                    break;
                default:

            }
            System.out.println("\n");
        } while (checkOption != 0);
    }

    private static void printAllegroLinkToCategory(TreeOperations treeOperations) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj kategorię");
        String category = input.nextLine().toString();
        treeOperations.setSearchedPhrase(category);
        int catID = treeOperations.getPhraseId();
        AllegroItem item = treeOperations.getParents().get(1);
        StringNormalizer stringNormalizer = new StringNormalizer();
        System.out.println(
                "https://allegro.pl/kategoria/" + stringNormalizer.normalize(item.getName())
                        + "-" + stringNormalizer.normalize(category) + "-" + catID
        );
    }


}
