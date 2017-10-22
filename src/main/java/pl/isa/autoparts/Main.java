package pl.isa.autoparts;


import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.Parser;
import pl.isa.autoparts.categories.TreeOperations;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        int chosenOption;

        int phraseId;
        AllegroItem czesciSamochodowe;
        ArrayList<AllegroItem> allegroList = new ArrayList<AllegroItem>();


        /*TextMenu textMenu = new TextMenu();
        textMenu.showOptions();
        chosenOption = textMenu.choseOptions();*/


        Parser parser = new Parser();
        parser.parse();
        allegroList = parser.getAllegroList();


        TreeOperations treeOperations = new TreeOperations(allegroList);
        treeOperations.printWholeTree();
        treeOperations.setSearchedPhrase("Silniczki szyb");


        for(AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
                    System.out.println(item.getName());
                }
    }
            }

