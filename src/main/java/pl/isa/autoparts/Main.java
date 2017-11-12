package pl.isa.autoparts;


import pl.isa.autoparts.categories.TreeOperations;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TreeOperations treeOperations = new TreeOperations();

        TextMenu textMenu = new TextMenu();
        textMenu.options(treeOperations);
    }
}

