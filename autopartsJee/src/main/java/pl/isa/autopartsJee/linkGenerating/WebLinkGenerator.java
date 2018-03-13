package pl.isa.autopartsJee.linkGenerating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.tools.StringNormalizer;
import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.linkGenerating.domain.ItemParentName;

import java.util.HashMap;
import java.util.Map;

public class WebLinkGenerator {

    private Logger logger = LoggerFactory.getLogger(WebLinkGenerator.class.getName());

    public Map<String, ItemParentName> getLinkAndNames() {
        return linkAndNames;
    }

    Map<String, ItemParentName> linkAndNames = new HashMap<>();

    private String searchedCar = " ";

    public void generateLinkMap(String category, CarData car, TreeOperations treeOperations) {
        StringNormalizer stringNormalizer = new StringNormalizer();

        try {

            AllegroItem allegroItem = treeOperations.findExactCarPartCategory(category);
            AllegroItem parent = treeOperations.findParent(allegroItem);

            ItemParentName itemParentName = new ItemParentName();
            itemParentName.setItemName(allegroItem.getName().substring(0, 1).toUpperCase()
                    + allegroItem.getName().substring(1).toLowerCase());
            itemParentName.setParentName(parent.getName().substring(0, 1).toUpperCase()
                    + parent.getName().substring(1).toLowerCase());

            linkAndNames.put("https://allegro.pl/kategoria/" + stringNormalizer.normalize(parent.getName())
                    + "-" + stringNormalizer.normalize(allegroItem.getName())
                    + "-" + allegroItem.getId() + searchedCar, itemParentName);

            logger.info("Links list generated");

        } catch (
                IndexOutOfBoundsException e)

        {
            logger.warn("No category parent or category not found, error in link generating");

        }

    }

    public String generateLink(String category, TreeOperations treeOperations) {
        AllegroItem parent;
        AllegroItem categoryItem;
        StringNormalizer stringNormalizer = new StringNormalizer();
        try {
            categoryItem = treeOperations.findExactCarPartCategory(category.toLowerCase());
            parent = treeOperations.findParent(categoryItem);
            logger.info("Link generated");
            return "https://allegro.pl/kategoria/" + stringNormalizer.normalize(parent.getName())
                    + "-" + stringNormalizer.normalize(categoryItem.getName()) + "-" + categoryItem.getId();
        } catch (IndexOutOfBoundsException e) {
            logger.warn("No category parent or category not found, error in link generating");

        }
        return "Category not found";

    }
}
