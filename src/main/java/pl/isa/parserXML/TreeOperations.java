package pl.isa.parserXML;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class TreeOperations {


    private AllegroItem czesciSamochodowe = new AllegroItem();

    TreeOperations(AllegroItem allegroItem) {
        this.czesciSamochodowe = allegroItem;
    }


    public void printWholeTree(int stars, AllegroItem czesciSamochodowe) {
        stars++;
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            for (int i = 0; i < stars; i++) {
                System.out.print("*");
            }
            System.out.println(item.getName());
            printWholeTree(stars, item);
        }
    }
}




