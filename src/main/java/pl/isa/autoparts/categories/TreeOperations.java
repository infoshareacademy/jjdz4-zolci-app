package pl.isa.autoparts.categories;

import java.util.ArrayList;
import java.util.logging.Logger;

public class TreeOperations {
//    private static final Logger logger = Logger.getLogger(TreeOperations.class.getName());
    static int czesciSamochodoweId = 620;
    private int czesciSamochodowePosition = 0;
    private int phraseId;
    private ArrayList<AllegroItem> allegroList = new ArrayList<>();
    private ArrayList<AllegroItem> parents = new ArrayList<>();
    private AllegroItem czesciSamochodowe = new AllegroItem();
    private AllegroItem czesciSamochodoweClipboard = new AllegroItem();
    private int flag = 0;

    public TreeOperations() {
        Parser parser = new Parser();
        allegroList = parser.getAllegroList();
        findCzesciSamochodowePosition();
    }

    public ArrayList<AllegroItem> getParents() {
        return parents;
    }

    public AllegroItem getCzesciSamochodowe() {
        return czesciSamochodowe;
    }


    public void printWholeTree() {
        printWholeTreeRecurency(0, czesciSamochodowe);
    }

    public void setSearchedPhrase(String phrase) {
        int parentId = findPhrase(phrase);
        if (parentId != 0) {
//            logger.info("Znaleziono szukaną kategorię");


            this.parents = saveParent(parentId, this.parents);
        } else {
//            logger.info("Nie znaleziono podanej kategorii");
            System.out.println("Nie znaleziono kategorii!");
        }
    }

    private void printWholeTreeRecurency(int stars, AllegroItem czesciSamochodowe) {
        stars++;
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            for (int i = 0; i < stars; i++) {
                System.out.print("*");
            }
            System.out.println(item.getName());
            printWholeTreeRecurency(stars, item);
        }
    }

    private void findCzesciSamochodowePosition() {
        for (int i = 0; i < allegroList.size(); i++) { //find collection position of category "Części Samochodowe"
            if (allegroList.get(i).getId() == czesciSamochodoweId) {
                czesciSamochodowePosition = i;
                break;
            }
        }
        czesciSamochodowe = allegroList.get(czesciSamochodowePosition);
        czesciSamochodowe.setChildren(allegroList);
        czesciSamochodoweClipboard = czesciSamochodowe; // method findPhrase overwrites czesciSamochodowe object so we have to be able to recover it

    }

    private ArrayList<AllegroItem> saveParent(int parentId, ArrayList<AllegroItem> parentList) {
        for (AllegroItem item : allegroList) {
            if (item.getId() == parentId) {
                parentList.add(item);
                saveParent(item.getParent(), parentList);
                break;
            }
        }

        return parentList;
    }


    public int findPhrase(String phrase) {   //returns ID of searched category
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            if (item.getName().equals(phrase)) {
                phraseId = item.getId();
                flag++;
                break;
            } else {
                this.czesciSamochodowe = item;
                findPhrase(phrase);
            }
        }

        czesciSamochodowe = czesciSamochodoweClipboard;

        return phraseId;
    }
}





