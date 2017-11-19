package pl.isa.autoparts;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TextMenu {
    Scanner sc = new Scanner(System.in);
    int input;

    String[] menuOptions = {"Wydrukuj całe drzewo kategorii", "Wydrukuj rodziców szukanej kategorii", "Pobierz dane kodu aztec ze zdjęcia",
            "Wybór części na podstawie serii pytań", "Wyszukiwanie auta na podstawie serii pytań", "Wydrukuj link do Allegro dla szukanej kategorii"};


    public void showOptions() {
        System.out.println("Wyszukiwarka autoczęści: \n");
        for (int i = 0; i < menuOptions.length; i++)
            System.out.println((i + 1) + ". " + menuOptions[i]);

        System.out.print("\n" + "podaj numer opcji: ");
    }

    public int choseOptions() {
        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            return 6;
        }
        try {
            System.out.println("\nwybrano: " + menuOptions[input - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Podaj wartosc w zakresie 1-6!");
        }
        return input;
    }

}
