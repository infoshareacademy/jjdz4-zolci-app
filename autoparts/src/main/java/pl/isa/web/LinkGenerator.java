package pl.isa.web;

import pl.isa.web.categories.AllegroItem;
import pl.isa.web.categories.TreeOperations;
import pl.isa.web.questions.Questionary;
import pl.isa.web.tools.StringNormalizer;

import java.io.IOException;
import java.util.Scanner;

public class LinkGenerator {


    public static void printAllegroLinkToCategory(TreeOperations treeOperations) throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner chose = new Scanner(System.in);

        int wybor;
        System.out.println("1. Wpisz nazwę kategorii.\n2. Wybór kategorii na podstawie pytań.");
        wybor = chose.nextInt();

        switch (wybor) {
            case 1:
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
                break;
            case 2:
                Questionary questionary = new Questionary();
                questionary.questionOptions();

                System.out.println(questionary.getPropositionsList());
        }
    }
}



