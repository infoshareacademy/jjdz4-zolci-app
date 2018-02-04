package pl.isa.autopartsJee.loginAndRegister.servlets;

import pl.isa.autopartsJee.loginAndRegister.dao.RolesRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.domain.Role;
import pl.isa.autopartsJee.loginAndRegister.domain.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class.getName());
    @Inject
    UsersRepositoryDao usersRepositoryDao;
    @Inject
    RolesRepositoryDao rolesRepositoryDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Role role = new Role();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(req.getParameter("password").getBytes());
        byte[] digest = md.digest();
        String password = DatatypeConverter
                .printHexBinary(digest).toLowerCase();

        user.setEmail(req.getParameter("email"));
        user.setPassword(password);
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setLogin(req.getParameter("login"));
        role.setRole_group("user");
        role.setUser_role("user");
        role.setUser_id(user.getId());
        role.setUser_login(user.getLogin());
        usersRepositoryDao.addUser(user);
        rolesRepositoryDao.addUser(role);
        //TODO rozdzielic to na dwa servlety, do rol dodawac id usera
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
