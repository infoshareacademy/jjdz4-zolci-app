package pl.isa.autopartsJee.dao;

import pl.isa.autopartsJee.domain.Role;
import pl.isa.autopartsJee.repository.RolesRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RolesRepositoryDaoBean implements RolesRepositoryDao {
    @EJB
    RolesRepository rolesRepository;

    @Override
    public void addUser(Role role) {
        rolesRepository.addRole(role);
    }
}
