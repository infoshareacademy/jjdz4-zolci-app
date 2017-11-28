package pl.isa.autoparts.categories;

import java.util.ArrayList;

public class TreeOperations {
    //    private static final Logger logger = Logger.getLogger(TreeOperations.class.getName());
    private int czesciSamochodowePosition = 0;

    public int getPhraseId() {
        return phraseId;
    }

    private int phraseId;
    private int parentId;
    private ArrayList<AllegroItem> allegroList = new ArrayList<>();
    private ArrayList<AllegroItem> parents = new ArrayList<>();
    private AllegroItem czesciSamochodowe = new AllegroItem();
    private AllegroItem czesciSamochodoweClipboard = new AllegroItem();

    public TreeOperations() {
        Parser parser = new Parser();
        allegroList = parser.getAllegroList();
        findCzesciSamochodowePosition();

    }

    public ArrayList<AllegroItem> getParents() {
        return parents;
    }

    public void resetPhraseId() {
        phraseId = 0;
        parentId = 0;
    }

    public void printWholeTree() {
        printWholeTreeRecurency(-1, czesciSamochodowe);
    }

    public void setSearchedPhrase(String phrase) {
        parents.clear();
        parentId = findPhrase(phrase.toLowerCase());

        if (parentId != 0) {
//            logger.info("Znaleziono szukaną kategorię");


            saveParent(parentId);
        } else {

//            logger.info("Nie znaleziono podanej kategorii");
            System.out.println("Nie znaleziono kategorii!");
        }
    }

    public void printParents() {
        int i = 0;
        for (int n = parents.size() - 1; n >= 0; n--) {
            for (int d = 0; d < i; d++) {
                System.out.print("   ");
            }
            i++;
            System.out.println(parents.get(n).getName().substring(0, 1).toUpperCase() + parents.get(n).getName().substring(1).toLowerCase());

        }
        parents.clear();
        phraseId = 0;
        parentId = 0;
    }

    private void printWholeTreeRecurency(int stars, AllegroItem czesciSamochodowe) {
        stars++;
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            for (int i = 0; i < stars; i++) {
                System.out.print("  ");
            }
            System.out.println(item.getName().substring(0, 1).toUpperCase() + item.getName().substring(1).toLowerCase());

            printWholeTreeRecurency(stars, item);
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
        czesciSamochodowe.createChildrenList(allegroList);
        czesciSamochodoweClipboard = czesciSamochodowe; // method findPhrase overwrites czesciSamochodowe object so we have to be able to recover it

    }

    private void saveParent(int parentId) {
        for (AllegroItem item : allegroList) {
            if (item.getId() == parentId) {
                parents.add(item);
                saveParent(item.getParent());
                break;
            }
        }

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





