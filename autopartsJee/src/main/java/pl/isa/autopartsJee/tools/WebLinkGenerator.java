package pl.isa.autopartsJee.tools;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.tools.StringNormalizer;
import pl.isa.autopartsJee.domain.ItemParentName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WebLinkGenerator {

    private String itemName = new String();

    ArrayList<String> linksList = new ArrayList<>();

    public Map<String, String> getNameLink() {
        return nameLink;
    }

    Map<String, String> nameLink = new HashMap<>();

    public Map<String, ItemParentName> getLinkAndNames() {
        return linkAndNames;
    }

    Map<String, ItemParentName> linkAndNames = new HashMap<>();

    public String getItemName() {
        return itemName;
    }



    public void generateLinkMap(String category, TreeOperations treeOperations) {
        AllegroItem parent;
        StringNormalizer stringNormalizer = new StringNormalizer();

        try {
            treeOperations.clearList();
            treeOperations.findCarPartCategoryList(category.toLowerCase());
            ArrayList<AllegroItem> similarList = treeOperations.getSimilarList();
            for (AllegroItem item : similarList) {
                ItemParentName itemParentName = new ItemParentName();
                parent = treeOperations.findParent(item);
                itemParentName.setItemName(item.getName().substring(0, 1).toUpperCase()
                        + item.getName().substring(1).toLowerCase());
                itemParentName.setParentName(parent.getName().substring(0, 1).toUpperCase()
                        + parent.getName().substring(1).toLowerCase());

                linkAndNames.put("https://allegro.pl/kategoria/" + stringNormalizer.normalize(parent.getName())
                        + "-" + stringNormalizer.normalize(item.getName()) + "-" + item.getId(), itemParentName);

//            logger.info("Link generated");
            }
        } catch (IndexOutOfBoundsException e) {
//            logger.error("No category parent or category not found, error in link generating");

        }
//        return "Category not found";

    }

    public String generateLink(String category, TreeOperations treeOperations) {
        Integer catID;
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
