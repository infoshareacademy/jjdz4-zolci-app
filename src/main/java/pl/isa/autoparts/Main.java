package pl.isa.autoparts;



import pl.isa.autoparts.TextMenu;

public class Main {



    public static void main(String[] args) {
        int chosenOption;

        TextMenu textMenu = new TextMenu();
        textMenu.showOptions();

        chosenOption = textMenu.choseOptions();


    }
}

