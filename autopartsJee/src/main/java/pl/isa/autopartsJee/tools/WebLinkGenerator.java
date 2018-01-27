package pl.isa.autopartsJee.tools;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.tools.StringNormalizer;
import sun.reflect.generics.tree.Tree;

public class WebLinkGenerator {

    private String itemName = new String();


    public String getItemName() {
        return itemName;
    }

    public String generateLink(String category, TreeOperations treeOperations) {
        Integer catID;
        AllegroItem parent;
        AllegroItem categoryItem;
        StringNormalizer stringNormalizer = new StringNormalizer();
        try {
            categoryItem = treeOperations.findCarPartCategory(category);
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
