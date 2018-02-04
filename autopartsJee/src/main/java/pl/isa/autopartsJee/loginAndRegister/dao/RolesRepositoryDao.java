package pl.isa.autopartsJee.loginAndRegister.dao;

import pl.isa.autopartsJee.loginAndRegister.domain.Role;

import javax.ejb.Local;

@Local
public interface RolesRepositoryDao {
    void addUser(Role role);
}
