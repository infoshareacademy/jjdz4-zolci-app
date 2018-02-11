package pl.isa.autopartsJee.raportModule.dao;

import pl.isa.autopartsJee.raportModule.domain.Log;
import pl.isa.autopartsJee.raportModule.repository.LogRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Stateless
public class LogRepositoryDaoBean implements LogRepositoryDao{
    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;
//    @EJB
//    LogRepository logRepository;

    @Override
    public void addSingleLog(String message, Long userId, String logLevel) {
        Log log = new Log();
        log.setMessage(message);
        log.setLocalDateTime(LocalDateTime.now());
        log.setLogLevel(logLevel);
        log.setUserId(userId);

        entityManager.persist(log);

//        logRepository.addSingleLog(message, userId, logLevel);

    }
}
