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
                keyExists = true;
            }
        }
        logger.info(keyExists.toString());
        if (keyExists) {
            entityManager.createQuery("UPDATE AdminPreferences SET preferences=:preferences WHERE clientKey=:clientKey")
                    .setParameter("preferences", adminPreferences.getPreferences())
                    .setParameter("clientKey", adminPreferences.getClientKey()).executeUpdate();
        }
//        logger.info(adminPreferences.getPreferences()+adminPreferences.getClientKey());
//        entityManager.createQuery("DELETE FROM AdminPreferences ap WHERE ap.clientKey=:clientKey")
//                .setParameter("clientKey", adminPreferences.getClientKey()).executeUpdate();
        else {
            entityManager.persist(adminPreferences);
        }
    }
}
