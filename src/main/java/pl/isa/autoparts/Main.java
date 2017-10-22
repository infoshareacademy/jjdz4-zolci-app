package pl.isa.autoparts;


import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;

public class Main {


    public static void main(String[] args) {
        int chosenOption;

        /*TextMenu textMenu = new TextMenu();
        textMenu.showOptions();
        chosenOption = textMenu.choseOptions();*/


        TreeOperations treeOperations = new TreeOperations();
        treeOperations.setSearchedPhrase("Silniczki szyb");
        treeOperations.printWholeTree();


        for (AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
            System.out.println(item.getName());
        }
    }
}

