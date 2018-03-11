package pl.isa.autopartsJee.carToDatabase.domain;

import javax.persistence.*;

@Entity
public class CarData {


    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long carID;

    @Column
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleVersion;
    private String vehicleVariant;
    private String fuel;
    private String capacity;
    private String power;
    private int prodYear;
    //@Column(unique = true)
    private String vin;
    private String registryNumber;

    public Long getCarID() {
        return carID;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleVersion() {
        return vehicleVersion;
    }

    public String getVehicleVariant() {
        return vehicleVariant;
    }

    public String getFuel() {
        return fuel;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getPower() {
        return power;
    }

    public int getProdYear() {
        return prodYear;
    }

    public String getVin() {
        return vin;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    private Long ownerId;

    public void setCarID(Long carID) {
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
