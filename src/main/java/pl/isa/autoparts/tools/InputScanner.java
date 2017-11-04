package pl.isa.autoparts.tools;

import java.util.Scanner;

public class InputScanner {

    public static String scanForStringLine() {

        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextLine()) {
            return scanner.next();
        }

        return "";
    }
}
