package pl.isa.autopartsJee.listener;

import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.linkGenerating.dao.TreeOperationsRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.servlets.RegisterServlet;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUp implements ServletContextListener {
    @Inject
    TreeOperationsRepositoryDao dao;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(StartUp.class.getName());

    public void contextInitialized(ServletContextEvent e) {
        dao.initRepository();
        logger.info("File parsed");
    }

    public void contextDestroyed(ServletContextEvent e) {

    }
}