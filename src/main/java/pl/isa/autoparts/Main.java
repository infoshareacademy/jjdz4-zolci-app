package pl.isa.autoparts;


import pl.isa.autoparts.aztec.*;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.tools.InputScanner;
import pl.isa.autoparts.tools.Printer;
import pl.isa.autoparts.tools.StringNormalizer;
import pl.isa.autoparts.vehiclefinder.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        TreeOperations treeOperations = new TreeOperations();
        int chosenOption;

        TextMenu textMenu = new TextMenu();
        textMenu.options();
    }

}

    private static void printAllegroLinkToCategory(TreeOperations treeOperations) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj kategorię");
        String category = input.nextLine().toString();
        treeOperations.setSearchedPhrase(category);
        int catID = treeOperations.findPhrase(category);
        AllegroItem item = treeOperations.getParents().get(1);
        StringNormalizer stringNormalizer = new StringNormalizer();
        System.out.println(
                "https://allegro.pl/kategoria/" + stringNormalizer.normalize(item.getName())
                        + "-" + stringNormalizer.normalize(category) + "-" + catID
        );
    }
     case 6:
             printAllegroLinkToCategory(treeOperations);
             break;