package pl.isa.autoparts.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LinkGenerator {
    Logger logger = LoggerFactory.getLogger(LinkGenerator.class.getName());
    TreeOperations treeOperations = new TreeOperations();
    private String itemName = new String();


    public String getItemName() {
        return itemName;
    }

    public void printAllegroLinkToCategory() throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner chose = new Scanner(System.in);
        String category;
        Integer wybor;


        System.out.println("1. Wpisz nazwę kategorii.\n2. Wybór kategorii na podstawie pytań.");
//        try {
//            wybor = chose.nextInt();
//            switch (wybor) {
//                case 1:
//                    System.out.println("Podaj kategorię");
//                    category = input.nextLine();
//                    generateLink(category, treeOperations);
//                    logger.info("Link from manual inserted category printed");
//                    break;
//                case 2:
//                    Questionary questionary = new Questionary();
//                    questionary.questionOptions();
//                    List<String> propositions = questionary.getStringList();
//                    for (String categoryString : propositions) {
//                        System.out.print("- " + categoryString + ": ");
//                        generateLink(categoryString, treeOperations);
//                    }
//                    logger.info("List of proposed links printed");
//                    break;
//
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("Wpisz 1 lub 2");
//        }
//    }


//    public String generateLink(String category, TreeOperations treeOperations) {
//        Integer catID;
//        AllegroItem item;
//        String link;
//        StringNormalizer stringNormalizer = new StringNormalizer();
//        try {
//            treeOperations.resetPhraseId();
//            treeOperations.setSearchedPhrase(category);
//            catID = treeOperations.getPhraseId();
//            item = treeOperations.getParents().get(1);
//            itemName = treeOperations.findName();
//            logger.info("Link generated");
//            link = "https://allegro.pl/kategoria/" + stringNormalizer.normalize(item.getName())
//                    + "-" + stringNormalizer.normalize(itemName) + "-" + catID;
//            System.out.println(link);
//            return link;
//        } catch (IndexOutOfBoundsException e) {
//            logger.warn("No category parent or category not found, error in link generating");
//
//        }
//        return "Category not found";
//    }
//}
    }
}