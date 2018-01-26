package pl.isa.autoparts.vehiclesearch;

import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autoparts.tools.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleSearch {

    private static final String API_URL_PRE = "http://infoshareacademycom.2find.ru";
    private static final String API_URL_POST = "?lang=polish";

    private Vehicle foundVehicle;
    private String link;

    public Vehicle getFoundVehicle() {
        return foundVehicle;
    }

    public List<VehicleData> findVehicleModels(String brandName, String modelName, String productionYear) throws IOException {

        return findBrandNameAndModel(brandName, modelName, productionYear);
    }

    public List<VehicleData> foundVehicles(String modelName, String cylinderVolume
    ) {
        return findProductionYearAndCylinderVolume(modelName, cylinderVolume);
    }

    private Vehicle parseFoundVehicle() throws IOException {

        return JsonParser.parseJsonFromURL(
                API_URL_PRE + link + API_URL_POST, Vehicle.class);
    }

    private List<VehicleData> findBrandNameAndModel(String brandName, String modelName, String productionYear) throws IOException {

        List<VehicleData> modelList = new ArrayList<>();

        for (VehicleData data : parseFoundVehicle().getData()) {
            if (data.getName().contains(brandName.toUpperCase())) {
                link = data.getLink();

                modelList.add(data);
            }
        }

        for (VehicleData data : modelList) {


            boolean isMatch = data.getName().toUpperCase()
                    .contains(modelName.toUpperCase()) && matchYear(data, productionYear);
            if (isMatch) {
                modelList.add(data);
            }
        }

        return modelList;
    }

    private boolean matchYear(VehicleData data, String productionYear) {

        Integer startYear;
        Integer endYear;
        Integer year;

        if (data.getStart_year() == null) return false;
        else startYear = Integer.parseInt(data.getStart_year());

        if (productionYear == null) return false;
        else year = Integer.parseInt(productionYear);

        if (data.getEnd_year() == null) endYear = year;
        else endYear = Integer.parseInt(data.getEnd_year());

        return (startYear <= year && endYear >= year);
    }

    private List<VehicleData> findProductionYearAndCylinderVolume(String modelName, String cylinderVolume) {

        VehicleData vehicleData = null;

        if (foundVehicle != null) {

            for (VehicleData data : foundVehicle.getData()) {

                if (data.getName().toUpperCase()
                        .contains(modelName.toUpperCase()))
                    vehicleData = data;
            }

            if (vehicleData != null) {
                link = vehicleData.getLink();
            }
        }

        try {
            foundVehicle = parseFoundVehicle();
        } catch (IOException e) {
            Printer.printError("Błąd parsowania znalezionego modelu");
        }

        List<VehicleData> vehicleDataList = new ArrayList<>();

        if (foundVehicle != null) {
            for (VehicleData data : foundVehicle.getData()) {

                if (data.getName().toUpperCase()
                        .contains(cylinderVolume.toUpperCase()))
                    vehicleDataList.add(data);
            }
        }

        return vehicleDataList;
    }
}
