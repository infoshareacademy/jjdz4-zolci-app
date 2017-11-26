package pl.isa.autoparts;


import pl.isa.autoparts.aztec.*;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.tools.InputScanner;
import pl.isa.autoparts.tools.Printer;
import pl.isa.autoparts.tools.StringNormalizer;
import pl.isa.autoparts.vehiclefinder.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        TreeOperations treeOperations = new TreeOperations();
        int chosenOption;

        TextMenu textMenu = new TextMenu();
        textMenu.options();
    }

}


