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
        AllegroItem item;
        StringNormalizer stringNormalizer = new StringNormalizer();
        try {
            treeOperations.resetPhraseId();
            treeOperations.setSearchedPhrase(category);
            catID = treeOperations.getPhraseId();
            item = treeOperations.getParents().get(1);
            itemName = treeOperations.findName();
            return "https://allegro.pl/kategoria/" + stringNormalizer.normalize(item.getName())
                    + "-" + stringNormalizer.normalize(category) + "-" + catID;
//            logger.info("Link generated");
        } catch (IndexOutOfBoundsException e) {
//            logger.error("No category parent or category not found, error in link generating");

        }
        return "Category not found";

    }
}
