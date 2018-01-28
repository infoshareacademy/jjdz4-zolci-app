package pl.isa.autopartsJee.listener;

import pl.isa.autopartsJee.dao.TreeOperationsRepositoryDao;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUp implements ServletContextListener {
    @Inject
    TreeOperationsRepositoryDao dao;

    public void contextInitialized(ServletContextEvent e) {
        dao.initRepository();
    }

    public void contextDestroyed(ServletContextEvent e) {

    }
}