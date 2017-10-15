package pl.isa.parserXML;

import java.util.ArrayList;

public class TreeOperations {


    private String category;

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

    public void printRelations(ArrayList<AllegroItem> allegroList) {
        AllegroItem leaf = null;
        for(AllegroItem item : allegroList)
        {
            if(item.getName().equals(this.category)){
                leaf = item;
                break;
//                this.category = item.getParentObject().getName();
//                System.out.println(item.getName());
//                printRelations(allegroList);

            }
        }

        this.printParent(leaf);
    }

    private void printParent(AllegroItem item) {
        AllegroItem parentObject = item.getParentObject();

        if (parentObject != null) {
            System.out.println(parentObject.getName());
            printParent(parentObject);
        }
    }
}


