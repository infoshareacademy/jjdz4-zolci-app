package pl.isa.autopartsJee.loginAndRegister.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.loginAndRegister.dao.RolesRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.domain.User;
import pl.isa.autopartsJee.raportModule.dao.LogRepositoryDao;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        filterName = "SetIdFilter",
        urlPatterns = {"/*"})
public class SetIdFilter implements Filter {
    @Inject
    UsersRepositoryDao usersRepositoryDao;
    @Inject
    RolesRepositoryDao rolesRepositoryDao;


    private Logger logger = LoggerFactory.getLogger(SetIdFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        if ((Boolean) session.getAttribute("isLogged")) {
            User user = usersRepositoryDao.findUserByLogin((String) req.getSession()
                    .getAttribute("loggedUser"));
            session.setAttribute("userId", user.getId()) ;

            session.setAttribute("userName", user.getName());

            session.setAttribute("userRole", rolesRepositoryDao.findUsersRole(usersRepositoryDao
                    .findUserByLogin((String) req.getSession().getAttribute("loggedUser"))).getUser_role());
            logger.debug("User id found");
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }
}
