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
        ArrayList<AllegroItem> parents = new ArrayList<AllegroItem>();  //na podstawie tej kolekcji mozemy stworzyc na przyklad link

        treeOperations.setSearchedPhrase("Silniczki szyb");
        phraseId = treeOperations.findPhrase();                    //rekurencyjnie znajduje i zwraca ID szukanej kategorii,
        parents = treeOperations.saveParent(phraseId, parents);

        for(AllegroItem item : parents) {                            //wydrukujemy sobie rodzicow danej kategorii
                    System.out.println(item.getName());
                }
    }
}

