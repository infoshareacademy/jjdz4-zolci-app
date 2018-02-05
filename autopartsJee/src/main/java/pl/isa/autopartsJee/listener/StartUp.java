package pl.isa.autopartsJee.listener;

import pl.isa.autopartsJee.linkGenerating.dao.TreeOperationsRepositoryDao;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class StartUp implements ServletContextListener {
    @Inject
    TreeOperationsRepositoryDao dao;
    private Logger logger = Logger.getLogger(StartUp.class.getName());
    public void contextInitialized(ServletContextEvent e) {
        dao.initRepository();
        logger.info("File parsed");
    }

    public void contextDestroyed(ServletContextEvent e) {

    }
}