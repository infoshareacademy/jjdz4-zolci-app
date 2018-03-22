package pl.isa.autoparts.vehiclesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BlacklistCreator {

    private static final Logger LOG = LoggerFactory.getLogger(BlacklistCreator.class.getName());
    private static final String FILE_NAME = "VehicleMakesBlacklist";

    public static void main(String[] args) {

        LOG.info("Executing vehicle blacklist creator.");
        LOG.info("May take sooooooome time...");

        Set<String> blacklist = new TreeSet<>(Arrays.asList("AR, BDR, CDR"));

        try {
            blacklist = searchForEmptyMakes(getMakesApis());
        } catch (IOException e) {
            LOG.error("Data parsing was unsuccessful");
        }

        Optional<Set<String>> black = Optional.ofNullable(blacklist);
        if (black.isPresent()) {

            try {
                fileWrite(black.get());
            } catch (IOException e) {
                LOG.error("Could not write to file");
            }
        }
    }

    public static Set<String> read() throws IOException, ClassNotFoundException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fis = classLoader.getResourceAsStream(FILE_NAME);
        if (fis == null) throw new IOException();

        Set<String> blacklist;
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            blacklist = (Set<String>) ois.readObject();
            ois.close();
        }

        return blacklist;
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

        Set<String> blacklist = new TreeSet<>();
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

    private static void fileWrite(Set<String> blacklist) throws IOException {

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(blacklist);
            oos.close();
        }
    }
}
