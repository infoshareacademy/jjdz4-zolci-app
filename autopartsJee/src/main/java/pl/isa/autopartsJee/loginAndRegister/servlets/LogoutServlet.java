package pl.isa.autopartsJee.loginAndRegister.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.raportModule.dao.LogRepositoryDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Inject
    LogRepositoryDao logRepositoryDao;
    private Logger logger = LoggerFactory.getLogger(LogoutServlet.class.getName());
    @Inject
    UsersRepositoryDao usersRepositoryDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = usersRepositoryDao.findUserByLogin(req.getSession().getAttribute("loggedUser").toString()).getId();
        req.logout();
        req.getSession().invalidate();
        logger.info("User logged out");
        logRepositoryDao.addSingleLog("User logged out successfully",  userId, "logout");

        resp.sendRedirect("/index.jsp");

    }
}
