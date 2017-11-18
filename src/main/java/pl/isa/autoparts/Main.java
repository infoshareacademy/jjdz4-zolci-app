package pl.isa.autoparts;


import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;

import java.util.Scanner;

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
                Scanner ask = new Scanner(System.in);
                System.out.println("Podaj kategorię");
                String cat = ask.next().toString();
                treeOperations.setSearchedPhrase(cat);
                for (AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
                    System.out.println(item.getName());
                }
                break;
            case 3:
                Scanner input = new Scanner(System.in);
                System.out.println("Podaj kategorię");
                String category = input.next().toString();
                treeOperations.setSearchedPhrase(category);
                int catID = treeOperations.findPhrase(category);
                int i = 0;
                for (AllegroItem item : treeOperations.getParents()) {
                    i++;
                    if(i == 2) {
                        System.out.println("https://allegro.pl/kategoria/" + item.getName().replace(" ", "-").toLowerCase() + "-" + category.toLowerCase() + "-" +catID);
                    }
                }
                break;
        }


    }
}

