package pl.isa.autopartsJee.raportModule.domain;

public class AdminPreferences {

    private Integer id;
    String preferences;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getPreferences() {
        return preferences;
    }
}
