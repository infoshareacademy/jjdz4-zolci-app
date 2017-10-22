package pl.isa.autoparts;


import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;

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
                treeOperations.setSearchedPhrase("Silniczki szyb");
                for (AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
                    System.out.println(item.getName());
                }
                break;
        }


    }
}

