package pl.isa.autoparts.categories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TreeOperations {
    private int czesciSamochodowePosition = 0;
    Logger logger = LoggerFactory.getLogger(TreeOperations.class.getName());

    private ArrayList<AllegroItem> allegroList = new ArrayList<>();
    private ArrayList<AllegroItem> partsList = new ArrayList<>();
    private AllegroItem czesciSamochodowe = new AllegroItem();

    public TreeOperations() {
        Parser parser = new Parser();
        allegroList = parser.getAllegroList();
        findCzesciSamochodowePosition();

    }

    private void createCarPartsList(ArrayList<AllegroItem> allegroList, AllegroItem parent) {
        for (AllegroItem item : allegroList) {
            if (item.getId() == parent.getId()){
                partsList.add(item);
                createCarPartsList(allegroList, item);
            }
        }
    }

    private void findCzesciSamochodowePosition() {
        int czesciSamochodoweId = 620;
        for (int i = 0; i < allegroList.size(); i++) { //find collection position of category "Części Samochodowe"
            if (allegroList.get(i).getId() == czesciSamochodoweId) {
                czesciSamochodowePosition = i;
                break;
            }
        }
        czesciSamochodowe = allegroList.get(czesciSamochodowePosition);
        createCarPartsList(allegroList, czesciSamochodowe);
    }

    public AllegroItem findCarPartCategory(String phrase){
        for(AllegroItem item : partsList){
            if(item.getName().startsWith(phrase))
                return item;
        }
        return null;
    }

    public AllegroItem findParent(AllegroItem child){
        for(AllegroItem item : partsList){
            if(item.getId()==child.getId())
                return item;
        }
        return null;
    }


}




