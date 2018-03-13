package pl.isa.autoparts.categories;

import java.util.ArrayList;

public class TreeOperations {

    private ArrayList<AllegroItem> allegroList = new ArrayList<>();

    public ArrayList<AllegroItem> getPartsList() {
        return partsList;
    }

    private ArrayList<AllegroItem> partsList = new ArrayList<>();

    public TreeOperations() {
        Parser parser = new Parser();
        allegroList = parser.getAllegroList();
        createCarPartsList(allegroList.stream().filter(s -> s.getId() == 620).findFirst().get().getId());
    }


    private void createCarPartsList(int parentId) {
        for (AllegroItem item : allegroList) {
            if (item.getParentId() == parentId) {
                partsList.add(item);
                createCarPartsList(item.getId());
            }
        }
    }


    public AllegroItem findExactCarPartCategory(String phrase) {
        for (AllegroItem item : partsList) {
            if (item.getName().startsWith(phrase))
                return item;
        }
        return null;
    }


    public AllegroItem findParent(AllegroItem child) {
        for (AllegroItem item : partsList) {
            if (item.getId() == child.getParentId())
                return item;
        }
        return child;
    }
}




