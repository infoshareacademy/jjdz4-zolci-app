package pl.isa.autopartsJee.listener;

import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.linkGenerating.dao.TreeOperationsRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.dao.RolesRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.domain.Role;
import pl.isa.autopartsJee.loginAndRegister.domain.User;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class StartUp implements ServletContextListener {
    @Inject
    TreeOperationsRepositoryDao dao;
    @Inject
    UsersRepositoryDao usersRepositoryDao;
    @Inject
    RolesRepositoryDao rolesRepositoryDao;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(StartUp.class.getName());

    public void contextInitialized(ServletContextEvent e) {
        dao.initRepository();
        logger.info("File parsed");


        addAdminUser();
    }

    private void addAdminUser() {
        if (!checkIfUserExists()) {

            User user = new User();
            Role role = new Role();
            user.setEmail("yellowautopartsfinder@gmail.com");
            user.setPassword("21232f297a57a5a743894a0e4a801fc3");
            user.setName("admin");
            user.setSurname("admin");
            user.setLogin("admin");
            usersRepositoryDao.addUser(user);

            role.setRole_group("admin");
            role.setUser_role("admin");
            role.setUser_id(usersRepositoryDao.findUserByLogin(user.getLogin()).getId());
            role.setUser_login(user.getLogin());
            rolesRepositoryDao.addUser(role);
        }
    }

    private Boolean checkIfUserExists() {
        List<User> users = usersRepositoryDao.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(null) || user.getLogin().equals(null)) {
                continue;
            }
            if (user.getLogin().equals("admin") || user.getEmail().equals("yellowautopartsfinder@gmail.com")) {
                return true;
            }
        }
        return false;
    }


    public void contextDestroyed(ServletContextEvent e) {

    }
}