package pl.isa.autoparts;



import pl.isa.autoparts.TextMenu;
import pl.isa.categories.AllegroItem;
import pl.isa.categories.Parser;
import pl.isa.categories.TreeOperations;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {
        int chosenOption;
        int czesciSamochodoweId = 620;
        int czesciSamochodowePosition = 0;
        int phraseId;
        AllegroItem czesciSamochodowe;
        ArrayList<AllegroItem> allegroList = new ArrayList<AllegroItem>();


        /*TextMenu textMenu = new TextMenu();
        textMenu.showOptions();
        chosenOption = textMenu.choseOptions();*/


        Parser parser = new Parser();
        parser.parse();
        allegroList = parser.getAllegroList();







        for (int i = 0; i < allegroList.size(); i++) { //find collection position of category "Części Samochodowe"
            if (allegroList.get(i).getId() == czesciSamochodoweId) {
                czesciSamochodowePosition = i;
                break;
            }
        }

        czesciSamochodowe = allegroList.get(czesciSamochodowePosition);

        czesciSamochodowe.setChildren(allegroList);

        TreeOperations treeOperations = new TreeOperations(czesciSamochodowe);

        //treeOperations.printWholeTree(0, czesciSamochodowe);
        treeOperations.searchedPhrase("Silniczki szyb"); //for example

        phraseId = treeOperations.findPhrase(czesciSamochodowe);
        System.out.println(phraseId);
    }
}

