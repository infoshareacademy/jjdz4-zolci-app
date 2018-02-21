package pl.isa.raportmodule.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminPreferences {
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public String getPreferences() {

        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    //    private Boolean login;
//    private Boolean register;
//    private Boolean carsDisplay;
//    private Boolean linkGeneration;
//    private Boolean carDatabase;
    String preferences;
}
