package pl.isa.autopartsJee.adminPanel.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.adminPanel.raportModule.domain.Log;
import pl.isa.autopartsJee.adminPanel.raportModule.domain.UserStatistics;
import pl.isa.autopartsJee.adminPanel.raportModule.rest.GetAllLogsRequest;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.loginAndRegister.domain.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(StatisticsServlet.class);
    @Inject
    GetAllLogsRequest getAllLogsRequest;
    @Inject
    UsersRepositoryDao usersRepositoryDao;

    private List<UserStatistics> userStatisticsList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Log> logs = getAllLogsRequest.getAllLogs();
        for (User user : usersRepositoryDao.getAllUsers()) {
            UserStatistics userStatistics = new UserStatistics();
            userStatistics.setUser(user);
            logger.info(user.getLogin());

            List<Log> usersLogs = new ArrayList<>();
            for(Log log : logs){
                if(log.getUserId().equals(user.getId())){
                    usersLogs.add(log);
                    logger.info(log.getMessage());
                }
            }
            List<LocalDateTime> localDateTimeList = new ArrayList<>();
            for(Log log : usersLogs){
                localDateTimeList.add(log.getLocalDateTime());
            }

            Collections.sort(localDateTimeList);
            userStatistics.setLastAction(localDateTimeList.get(localDateTimeList.size()));



        }
        req.setAttribute("userStatistics", userStatisticsList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/statistics.jsp");
        requestDispatcher.forward(req, resp);

    }
}
