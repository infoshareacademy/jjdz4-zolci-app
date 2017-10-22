package pl.isa.autoparts.categories;

import java.util.ArrayList;

public class TreeOperations {

    static int czesciSamochodoweId = 620;
    private int czesciSamochodowePosition = 0;
    private String phrase;
    private int phraseId;
    private ArrayList<AllegroItem> allegroList;

    private AllegroItem czesciSamochodowe = new AllegroItem();
    private AllegroItem czesciSamochodoweClipboard = new AllegroItem();
    public AllegroItem getCzesciSamochodowe() {
        return czesciSamochodowe;
    }

    public TreeOperations(ArrayList<AllegroItem> allegroList){
        this.allegroList = allegroList;
        findCzesciSamochodowePosition();
    }

    public void findCzesciSamochodowePosition() {
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

    public void printWholeTree(int stars, AllegroItem czesciSamochodowe) {
        stars++;
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            for (int i = 0; i < stars; i++) {
                System.out.print("*");
            }
            System.out.println(item.getName());
            printWholeTree(stars, item);
        }
    }

    public void setSearchedPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int findPhrase() {   //returns ID of searched category
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            if (item.getName().equals(phrase)) {
                phraseId = item.getId();
                break;
            } else {
                this.czesciSamochodowe = item;
                findPhrase();
            }
        }
        czesciSamochodowe = czesciSamochodoweClipboard;
        return phraseId;
    }

    public void printParent(ArrayList<AllegroItem> allegroList, int parentId) { //prints parents by giving to a a method id of first parent
        for (AllegroItem item : allegroList) {
            if (item.getId() == parentId) {
                System.out.println(item.getName());
                printParent(allegroList, item.getParent());
                break;
            }
        }
    }
    public ArrayList<AllegroItem> saveParent(int parentId, ArrayList<AllegroItem> parentList) {
        for (AllegroItem item : allegroList) {
            if (item.getId() == parentId) {
                parentList.add(item);
                saveParent(item.getParent(), parentList);
                break;
            }
        }
        return parentList;
    }
}




