package pl.isa.autopartsJee.loginAndRegister.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.loginAndRegister.dao.RolesRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.domain.Role;
import pl.isa.autopartsJee.loginAndRegister.domain.User;
import pl.isa.autopartsJee.adminPanel.raportModule.rest.LogRequest;

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
import java.util.List;

//import pl.isa.autopartsJee.adminPanel.raportModule.dao.LogRepositoryDao;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(RegisterServlet.class.getName());
    @Inject
    UsersRepositoryDao usersRepositoryDao;
    @Inject
    RolesRepositoryDao rolesRepositoryDao;
    @Inject
    LogRequest logRequest;


    private Boolean checkIfUserExists(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersRepositoryDao.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(null) || user.getLogin().equals(null)) {
                continue;
            }
            if (user.getLogin().equals(req.getParameter("login"))) {
                req.setAttribute("registrationError", "Użytkownik o podanym loginie istnieje");
                logger.error("User with this login exists");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
                requestDispatcher.forward(req, resp);
                return true;
            } else if (user.getEmail().equals(req.getParameter("email"))) {
                logger.error("User with this email exists");
                req.setAttribute("registrationError", "Użytkownik o podanym emailu istnieje");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
                requestDispatcher.forward(req, resp);
                return true;
            }

        }
        return false;
    }

    private Boolean checkIfFieldsAreEmpty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("login").equals(null) || req.getParameter("login").isEmpty() ||
                req.getParameter("email").equals(null) || req.getParameter("email").isEmpty() ||
                req.getParameter("name").equals(null) || req.getParameter("name").isEmpty() ||
                req.getParameter("surname").equals(null) || req.getParameter("surname").isEmpty() ||
                req.getParameter("password").equals(null) || req.getParameter("password").isEmpty()) {
            logger.error("User had left empty fields");
            req.setAttribute("registrationError", "Wprowadź wszystkie dane");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
            requestDispatcher.forward(req, resp);
            return true;
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRecive(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRecive(req, resp);
    }

    private void doRecive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           if (checkIfFieldsAreEmpty(req, resp)) {
               logRequest.createLog("register-error",
                       null, "register");
               return;
           }
           if (checkIfUserExists(req, resp)) {
               logRequest.createLog("register-error",
                       null, "register");
               return;
           }
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
           usersRepositoryDao.addUser(user);
           role.setRole_group("user");
           role.setUser_role("user");
           role.setUser_id(usersRepositoryDao.findUserByLogin(user.getLogin()).getId());
           role.setUser_login(user.getLogin());
           rolesRepositoryDao.addUser(role);
           logger.info("User registered successfully");
           logRequest.createLog("user-registered",
                   user.getId(), "register");
           req.setAttribute("success", "Użytkownik zarejestrowany pomyślnie");
           RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
           requestDispatcher.forward(req, resp);
       }catch (NullPointerException e){
           req.setAttribute("success", "Użytkownik zarejestrowany pomyślnie");
           RequestDispatcher requestDispatcher = req.
                   getRequestDispatcher("/index.jsp");
           requestDispatcher.forward(req, resp);
       }
    }
}
