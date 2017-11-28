package pl.isa.autoparts.tools;

import jdk.internal.util.xml.impl.Input;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.tools.StringNormalizer;
import sun.reflect.generics.tree.Tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LinkGenerator {

    private void generateLink(TreeOperations treeOperations, String category) {
        Integer catID = null;
        AllegroItem item = new AllegroItem();
        StringNormalizer stringNormalizer = new StringNormalizer();

        treeOperations.resetPhraseId();
        treeOperations.setSearchedPhrase(category);
        catID = treeOperations.getPhraseId();
        item = treeOperations.getParents().get(1);
        System.out.println(
                "https://allegro.pl/kategoria/" + stringNormalizer.normalize(item.getName())
                        + "-" + stringNormalizer.normalize(category) + "-" + catID);

    }

    public void printAllegroLinkToCategory(TreeOperations treeOperations) throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner chose = new Scanner(System.in);
        String category;
        Integer wybor;

        System.out.println("1. Wpisz nazwę kategorii.\n2. Wybór kategorii na podstawie pytań.");
        try {
            wybor = chose.nextInt();
            switch (wybor) {
                case 1:
                    System.out.println("Podaj kategorię");
                    category = input.nextLine().toString();
                    try {
                        generateLink(treeOperations, category);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    break;
                case 2:
                    Questionary questionary = new Questionary();
                    questionary.questionOptions();
                    List<String> propositions = questionary.getPropositionsList();
                    for (String categoryString : propositions) {
                        System.out.println(categoryString);
                        try {
                            generateLink(treeOperations, categoryString.toLowerCase());
                        } catch (IndexOutOfBoundsException e) {
                            continue;
                            //TODO dodaj logger
                        }
                    }
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("Wpisz 1 lub 2");
        }

    }
}



