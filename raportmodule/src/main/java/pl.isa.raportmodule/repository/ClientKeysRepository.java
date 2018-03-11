package pl.isa.raportmodule.repository;

import pl.isa.raportmodule.domain.ClientKey;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class ClientKeysRepository {
    @PersistenceContext(unitName = "raportmodule")
    EntityManager entityManager;

    public List<ClientKey> getAllKeys(){
        return (List<ClientKey>) entityManager.createQuery("from ClientKey ").getResultList();
    }
    public void addKey(ClientKey clientKey){
        entityManager.persist(clientKey);
    }
}
