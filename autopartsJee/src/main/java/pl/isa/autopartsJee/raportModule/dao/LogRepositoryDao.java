package pl.isa.autopartsJee.raportModule.dao;

import javax.ejb.Local;
import java.time.LocalDateTime;

@Local
public interface LogRepositoryDao {

    public void addSingleLog(String message, Long userId, String logLevel);

}
