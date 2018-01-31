package pl.isa.autopartsJee.dao;

import pl.isa.autopartsJee.domain.Role;

import javax.ejb.Local;

@Local
public interface RolesRepositoryDao {
    void addUser(Role role);
}
