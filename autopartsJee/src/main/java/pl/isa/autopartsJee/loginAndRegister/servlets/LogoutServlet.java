package pl.isa.autopartsJee.loginAndRegister.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LogoutServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.logout();
        req.getSession().invalidate();
        logger.info("User logged out");
        resp.sendRedirect("/index.jsp");

    }
}
