package pl.isa.autopartsJee.repository;

import javax.persistence.*;

@Entity
public class CarData {


    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    int carID;
    String vehicleMake;
    String vehicleModel;
    String vehicleVersion;
    String vehicleVariant;
    String fuel;
    String capacity;
    String power;
    int prodYear;
    @Column(unique = true)
    String vin;
    String registryNumber;

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleVersion(String vehicleVersion) {
        this.vehicleVersion = vehicleVersion;
    }

    public void setVehicleVariant(String vehicleVariant) {
        this.vehicleVariant = vehicleVariant;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }
}
