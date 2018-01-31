package pl.isa.autopartsJee.servlets;

import pl.isa.autopartsJee.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User;
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setLogin(req.getParameter("login"));

    }
}
