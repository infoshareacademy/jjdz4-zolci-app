package pl.isa.autopartsJee.adminPanel.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.raportModule.domain.AdminPreferences;
import pl.isa.autopartsJee.raportModule.rest.PreferencesRequest;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatepreferences")
public class AdminPanelServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(AdminPanelServlet.class);
    @Inject
    PreferencesRequest preferencesRequest;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Boolean manualSearch;
//        Boolean formSearch;
//        Boolean login;
//        Boolean logout;
//        Boolean register;
//        Boolean addedCars;
//        Boolean failedLogins;
//        Boolean failedRegisters;
//        logger.info(req.getParameter("manualsearch"));
//        manualSearch = Boolean.valueOf(req.getParameter("manualsearch"));
//        formSearch = Boolean.valueOf(req.getParameter("formsearch"));
//        login = Boolean.valueOf(req.getParameter("login"));
//        logout = Boolean.valueOf(req.getParameter("logout"));
//        register = Boolean.valueOf(req.getParameter("register"));
//        addedCars = Boolean.valueOf(req.getParameter("addedcars"));
//        failedLogins = Boolean.valueOf(req.getParameter("failedlogins"));
//        failedRegisters = Boolean.valueOf(req.getParameter("failedregisters"));

        StringBuilder stringBuilder = new StringBuilder();

        if (req.getParameter("manualsearch").equals("on")) {
            stringBuilder.append("searching-manually.");
        }
        if (req.getParameter("formsearch").equals("on")) {
            stringBuilder.append("searching-form. ");
        }
        if (req.getParameter("login").equals("on")) {
            stringBuilder.append("logged-in");
        }
        if (req.getParameter("logout").equals("on")) {
            stringBuilder.append("logged-out");
        }
        if (req.getParameter("register").equals("on")) {
            stringBuilder.append("user-registered");
        }
        if (req.getParameter("manualsearch").equals("on")) {
            stringBuilder.append("car-added");
        }
        if (req.getParameter("failedlogins").equals("on")) {
            stringBuilder.append("login-error");
        }
        if (req.getParameter("failedregisters").equals("on")) {
            stringBuilder.append("register-error");
        }
        String preferences = stringBuilder.toString();

        AdminPreferences adminPreferences = new AdminPreferences();
//        adminPreferences.setId(1);
        logger.info(preferences);
        adminPreferences.setPreferences(preferences);
        preferencesRequest.updatePreferences(adminPreferences);
        req.setAttribute("updatemessage", "Preferencje zaktualizowane");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin-panel.jsp");
        requestDispatcher.forward(req, resp);
        return;
    }
}
