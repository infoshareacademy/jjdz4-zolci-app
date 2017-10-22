package pl.isa.autoparts.aztec;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AztecData {

    @JsonProperty("Error")
    private int error;

    @JsonProperty("ErrorText")
    private String errorText;

    @JsonProperty("AztecSession")
    private String aztecSession;

    @JsonProperty("Numer_DR")
    private String registryCardNumber;

    @JsonProperty("Rodzaj_pojazdu")
    private String vehicleType;

    @JsonProperty("Przeznaczenie")
    private String vehiclePurpose;

    @JsonProperty("Rok_produkcji")
    private String productionYear;

    @JsonProperty("Dopuszczalna_ladownosc")
    private String maxVehicleLoad;

    @JsonProperty("Dopuszczalny_nacisk_na_os")
    private String maxAxisLoad;

    @JsonProperty("Numer_karty_pojazdu")
    private String vehicleCardNumber;

    @JsonProperty("C.1.1")
    private String registyOwnersNameField_C11;

    @JsonProperty("C.1.2")
    private long registryOwnersPeselRegonField_C12;

    @JsonProperty("C.1.3")
    private String registryOwnersAddressField_C13;

    @JsonProperty("C.2.1")
    private String vehicleOwnersNameField_C21;

    @JsonProperty("C.2.2")
    private long vehicleOwnersPeselRegonField_C22;

    @JsonProperty("C.2.3")
    private String vehicleOwnersAddressField_C23;

    @JsonProperty("F.1")
    private String maxVehicleMassWithoutMotorbikesField_F1;

    @JsonProperty("F.2")
    private String maxVehicleMassField_F2;

    @JsonProperty("F.3")
    private String maxVehicleAssemblyMassField_F3;

    @JsonProperty("G")
    private String vehicleMassField_G;

    @JsonProperty("J")
    private String vehicleCategoryField_J;

    @JsonProperty("K")
    private String certificateOfConformityNumberField_K;

    @JsonProperty("L")
    private int numberOfAxlesField_L;

    @JsonProperty("O.1")
    private String maxTrailerWithBrakesLoadField_O1;

    @JsonProperty("O.2")
    private String maxTrailerLoadField_O2;

    @JsonProperty("P.1")
    private String cylinderCapacityField_P1;

    @JsonProperty("P.2")
    private String maxNetEnginePowerField_P2;

    @JsonProperty("P.3")
    private String fuelTypeField_P3;

    @JsonProperty("Q")
    private String powerToMassRatioField_Q;

    @JsonProperty("S.1")
    private int seatsNumberField_S1;

    @JsonProperty("S.2")
    private String standingPlacesNumberField_S2;

    @JsonProperty("Organ_wydajacy1")
    private String issuingAuthorityLine1;

    @JsonProperty("Organ_wydajacy2")
    private String issuingAuthorityLine2;

    @JsonProperty("Organ_wydajacy3")
    private String issuingAuthorityLine3;

    @JsonProperty("Organ_wydajacy4")
    private String issuingAuthorityLine4;

    @JsonProperty("A")
    private String registryNumberField_A;

    @JsonProperty("D1")
    private String vehicleMakeField_D1;

    @JsonProperty("D2")
    private String vehicleTypeField_D2;

    @JsonProperty("D3")
    private String vehicleVariantField_D3;

    @JsonProperty("D4")
    private String vehicleVersionField_D4;

    @JsonProperty("D5")
    private String vehicleModelField_D5;

    @JsonProperty("E")
    private String vehicleIdentificationNumberField_E;

    @JsonProperty("B")
    private String firstRegistryDateField_B;

    @JsonProperty("I")
    private String registryReleaseDateField_I;

    @JsonProperty("H")
    private String registryExpireDateField_H;

    @JsonProperty("Identyfikator_ITS")
    private long itsIdentification;

    @JsonProperty("Rodzaj_pojazdu_kod_ITS")
    private int vehicleTypeITSCode;

    @JsonProperty("Podrodzaj_pojazdu_kod_ITS")
    private int vehicleSubtypeITSCode;

    @JsonProperty("Przeznaczenie_pojazdu_kod_ITS")
    private int vehiclePurposeITSCode;


    public int getError() {
        return error;
    }

    public String getErrorText() {
        return errorText;
    }

    public String getAztecSession() {
        return aztecSession;
    }

    public String getRegistryCardNumber() {
        return registryCardNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehiclePurpose() {
        return vehiclePurpose;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getMaxVehicleLoad() {
        return maxVehicleLoad;
    }

    public String getMaxAxisLoad() {
        return maxAxisLoad;
    }

    public String getVehicleCardNumber() {
        return vehicleCardNumber;
    }

    public String getRegistyOwnersNameField_C11() {
        return registyOwnersNameField_C11;
    }

    public long getRegistryOwnersPeselRegonField_C12() {
        return registryOwnersPeselRegonField_C12;
    }

    public String getRegistryOwnersAddressField_C13() {
        return registryOwnersAddressField_C13;
    }

    public String getVehicleOwnersNameField_C21() {
        return vehicleOwnersNameField_C21;
    }

    public long getVehicleOwnersPeselRegonField_C22() {
        return vehicleOwnersPeselRegonField_C22;
    }

    public String getVehicleOwnersAddressField_C23() {
        return vehicleOwnersAddressField_C23;
    }

    public String getMaxVehicleMassWithoutMotorbikesField_F1() {
        return maxVehicleMassWithoutMotorbikesField_F1;
    }

    public String getMaxVehicleMassField_F2() {
        return maxVehicleMassField_F2;
    }

    public String getMaxVehicleAssemblyMassField_F3() {
        return maxVehicleAssemblyMassField_F3;
    }

    public String getVehicleMassField_G() {
        return vehicleMassField_G;
    }

    public String getVehicleCategoryField_J() {
        return vehicleCategoryField_J;
    }

    public String getCertificateOfConformityNumberField_K() {
        return certificateOfConformityNumberField_K;
    }

    public int getNumberOfAxlesField_L() {
        return numberOfAxlesField_L;
    }

    public String getMaxTrailerWithBrakesLoadField_O1() {
        return maxTrailerWithBrakesLoadField_O1;
    }

    public String getMaxTrailerLoadField_O2() {
        return maxTrailerLoadField_O2;
    }

    public String getCylinderCapacityField_P1() {
        return cylinderCapacityField_P1;
    }

    public String getMaxNetEnginePowerField_P2() {
        return maxNetEnginePowerField_P2;
    }

    public String getFuelTypeField_P3() {
        return fuelTypeField_P3;
    }

    public String getPowerToMassRatioField_Q() {
        return powerToMassRatioField_Q;
    }

    public int getSeatsNumberField_S1() {
        return seatsNumberField_S1;
    }

    public String getStandingPlacesNumberField_S2() {
        return standingPlacesNumberField_S2;
    }

    public String getIssuingAuthorityLine1() {
        return issuingAuthorityLine1;
    }

    public String getIssuingAuthorityLine2() {
        return issuingAuthorityLine2;
    }

    public String getIssuingAuthorityLine3() {
        return issuingAuthorityLine3;
    }

    public String getIssuingAuthorityLine4() {
        return issuingAuthorityLine4;
    }

    public String getRegistryNumberField_A() {
        return registryNumberField_A;
    }

    public String getVehicleMakeField_D1() {
        return vehicleMakeField_D1;
    }

    public String getVehicleTypeField_D2() {
        return vehicleTypeField_D2;
    }

    public String getVehicleVariantField_D3() {
        return vehicleVariantField_D3;
    }

    public String getVehicleVersionField_D4() {
        return vehicleVersionField_D4;
    }

    public String getVehicleModelField_D5() {
        return vehicleModelField_D5;
    }

    public String getVehicleIdentificationNumberField_E() {
        return vehicleIdentificationNumberField_E;
    }

    public String getFirstRegistryDateField_B() {
        return firstRegistryDateField_B;
    }

    public String getRegistryReleaseDateField_I() {
        return registryReleaseDateField_I;
    }

    public String getRegistryExpireDateField_H() {
        return registryExpireDateField_H;
    }

    public long getItsIdentification() {
        return itsIdentification;
    }

    public int getVehicleTypeITSCode() {
        return vehicleTypeITSCode;
    }

    public int getVehicleSubtypeITSCode() {
        return vehicleSubtypeITSCode;
    }

    public int getVehiclePurposeITSCode() {
        return vehiclePurposeITSCode;
    }
}
