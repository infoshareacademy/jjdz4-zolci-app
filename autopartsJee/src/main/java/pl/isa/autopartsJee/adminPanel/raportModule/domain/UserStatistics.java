package pl.isa.autopartsJee.adminPanel.raportModule.domain;

import pl.isa.autopartsJee.loginAndRegister.domain.User;

import java.time.LocalDateTime;
import java.util.HashMap;

public class UserStatistics {
    private User user;
    private LocalDateTime lastAction;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLastAction() {
        return lastAction;
    }

    public void setLastAction(LocalDateTime lastAction) {
        this.lastAction = lastAction;
    }

    public HashMap<LocalDateTime, Long> getLoginsDaily() {
        return loginsDaily;
    }

    public void setLoginsDaily(HashMap<LocalDateTime, Long> loginsDaily) {
        this.loginsDaily = loginsDaily;
    }

    private HashMap<LocalDateTime, Long> loginsDaily;

}
