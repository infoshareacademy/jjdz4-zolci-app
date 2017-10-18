package pl.isa.autoparts.aztec;

public class AztecPrinter {

    private static final String NORMAL = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";


    public static void println(String text) {

        System.out.println(YELLOW + text + NORMAL);
    }


    private static void printItem(String itemName, String itemValue) {

        System.out.println(YELLOW + itemName + ": "
                + RED + itemValue + NORMAL);
    }

    private static void printItem(String itemName, long itemValue) {

        System.out.println(YELLOW + itemName + ": "
                + RED + itemValue + NORMAL);
    }

    public static void printAztecVehicleData(AztecVehicle aztec) {

        printItem("Numer dowodu rejestracyjnego",
                aztec.getAztecData().getRegistryCardNumber());

        printItem("Rodzaj pojazdu",
                aztec.getAztecData().getVehicleType());

        printItem("Przeznaczenie pojazdu",
                aztec.getAztecData().getVehiclePurpose());

        printItem("Rok produkcji",
                aztec.getAztecData().getProductionYear());

        printItem("Dopuszczalna ładowność",
                aztec.getAztecData().getMaxVehicleLoad());

        printItem("Dopuszczalny nacisk na oś",
                aztec.getAztecData().getMaxAxisLoad());

        printItem("C.1.1 Nazwa posiadacza dowodu",
                aztec.getAztecData().getRegistyOwnersNameField_C11());

        printItem("C.1.2 Numer PESEL lub REGON",
                aztec.getAztecData().getRegistryOwnersPeselRegonField_C12());

        printItem("C.1.3 Adres posiadacza dowodu",
                aztec.getAztecData().getRegistryOwnersAddressField_C13());
    }
}
