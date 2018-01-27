package pl.isa.autoparts.categories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TreeOperations {
    Logger logger = LoggerFactory.getLogger(TreeOperations.class.getName());

    private ArrayList<AllegroItem> allegroList = new ArrayList<>();
    private ArrayList<AllegroItem> partsList = new ArrayList<>();
    private AllegroItem czesciSamochodowe = new AllegroItem();

    public ArrayList<AllegroItem> getSimilarList() {
        return similarList;
    }

    private ArrayList<AllegroItem> similarList = new ArrayList<>();
    public TreeOperations() {
        Parser parser = new Parser();
        allegroList = parser.getAllegroList();
        findCzesciSamochodowePosition();

    }

    private void createCarPartsList(int parentId) {
        for (AllegroItem item : allegroList) {
            if (item.getParent() == parentId){
                partsList.add(item);
                createCarPartsList(item.getId());
            }
        }
    }

    private void findCzesciSamochodowePosition() {
        int czesciSamochodoweId = 620;
        int czesciSamochodowePosition = 0;
        for (int i = 0; i < allegroList.size(); i++) { //find collection position of category "Części Samochodowe"
            if (allegroList.get(i).getId() == czesciSamochodoweId) {
                czesciSamochodowePosition = i;
                break;
            }
        }
        czesciSamochodowe = allegroList.get(czesciSamochodowePosition);
        createCarPartsList(czesciSamochodowe.getId());
    }

//    public AllegroItem findCarPartCategory(String phrase){
//        for(AllegroItem item : partsList){
//            if(item.getName().startsWith(phrase))
//                return item;
//        }
//        return null;
//    }
    public void findCarPartCategory(String phrase){
        for(AllegroItem item : partsList){
            if(item.getName().startsWith(phrase))
                similarList.add(item);
        }
    }

    public AllegroItem findParent(AllegroItem child){
        for(AllegroItem item : partsList){
            if(item.getId()==child.getId())
                return item;
        }
        return null;
    }


}




