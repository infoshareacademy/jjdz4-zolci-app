package pl.isa.categories;

public class TreeOperations {

    private String phrase;
    private int phraseId;
    private AllegroItem czesciSamochodowe = new AllegroItem();

    TreeOperations(AllegroItem allegroItem) {
        this.czesciSamochodowe = allegroItem;
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

    public void searchedPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int findPhrase(AllegroItem czesciSamochodowe) {
        for (AllegroItem item : czesciSamochodowe.getChildren()) {
            if (item.getName().equals(phrase)) {
               phraseId = item.getId();
               break;
            } else {
                findPhrase(item);
            }
        }

        return phraseId;
    }
}




