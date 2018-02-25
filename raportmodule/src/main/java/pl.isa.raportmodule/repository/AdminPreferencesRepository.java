package pl.isa.raportmodule.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.raportmodule.domain.AdminPreferences;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class AdminPreferencesRepository {
    @PersistenceContext(name = "raportmodule")
    EntityManager entityManager;
    Logger logger = LoggerFactory.getLogger(AdminPreferencesRepository.class);

    public List<AdminPreferences> getAdminPreferences() {
        return (List<AdminPreferences>) entityManager.createQuery("from AdminPreferences").getResultList();
    }

    public void updatePreferences(AdminPreferences adminPreferences) {
        Boolean keyExists = false;
        List<AdminPreferences> adminPreferencesList = getAdminPreferences();
        for (AdminPreferences adminPreferencesSet : adminPreferencesList) {
            if (adminPreferencesSet.getClientKey().equals(adminPreferences.getClientKey())) {
                entityManager.createNamedQuery("update")
                        .setParameter("preferences", adminPreferences.getPreferences())
                        .setParameter("clientKey", adminPreferences.getClientKey()).executeUpdate();
//                break;
                return;
            }
        }
        logger.info(keyExists.toString());
        entityManager.persist(adminPreferences);
    }
}

