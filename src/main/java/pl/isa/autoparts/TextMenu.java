package pl.isa.autoparts;

import java.util.Scanner;


public class TextMenu {
    Scanner sc = new Scanner(System.in);
    int input;
    String[] menuOptions = {"Wydrukuj całe drzewo kategorii", "Wydrukuj rodziców szukanej kategorii", "Wybór części na podstawie pytań użytkownika",
            "opcja czwarta", "opcja piąta"};

    public void showOptions() {
        System.out.println("Menu tekstowe: \n");
        for(int i = 0; i < menuOptions.length; i++)
            System.out.println((i + 1) + ". " + menuOptions[i]);

        System.out.print("\n" + "podaj numer opcji: ");
    }

    public int choseOptions() {

        input = sc.nextInt();
        System.out.println("\nwybrano: " + menuOptions[input-1]);
        return input;
    }

}
