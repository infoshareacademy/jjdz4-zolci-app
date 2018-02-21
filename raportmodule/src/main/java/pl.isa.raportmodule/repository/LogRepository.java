package pl.isa.raportmodule.repository;


import com.google.gson.Gson;
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
    public List<Log> getLoginLogs() {
        logger.info("Logs returned");
        return (List<Log>) entityManager.createQuery("from Log where message= :message").setParameter("message", "logged-in").getResultList();
    }
    public List<Log> getLoginErrorLogs() {
        logger.info("Logs returned");
        return (List<Log>) entityManager.createQuery("from Log where message= :message").setParameter("message", "login-error").getResultList();
    }
    public List<Log> getLogoutLogs() {
        logger.info("Logs returned");
        return (List<Log>) entityManager.createQuery("from Log where message= :message").setParameter("message", "logged-out").getResultList();
    }
}
