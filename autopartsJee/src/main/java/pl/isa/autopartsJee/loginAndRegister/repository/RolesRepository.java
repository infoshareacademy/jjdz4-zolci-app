package pl.isa.autopartsJee.loginAndRegister.repository;

import pl.isa.autopartsJee.loginAndRegister.domain.Role;
import pl.isa.autopartsJee.loginAndRegister.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RolesRepository {
    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addRole(Role role) {
        entityManager.persist(role);
    }

    public Role findUsersRole(User user) {
        return (Role) entityManager.createQuery("from Role u where u.user_id=:user_id")
                .setParameter("user_id", user.getId()).getSingleResult();
    }
}
