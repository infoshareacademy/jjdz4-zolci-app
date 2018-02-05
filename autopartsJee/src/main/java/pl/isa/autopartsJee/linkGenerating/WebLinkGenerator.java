package pl.isa.autopartsJee.linkGenerating;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.tools.StringNormalizer;
import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.linkGenerating.domain.ItemParentName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WebLinkGenerator {

    private String itemName = new String();


    public Map<String, ItemParentName> getLinkAndNames() {
        return linkAndNames;
    }

    Map<String, ItemParentName> linkAndNames = new HashMap<>();

    public String getItemName() {
        return itemName;
    }

    private String searchedCar = " ";
    public void generateLinkMap(String category, CarData car, TreeOperations treeOperations) {
        AllegroItem parent;
        StringNormalizer stringNormalizer = new StringNormalizer();

        try {

            treeOperations.clearList();
            treeOperations.findCarPartCategoryList(category.toLowerCase());
            ArrayList<AllegroItem> similarList = treeOperations.getSimilarList();

            for (AllegroItem item : similarList) {

                parent = treeOperations.findParent(item);
                if(car!=null) {
                    searchedCar = "?" + "string="
                            + car.getVehicleMake() + " " +
                            car.getVehicleModel().substring(0, car.getVehicleModel().indexOf(" "))
                            + " " + car.getProdYear();
                }
                ItemParentName itemParentName = new ItemParentName();
                itemParentName.setItemName(item.getName().substring(0, 1).toUpperCase()
                        + item.getName().substring(1).toLowerCase());
                itemParentName.setParentName(parent.getName().substring(0, 1).toUpperCase()
                        + parent.getName().substring(1).toLowerCase());
                linkAndNames.put("https://allegro.pl/kategoria/" + stringNormalizer.normalize(parent.getName())
                                + "-" + stringNormalizer.normalize(item.getName()) + "-" + item.getId() + searchedCar
                        , itemParentName);

//            logger.info("Link generated");
            }
        } catch (IndexOutOfBoundsException e) {
//            logger.error("No category parent or category not found, error in link generating");

        }
//        return "Category not found";

    }

    public String generateLink(String category, TreeOperations treeOperations) {
        AllegroItem parent;
        AllegroItem categoryItem;
        StringNormalizer stringNormalizer = new StringNormalizer();
        try {
            treeOperations.clearList();
            categoryItem = treeOperations.findExactCarPartCategory(category.toLowerCase());
            parent = treeOperations.findParent(categoryItem);
            return "https://allegro.pl/kategoria/" + stringNormalizer.normalize(parent.getName())
                    + "-" + stringNormalizer.normalize(categoryItem.getName()) + "-" + categoryItem.getId();
//            logger.info("Link generated");
        } catch (IndexOutOfBoundsException e) {
//            logger.error("No category parent or category not found, error in link generating");

        }
        return "Category not found";

    }
}
