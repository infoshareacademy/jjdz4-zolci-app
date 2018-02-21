package pl.isa.raportmodule.repository;

import pl.isa.raportmodule.domain.AdminPreferences;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class AdminPreferencesRepository {
    @PersistenceContext(name = "raportmodule")
    EntityManager entityManager;

    public AdminPreferences getAdminPreferences() {
        return (AdminPreferences) entityManager.createQuery("from AdminPreferences where id=1").getSingleResult();
    }

    public void updatePreferences(AdminPreferences adminPreferences) {
        entityManager.persist(adminPreferences);
    }
}
