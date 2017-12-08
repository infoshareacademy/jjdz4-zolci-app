package pl.isa.autoparts.tools;

public abstract class Printer {

    protected static final String NORMAL = "\u001B[0m";
    protected static final String YELLOW = "\u001B[33m";
    protected static final String BLUE = "\u001B[34m";
    protected static final String RED = "\u001B[31m";

    public static void println(String text) {

        System.out.println(BLUE + text + NORMAL);
    }

    public static void printError(String text) {

        System.out.println(RED + "Błąd: " + text + NORMAL);
    }

    public static void printInputRequest(String text) {

        System.out.print(YELLOW + '\n' + text + ": " + NORMAL);
    }
}
