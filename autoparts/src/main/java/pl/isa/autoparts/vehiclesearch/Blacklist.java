package pl.isa.autoparts.vehiclesearch;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blacklist {

    private static final String FILE_NAME="VehicleMakesBlacklist";

    private Blacklist() {}

    public static List<String> read() throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream file = classLoader.getResourceAsStream(FILE_NAME);
        if (file == null) throw new IOException();

        Scanner s = new Scanner(file);
        List<String> blacklist = new ArrayList<>();
        while (s.hasNext()){
            blacklist.add(s.next());
        }
        s.close();

        return blacklist;
    }
}
