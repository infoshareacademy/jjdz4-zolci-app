package pl.isa.autoparts.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class BlacklistCreator {

    private static final Logger LOG = LoggerFactory.getLogger(BlacklistCreator.class.getName());

    public static void main(String[] args) {

        LOG.info("Executing vehicle blacklist creator...");

        Set<String> blacklist;
        try {
            blacklist = searchForEmptyMakes(getMakesApis());
        } catch (IOException e) {
            LOG.error("Data parsing was unsuccessful");
        }
    }

    private static Map<String,String> getMakesApis() {

        Vehicle vehicle = null;
        try {
            vehicle = VehicleSearch.getVehicleFromApi("/api/v2");
        } catch (IOException e) {
            LOG.error("Data parsing was unsuccessful");
        }

        Map<String, String> makesApis = new TreeMap<>();
        for (VehicleData vd : vehicle.getData()) {
            makesApis.put(vd.getName(),vd.getLink());
        }

        return makesApis;
    }

    private static Set<String> searchForEmptyMakes(Map<String,String> makesApis) throws IOException {

        Set<String> blacklist = null;
        for (Map.Entry<String,String> ma : makesApis.entrySet()) {
            Vehicle vehicleModelLevel;
            vehicleModelLevel = VehicleSearch.getVehicleFromApi(ma.getValue());

            LOG.info("Search in make: {}", ma.getKey());

            if (!hasName(vehicleModelLevel)) {
                blacklist.add(ma.getKey());
                LOG.warn("Found empty make: {}", ma.getKey());
            }
        }

        return blacklist;
    }

    private static boolean hasName(Vehicle vehicle) throws IOException {

        if (vehicle.getData().length == 0) {
            return false;
        }

        for (VehicleData vd : vehicle.getData()) {
            LOG.info("\tModel: {}", vd.getName());

            Vehicle vehicleEngineLevel = VehicleSearch.getVehicleFromApi(vd.getLink());
            if (vehicleEngineLevel.getData().length == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isEmptyOrNull(String name) {
        return name.isEmpty() || name == null;
    }
}
