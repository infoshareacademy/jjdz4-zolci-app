package pl.isa.autoparts;


import java.io.IOException;
import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) throws IOException {
        TextMenu textMenu = new TextMenu();
        textMenu.options();
        LocalDateTime localDateTime = LocalDateTime.now();
    }
}


