package pl.isa.autopartsJee.loginAndRegister.dao;

import pl.isa.autopartsJee.loginAndRegister.domain.Role;
import pl.isa.autopartsJee.loginAndRegister.domain.User;
import pl.isa.autopartsJee.loginAndRegister.repository.RolesRepository;

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

    @Override
    public Role findUsersRole(User user) {
        return rolesRepository.findUsersRole(user);
    }
}
