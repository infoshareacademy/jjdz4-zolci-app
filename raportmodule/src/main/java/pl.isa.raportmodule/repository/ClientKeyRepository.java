//package pl.isa.raportmodule.repository;
//
//import pl.isa.raportmodule.domain.ClientKey;
//
//import javax.ejb.Singleton;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Singleton
//public class ClientKeyRepository {
//    @PersistenceContext(unitName = "raportmodule")
//    private EntityManager entityManager;
//
//    public void addKey(ClientKey clientKey) {
//        entityManager.persist(clientKey);
//    }
//
//    public List<ClientKey> getKeys() {
//        return (List<ClientKey>) entityManager.createQuery("from ClientKey ").getResultList();
//    }
//}
