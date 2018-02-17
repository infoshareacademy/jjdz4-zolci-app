package pl.isa.autopartsJee.raportModule.repository;

import pl.isa.autopartsJee.raportModule.domain.Log;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Stateless
public class LogRepository {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addSingleLog(String message, Long userId, String logLevel){

        Log log = new Log();
        log.setMessage(message);
        log.setLocalDateTime(LocalDateTime.now());
        log.setLogLevel(logLevel);
        log.setUserId(userId);

        entityManager.persist(log);
    }
}
