package pl.isa.autoparts.vehiclefinder;

import pl.isa.autoparts.tools.Printer;

import java.util.List;

public class VehiclePrinter extends Printer {

    public static void printModels(List<VehicleData> models) {

        System.out.println(BLUE + "Znalezione modele:");

        for (VehicleData data : models) {
            System.out.println(YELLOW + data.getName() + data.getStart_year() + NORMAL);
        }

        printInputRequest("Doprecyzuj wybór modelu");
    }

    public static void printFoundVehicles(VehicleFinder vehicleFinder, List<VehicleData> vehicleData) {

        println("Znalezione auta:\n");

        if (vehicleData == null)
            System.out.println(RED + "(brak)" + NORMAL);

        else {
            for (VehicleData data : vehicleData) {

                System.out.print(YELLOW + '\n' + vehicleFinder.getFoundVehicle().getDataname() + NORMAL);

                System.out.println(RED
                        + "\n\tId: " + data.getId()
                        + "\n\tNazwa silnika: " + data.getName()
                        + "\n\tPojemność [ccm3]: " + data.getCcm()
                        + "\n\tMoc [kw]: " + data.getKw()
                        + "\n\tMoc [hp]: " + data.getHp()
                        + "\n\tIlość cylindrów: " + data.getCylinders()
                        + "\n\tRodzaj paliwa: " + data.getFuel()
                        + "\n\tRodzaj nadwozia: " + data.getBody()
                        + NORMAL
                );
            }
        }
    }
}
