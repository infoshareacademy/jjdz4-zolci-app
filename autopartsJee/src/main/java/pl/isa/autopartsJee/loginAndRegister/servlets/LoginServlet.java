package pl.isa.autopartsJee.loginAndRegister.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.login(req.getParameter("login"), req.getParameter("password"));
        } catch (ServletException e) {
            req.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
            logger.log(Level.SEVERE, e.getMessage(), e);
            return;
        }

        if (req.getHeader("Referer").contains("login.jsp")) {
            resp.sendRedirect("/index.jsp");
            return;
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
