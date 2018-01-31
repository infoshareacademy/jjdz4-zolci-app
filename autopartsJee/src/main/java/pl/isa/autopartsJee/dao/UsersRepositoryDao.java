package pl.isa.autopartsJee.dao;

import pl.isa.autopartsJee.domain.User;

import javax.ejb.Local;

@Local
public interface UsersRepositoryDao {

    void addUser(User user);
}
