package pl.isa.raportmodule.listener;

import org.slf4j.LoggerFactory;
import pl.isa.raportmodule.domain.AdminPreferences;
import pl.isa.raportmodule.domain.ClientKey;
import pl.isa.raportmodule.repository.AdminPreferencesRepository;
import pl.isa.raportmodule.repository.ClientKeysRepository;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUp implements ServletContextListener {
    @Inject
    ClientKeysRepository clientKeysRepository;
    @Inject
    AdminPreferencesRepository adminPreferencesRepository;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(StartUp.class.getName());

    public void contextInitialized(ServletContextEvent e) {
        ClientKey clientKey = new ClientKey();
        clientKey.setClientKey("2137");
        clientKeysRepository.addKey(clientKey);
        AdminPreferences adminPreferences = new AdminPreferences();
        adminPreferences.setPreferences("searching-manually.searching-form.logged-in.logged-out.user-registered.car-added.login-error.register-error.");
        adminPreferences.setEmail("yellowautopartsfinder@gmail.com");
        adminPreferences.setClientKey("2137");
        adminPreferencesRepository.updatePreferences(adminPreferences);
    }

    public void contextDestroyed(ServletContextEvent e) {

    }
}