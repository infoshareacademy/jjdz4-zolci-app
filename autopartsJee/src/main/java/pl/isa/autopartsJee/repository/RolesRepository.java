package pl.isa.autopartsJee.repository;

import pl.isa.autopartsJee.domain.Role;

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
}
