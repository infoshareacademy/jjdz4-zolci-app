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
        treeOperations.findCzesciSamochodowePosition(allegroList); //zapisuje w obiekcie czesciSamochodowe jego dzieci
        treeOperations.setSearchedPhrase("Silniczki szyb");        //i przypisuje jego dzieciom ich dzieci - rekurencyjnie
        phraseId = treeOperations.findPhrase();                    //rekurencyjnie znajduje i zwraca ID szukanej kategorii,
                                                                   //szuka tylko ponizej kategorii czesciSamochdowe
        treeOperations.printWholeTree(0, treeOperations.getCzesciSamochodowe());   //drukuje cale drzewo kategorii
        treeOperations.printParent(allegroList, phraseId);          //drukuje rodzicow szukanej kategorii po kolei

    }
}

