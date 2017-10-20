package pl.isa.autoparts;


import pl.isa.categories.AllegroItem;
import pl.isa.categories.Parser;
import pl.isa.categories.TreeOperations;

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





        TreeOperations treeOperations = new TreeOperations();
        treeOperations.findCzesciSamochodowePosition(allegroList);
        treeOperations.setSearchedPhrase("Silniczki szyb"); //for example
        phraseId = treeOperations.findPhrase();
        treeOperations.printParent(allegroList, phraseId);
        treeOperations.printWholeTree(0, treeOperations.getCzesciSamochodowe());

    }
}

