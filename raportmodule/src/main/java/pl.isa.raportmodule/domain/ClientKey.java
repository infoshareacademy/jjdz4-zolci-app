package pl.isa.raportmodule.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientKey {

    @Id
    private Integer id;
    private String clientKey;


    public Integer getId() {
        return id;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }
}
