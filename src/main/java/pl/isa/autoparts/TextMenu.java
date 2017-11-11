package pl.isa.autoparts;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.tools.Printer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TextMenu {
    Scanner sc = new Scanner(System.in);
    int input;
    String[] menuOptions = {"Wydrukuj całe drzewo kategorii", "Wydrukuj rodziców szukanej kategorii", "Pobierz dane kodu aztec ze zdjęcia",
            "Wybór części na podstawie serii pytań", "Wyszukiwanie auta na podstawie serii pytań"};
    InitateAztec initateAztec = new InitateAztec();

    private void showOptions() {
        for (int i = 0; i < menuOptions.length; i++)
            System.out.println((i + 1) + ". " + menuOptions[i]);

        System.out.print("\n" + "podaj numer opcji: ");
    }

    private int choseOptions() {
        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            return 6;
        }
        try {
            System.out.println("\nwybrano: " + menuOptions[input - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Podaj wartosc w zakresie 1-5!");
        }
        return input;
    }

    public void options(TreeOperations treeOperations) throws IOException {
        do {
            showOptions();
            int i = choseOptions();
            switch (i) {
                case 1:
                    treeOperations.printWholeTree();
                    break;
                case 2:
                    System.out.println("Wpisz szukaną kategorię. Wpisz 'back' aby wrócić");
                    Scanner phrase = new Scanner(System.in);
                    if(phrase.equals("back")){
                        options(treeOperations);
                    }
                    else {
                        treeOperations.setSearchedPhrase(phrase.nextLine());
                        for (AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
                            System.out.println(item.getName());
                        }
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
                default:
                    Printer.printError("Wybrałeś złą opcję");


            }
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");
        }while(true);
    }



}
