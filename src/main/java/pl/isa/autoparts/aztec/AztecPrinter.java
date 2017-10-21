package pl.isa.autoparts.aztec;

public class AztecPrinter {

    private static final String NORMAL = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";


    public static void println(String text) {

        System.out.println(BLUE + text + NORMAL);
    }

    public static void printError(AztecVehicle aztec) {

        System.out.println(String.format("%sBłąd [%d]: %s%s",
                RED, aztec.getAztecData().getError(),
                aztec.getAztecData().getErrorText(), NORMAL));
    }


    private static void printItem(String itemName, String itemValue) {

        if (itemValue != null)
            System.out.println(YELLOW + itemName + ": "
                    + RED + itemValue + NORMAL);
    }

    private static void printItem(String itemName, long itemValue) {

        if (itemValue != 0)
            System.out.println(YELLOW + itemName + ": "
                    + RED + itemValue + NORMAL);
    }

    private static void printItem(String itemName, int itemValue) {

        if (itemValue != 0)
            System.out.println(YELLOW + itemName + ": "
                    + RED + itemValue + NORMAL);
    }

    private static void printItem(String itemName, int itemValue, boolean zeroIsAllowed) {

        if ((itemValue != 0 || zeroIsAllowed))
            System.out.println(YELLOW + itemName + ": "
                    + RED + itemValue + NORMAL);
    }

    private static boolean itsIdentificationExtist(long itsIdentification) {

        if (itsIdentification > 0) return true;

        return false;
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

        printItem("C.2.1 Nazwa posiadacza dowodu",
                aztec.getAztecData().getVehicleOwnersNameField_C21());

        printItem("C.2.2 Numer PESEL lub REGON",
                aztec.getAztecData().getVehicleOwnersPeselRegonField_C22());

        printItem("C.2.3 Adres posiadacza dowodu",
                aztec.getAztecData().getVehicleOwnersAddressField_C23());

        printItem("F.1 Dopuszczalna masa całkowita\n    z wyłączeniem motocykli i motorowerów",
                aztec.getAztecData().getMaxVehicleMassWithoutMotorbikesField_F1());

        printItem("F.2 Dopuszczalna masa całkowita",
                aztec.getAztecData().getMaxVehicleMassField_F2());

        printItem("F.3 Dopuszczalna masa całkowita\n    zespołu pojazdów",
                aztec.getAztecData().getMaxVehicleAssemblyMassField_F3());

        printItem("G. Masa własna pojazdu",
                aztec.getAztecData().getVehicleMassField_G());

        printItem("J. Kategoria pojazdu",
                aztec.getAztecData().getVehicleCategoryField_J());

        printItem("K. Numer świadectwa homologacji",
                aztec.getAztecData().getCertificateOfConformityNumberField_K());

        printItem("L. Liczba osi",
                aztec.getAztecData().getNumberOfAxlesField_L());

        printItem("O.1 Maksymalna masa całkowita\n    przyczepy z hamulcem",
                aztec.getAztecData().getMaxTrailerWithBrakesLoadField_O1());

        printItem("O.2 Maksymalna masa całkowita\n    przyczepy bez hamulca",
                aztec.getAztecData().getMaxTrailerLoadField_O2());

        printItem("P.1 Pojemność silnika",
                aztec.getAztecData().getCylinderCapacityField_P1());

        printItem("P.2 Maksymalna moc netto silnika",
                aztec.getAztecData().getMaxNetEnginePowerField_P2());

        printItem("P.3 Rodzaj paliwa",
                aztec.getAztecData().getFuelTypeField_P3());

        printItem("Q. Stosunek mocy do masy własnej\n   dotyczy motocykli i motorowerów",
                aztec.getAztecData().getPowerToMassRatioField_Q());

        printItem("S.1 Liczba miejsc siedzących",
                aztec.getAztecData().getSeatsNumberField_S1());

        printItem("S.2 Liczba miejsc stojących",
                aztec.getAztecData().getStandingPlacesNumberField_S2());

        printItem("1. Organ wydający",
                aztec.getAztecData().getIssuingAuthorityLine1());

        printItem("2. Organ wydający",
                aztec.getAztecData().getIssuingAuthorityLine2());

        printItem("3. Organ wydający",
                aztec.getAztecData().getIssuingAuthorityLine3());

        printItem("4. Organ wydający",
                aztec.getAztecData().getIssuingAuthorityLine4());

        printItem("A. Numer rejestracyjny pojazdu",
                aztec.getAztecData().getRegistryNumberField_A());

        printItem("D1 Marka pojazdu",
                aztec.getAztecData().getVehicleMakeField_D1());

        printItem("D2 Typ pojazdu",
                aztec.getAztecData().getVehicleTypeField_D2());

        printItem("D3 Wariant",
                aztec.getAztecData().getVehicleVariantField_D3());

        printItem("D4 Wersja",
                aztec.getAztecData().getVehicleVersionField_D4());

        printItem("D5 Model",
                aztec.getAztecData().getVehicleModelField_D5());

        printItem("E. Numer VIN",
                aztec.getAztecData().getVehicleIdentificationNumberField_E());

        printItem("B. Data pierwszej rejestracji pojazdu",
                aztec.getAztecData().getFirstRegistryDateField_B());

        printItem("I. Data wydania dowodu rejestracynego",
                aztec.getAztecData().getRegistryReleaseDateField_I());

        printItem("H. Okres ważności dowodu",
                aztec.getAztecData().getRegistryExpireDateField_H());


        long its = aztec.getAztecData().getItsIdentification();
        printItem("Identyfikator ITS", its);

        if (itsIdentificationExtist(its)) {

            printItem("ITS rodzaju pojazdu",
                    aztec.getAztecData().getVehicleTypeITSCode(), true);

            printItem("ITS podrodzaju pojazdu",
                    aztec.getAztecData().getVehicleSubtypeITSCode(), true);

            printItem("ITS przeznaczenia pojazdu",
                    aztec.getAztecData().getVehiclePurposeITSCode(), true);
        }
    }
}
