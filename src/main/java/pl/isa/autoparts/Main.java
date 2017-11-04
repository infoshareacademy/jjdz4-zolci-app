package pl.isa.autoparts;


import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
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
                Scanner phrase = new Scanner(System.in);
                treeOperations.setSearchedPhrase(phrase.nextLine());
                for (AllegroItem item : treeOperations.getParents()) {     //wydrukujemy sobie rodzicow danej kategorii
                    System.out.println(item.getName());
                }
                break;
            case 3:
                Questionary questionary = new Questionary();
                questionary.questionOptions();
                break;
        }


    }
}

