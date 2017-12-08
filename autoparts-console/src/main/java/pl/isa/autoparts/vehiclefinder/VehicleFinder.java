package pl.isa.autoparts.vehiclefinder;

import pl.isa.autoparts.tools.JsonParser;
import pl.isa.autoparts.tools.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleFinder {

    public static final String VEHICLE_DB_URL = "http://infoshareacademycom.2find.ru/api/v2?lang=polish";
    private static final String VEHICLE_DB_URL_PRE = "http://infoshareacademycom.2find.ru";
    private final String VEHICLE_DB_URL_POST = "?lang=polish";

    private Vehicle vehicle;
    private Vehicle foundVehicle;
    private String link;

    public boolean hasError;
    public String errorMessage;

    public VehicleFinder(Vehicle vehicle) {

        this.vehicle = vehicle;
    }

    public Vehicle getFoundVehicle() {
        return foundVehicle;
    }

    private Vehicle parseFoundVehicle() throws IOException {

        return JsonParser.parseJsonFromURL(
                VEHICLE_DB_URL_PRE + link + VEHICLE_DB_URL_POST, Vehicle.class);
    }

    private void setSearchError(String text) {

        foundVehicle = null;
        if (!hasError) hasError = true;
        errorMessage += '\n' + text;
    }

    private List<VehicleData> findBrandNameAndModel(String brandName, String modelName, String productionYear) {

        for (VehicleData data : vehicle.getData()) {

            if (data.getName().contains(brandName.toUpperCase())) {

                link = data.getLink();

                try {
                    foundVehicle = parseFoundVehicle();
                } catch (IOException e) {
                    setSearchError("Nie znaleziono marki pojazdu");
                    e.printStackTrace();
                }

                break;
            }
        }

        List<VehicleData> modelList = new ArrayList<>();

        if (foundVehicle != null) {
            for (VehicleData data : foundVehicle.getData()) {

                if (data.getName().toUpperCase()
                        .contains(modelName.toUpperCase())) {

                    if (matchYear(data, productionYear))
                        modelList.add(data);
                }
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

        if (startYear <= year && endYear >= year) {
            return true;
        }

        return false;
    }

    private List<VehicleData> findProductionYearAndCylinderVolume(String modelName, String cylinderVolume) {

        VehicleData vehicleData = null;

        if (foundVehicle != null) {

            for (VehicleData data : foundVehicle.getData()) {

                if (data.getName().toUpperCase()
                        .contains(modelName.toUpperCase()))
                    vehicleData = data;
            }

            link = vehicleData.getLink();
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

    public List<VehicleData> findVehicleModels(String brandName, String modelName, String productionYear) {

        return findBrandNameAndModel(brandName, modelName, productionYear);
    }

    public List<VehicleData> foundVehicles(String modelName, String cylinderVolume
    ) {
        return findProductionYearAndCylinderVolume(modelName, cylinderVolume);
    }
}
