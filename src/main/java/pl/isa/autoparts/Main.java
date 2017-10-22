package pl.isa.autoparts;


import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.Parser;
import pl.isa.autoparts.categories.TreeOperations;

public class Main {


    public static void main(String[] args) {
        int chosenOption;

        /*TextMenu textMenu = new TextMenu();
        textMenu.showOptions();
        chosenOption = textMenu.choseOptions();*/


        Parser parser = new Parser();

        TreeOperations treeOperations = new TreeOperations(parser.getAllegroList());
        treeOperations.printWholeTree();
        treeOperations.setSearchedPhrase("Silniczki szyb");


        for(AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
                    System.out.println(item.getName());
                }
    }
            }

