package pl.isa.autoparts.tools;

public abstract class Printer {

    public static final String NORMAL = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";

    public static void println(String text) {

        System.out.println(BLUE + text + NORMAL);
    }

    public static void printError(String text) {

        System.out.println(RED + "Błąd: " + text + NORMAL);
    }
}
