package pl.isa.raportmodule.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.raportmodule.domain.Log;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class LogRepository {

    Logger logger = LoggerFactory.getLogger(LogRepository.class);
    @PersistenceContext(unitName = "raportmodule")
    private EntityManager entityManager;

    public void addSingleLog(Log log) {
        entityManager.persist(log);
        logger.info("Log added");
    }

    public List<Log> getLogs() {
        logger.info("Logs returned");
        return (List<Log>) entityManager.createQuery("from Log").getResultList();
    }

    public List<Log> getSpecifiedLogs(String message) {
        logger.info("Logs returned");
        return (List<Log>) entityManager.createQuery("from Log where message= :message").setParameter("message", message).getResultList();
    }
}
//        logged-in
//        login-error
//        logged-out
//        register-error
//        user-registered
//        searching-manually
//        searching-form
//        cars-displayed
//        car-added
//        atena-session-not-found