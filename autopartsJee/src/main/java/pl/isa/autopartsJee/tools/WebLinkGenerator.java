package pl.isa.autopartsJee.tools;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.tools.StringNormalizer;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Map;

public class WebLinkGenerator {

    private String itemName = new String();

    ArrayList<String> linksList = new ArrayList<>();
    Map<String, String> nameLink = new Map<String, String>();
    public String getItemName() {
        return itemName;
    }

    public void generateLink(String category, TreeOperations treeOperations) {
        Integer catID;
        AllegroItem parent;
        AllegroItem categoryItem;
        StringNormalizer stringNormalizer = new StringNormalizer();

        try {
            treeOperations.findCarPartCategory(category);
            ArrayList<AllegroItem> similarList = treeOperations.getSimilarList();
            for (AllegroItem item : similarList) {
                parent = treeOperations.findParent(item);
                linksList.add("https://allegro.pl/kategoria/" + stringNormalizer.normalize(parent.getName())
                        + "-" + stringNormalizer.normalize(item.getName()) + "-" + item.getId());
//            logger.info("Link generated");
            }
        } catch (IndexOutOfBoundsException e) {
//            logger.error("No category parent or category not found, error in link generating");

        }
        return "Category not found";

    }
}
