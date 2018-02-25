package pl.isa.raportmodule.domain;

import javax.persistence.*;

@Entity
@NamedQuery(name = "update", query = "UPDATE AdminPreferences SET preferences=:preferences WHERE clientKey=:clientKey")
public class AdminPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientKey;
    private String preferences;


    public Long getId() {
        return id;
    }

    public String getPreferences() {

        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getClientKey() {
        return clientKey;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
