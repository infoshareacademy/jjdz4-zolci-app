package pl.isa.autoparts.categories;

import java.util.ArrayList;

public class TreeOperations {

    static int czesciSamochodoweId = 620;
    private int czesciSamochodowePosition = 0;
    private int phraseId;
    private ArrayList<AllegroItem> allegroList;
    private ArrayList<AllegroItem> parents = new ArrayList<>();
    private AllegroItem czesciSamochodowe = new AllegroItem();
    private AllegroItem czesciSamochodoweClipboard = new AllegroItem();


    public ArrayList<AllegroItem> getParents() {
        return parents;
    }

    public AllegroItem getCzesciSamochodowe() {
        return czesciSamochodowe;
    }


    public TreeOperations(ArrayList<AllegroItem> allegroList) {
        this.allegroList = allegroList;
        findCzesciSamochodowePosition();
    }

    public void printWholeTree() {
        printWholeTreeRecurency(0, czesciSamochodowe);
    }

    public void setSearchedPhrase(String phrase) {
        this.parents = saveParent(findPhrase(phrase), this.parents);
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


    private int findPhrase(String phrase) {   //returns ID of searched category
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            if (item.getName().equals(phrase)) {
                phraseId = item.getId();
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




