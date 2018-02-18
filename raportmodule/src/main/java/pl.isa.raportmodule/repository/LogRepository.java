package pl.isa.raportmodule.repository;


import pl.isa.raportmodule.domain.Log;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class LogRepository {

//    @PersistenceContext(unitName = "raportmodule")
    private EntityManager entityManager;

    public void addSingleLog(Log log) {


//        entityManager.persist(log);
    }
}
