package pl.isa.autoparts;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.tools.StringNormalizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinkGenerator {


    public void printAllegroLinkToCategory(TreeOperations treeOperations) throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner chose = new Scanner(System.in);
        String category;
        int catID;
        int wybor;
        AllegroItem item;
        StringNormalizer stringNormalizer = new StringNormalizer();
        System.out.println("1. Wpisz nazwę kategorii.\n2. Wybór kategorii na podstawie pytań.");
        wybor = chose.nextInt();

        switch (wybor) {
            case 1:
                System.out.println("Podaj kategorię");
                category = input.nextLine().toString();
                treeOperations.setSearchedPhrase(category);
                catID = treeOperations.getPhraseId();
                item = treeOperations.getParents().get(1);
                System.out.println(
                        "https://allegro.pl/kategoria/" + stringNormalizer.normalize(item.getName())
                                + "-" + stringNormalizer.normalize(category) + "-" + catID);
                break;
            case 2:
                Questionary questionary = new Questionary();
                questionary.questionOptions();
                List<String> propositions = questionary.getPropositionsList();
                for (String categoryString : propositions) {
                    categoryString = "chłodnice";
                    System.out.println(categoryString);
                    treeOperations.setSearchedPhrase(categoryString);
                    catID = treeOperations.getPhraseId();
                    item = treeOperations.getParents().get(1);
                    System.out.println(
                            "https://allegro.pl/kategoria/" + stringNormalizer.normalize(item.getName())
                                    + "-" + stringNormalizer.normalize(categoryString) + "-" + catID);

                }
                break;

        }
    }
}



