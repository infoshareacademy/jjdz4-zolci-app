package pl.isa.autoparts;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.tools.Printer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TextMenu {
    Scanner sc = new Scanner(System.in);
    int input;
    String[] menuOptions = {"koniec programu", "Wydrukuj całe drzewo kategorii", "Wydrukuj rodziców szukanej kategorii", "Pobierz dane kodu aztec ze zdjęcia",
            "Wybór części na podstawie serii pytań", "Wyszukiwanie auta na podstawie serii pytań"};
    InitateAztec initateAztec = new InitateAztec();

    private void showOptions() {
        for (int i = 0; i < menuOptions.length; i++)
            System.out.println((i) + ". " + menuOptions[i]);

        System.out.print("\n" + "podaj numer opcji: ");
    }
    String a = "";
    private int choseOptions() {
//        input = 0;
        a = sc.nextLine();
        try {
            input = Integer.parseInt(a);
//            input = sc.nextInt();
        } catch (InputMismatchException e) {
//            input = 6;
            return 6;
        }catch (NumberFormatException e) {
//            input = 6;
        return 6;
    }

        try {
            System.out.println("\nwybrano: " + menuOptions[input]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Podaj wartosc w zakresie 0-5!");
        }
        return input;
    }

    public void options(TreeOperations treeOperations) throws IOException {
        int i = 0;
        do {
            showOptions();
            i = choseOptions();
            switch (i) {
                case 1:
                    treeOperations.printWholeTree();
                    break;
                case 2:
                    System.out.println("Wpisz szukaną kategorię. Wpisz 'back' aby wrócić");
                    Scanner phrase = new Scanner(System.in);
                    if (phrase.equals("back")) {
                        break;
                    } else {
                        treeOperations.setSearchedPhrase(phrase.nextLine().toLowerCase());
                        treeOperations.printParents();
                    }
                    break;
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
                case 6:
                    break;
                case 0:
                    break;
                default:
                    Printer.printError("Wybrałeś złą opcję");


            }
            System.out.println("\n");
            System.out.println("\n");
        } while (i != 0);
    }


}
