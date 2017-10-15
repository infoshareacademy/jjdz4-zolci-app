package pl.isa.autoparts.aztec;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AztecData {

    @JsonProperty("Rodzaj_pojazdu")
    private String vehicleType;

    @JsonProperty("Dopuszczalna_ladownosc")
    private String vehicleLoadc;

    @JsonProperty("AztecSession")
    private String aztecSession;

    @JsonProperty("Podrodzaj_pojazdu_kod_ITS")
    private String vehicleSubtypeITSCode;

    @JsonProperty("C.1.1")
    private String field_C11;

    @JsonProperty("Organ_wydajacy1") // TODO refactor
    private String govLine_1;

    @JsonProperty("C.1.3")
    private String field_C13;

    @JsonProperty("C.1.2")
    private String field_C12;

    @JsonProperty("Organ_wydajacy4") // TODO refactor
    private String Organ_wydajacy4;

    @JsonProperty("Organ_wydajacy2") // TODO refactor
    private String Organ_wydajacy2;

    @JsonProperty("Organ_wydajacy3") // TODO refactor
    private String Organ_wydajacy3;

    @JsonProperty("Przeznaczenie_pojazdu_kod_ITS") //TODO refactor
    private String vehiclePurposeITSCode;

    @JsonProperty("C.2.2")
    private String field_C22;

    @JsonProperty("C.2.1")
    private String field_C21;

    @JsonProperty("C.2.3")
    private String field_C23;

    @JsonProperty("ErrorText")
    private String errorText;

    @JsonProperty("Przeznaczenie")
    private String vehiclePurpose; //TODO refactor

    @JsonProperty("Rodzaj_pojazdu_kod_ITS")
    private String vehicleTypeITSCode;

    @JsonProperty("E")
    private String field_E;

    @JsonProperty("P.3")
    private String field_P3;

    @JsonProperty("P.2")
    private String field_P2;

    @JsonProperty("G")
    private String field_G;

    @JsonProperty("P.1")
    private String field_P1;

    @JsonProperty("A")
    private String field_A;

    @JsonProperty("B")
    private String field_B;

    @JsonProperty("L")
    private String field_L;

    @JsonProperty("F.1")
    private String field_F1;

    @JsonProperty("F.2")
    private String field_F2;

    @JsonProperty("F.3")
    private String field_F3;

    @JsonProperty("H")
    private String field_H;

    @JsonProperty("I")
    private String field_I;

    @JsonProperty("Identyfikator_ITS")
    private String itsID;

    @JsonProperty("J")
    private String field_J;

    @JsonProperty("K")
    private String field_K;

    @JsonProperty("Q")
    private String field_Q;

    @JsonProperty("Numer_karty_pojazdu")
    private String vehicleCardNumber; //TODO refactor

    @JsonProperty("D5")
    private String field_D5;

    @JsonProperty("D4")
    private String field_D4;

    @JsonProperty("Numer_DR")
    private String drNumber;

    @JsonProperty("S.2")
    private String field_S2;

    @JsonProperty("Dopuszczalny_nacisk_na_os")
    private String Dopuszczalny_nacisk_na_os;

    @JsonProperty("S.1")
    private String S.1;

    @JsonProperty("Error")
    private String Error;

    @JsonProperty("Rok_produkcji")
    private String Rok_produkcji;

    @JsonProperty("O.1")
    private String O.1;

    @JsonProperty("D2")
    private String D2;

    @JsonProperty("O.2")
    private String O.2;

    @JsonProperty("D3")
    private String D3;

    @JsonProperty("D1")
    private String D1;

}
