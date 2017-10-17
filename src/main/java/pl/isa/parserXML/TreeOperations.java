package pl.isa.parserXML;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class TreeOperations {


    private String category;
    private ArrayList<AllegroItem> allegroList = new ArrayList<AllegroItem>();

    TreeOperations(ArrayList<AllegroItem> allegroList) {
        this.allegroList = allegroList;
    }


    public void printWholeTree(int stars, AllegroItem allegroItem) {
        stars++;
        for (AllegroItem item : allegroItem.getChildren()) {
            for (int i = 0; i < stars; i++) {
                System.out.print("*");
            }
            System.out.println(item.getName());
            printWholeTree(stars, item);
        }
    }

    public void setSearchedCategory(String category) {
        this.category = category;
    }

    public void printRelations() {
        for (AllegroItem item : this.allegroList) {
            if (item.getName().equals(this.category)) {
                System.out.println(item.getName());
                for (AllegroItem parent : this.allegroList) {
                    if (item.getParent() == parent.getId()) {
                        setSearchedCategory(parent.getName());
                        printRelations();

                    }
                }
            }
        }
    }
}




