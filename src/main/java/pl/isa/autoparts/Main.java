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
        ArrayList<AllegroItem> parents = new ArrayList<AllegroItem>();  //na podstawie tej kolekcji mozemy stworzyc na przyklad


        //treeOperations.findCzesciSamochodowePosition(allegroList); //zapisuje w obiekcie czesciSamochodowe jego dzieci
        treeOperations.setSearchedPhrase("Silniczki szyb");        //i przypisuje jego dzieciom ich dzieci - rekurencyjnie
        phraseId = treeOperations.findPhrase();                    //rekurencyjnie znajduje i zwraca ID szukanej kategorii,
        //szuka tylko ponizej kategorii czesciSamochdowe
        //treeOperations.printWholeTree(0, treeOperations.getCzesciSamochodowe());   //drukuje cale drzewo kategorii
        //treeOperations.printParent(allegroList, phraseId);          //drukuje rodzicow szukanej kategorii po kolei

                                                                        //link do kategorii
        parents = treeOperations.saveParent(allegroList, phraseId, parents); //tworzy kolekcje z obiektami

        for(AllegroItem item : parents) {                            //sprawdzenie czy dziala tak samo jak printParent
                    System.out.println(item.getName());
                }
    }
}

