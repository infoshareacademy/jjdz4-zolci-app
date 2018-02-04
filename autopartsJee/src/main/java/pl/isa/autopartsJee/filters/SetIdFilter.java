package pl.isa.autopartsJee.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;

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
    private Logger logger = LoggerFactory.getLogger(SetIdFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        try {
            if ((Boolean) session.getAttribute("isLogged")) {
                session.setAttribute("userId", usersRepositoryDao.findUserByLogin((String) req.getSession().getAttribute("loggedUser")).getId());
                logger.debug("User id found");
            }
        } catch (NullPointerException e) {
            logger.debug("User not logged");
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }
}
