package pl.isa.autopartsJee.loginAndRegister.dao;

import pl.isa.autopartsJee.loginAndRegister.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersRepositoryDao {

    void addUser(User user);

    User findUserByLogin(String login);

    List<User> getAllUsers();
}
