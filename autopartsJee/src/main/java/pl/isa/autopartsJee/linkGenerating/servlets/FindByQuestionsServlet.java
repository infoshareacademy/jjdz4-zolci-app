package pl.isa.autopartsJee.linkGenerating.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.questions.*;
import pl.isa.autopartsJee.linkGenerating.dao.TreeOperationsRepositoryDao;
import pl.isa.autopartsJee.linkGenerating.WebLinkGenerator;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;
import pl.isa.autopartsJee.raportModule.dao.LogRepositoryDao;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("find-questions")
public class FindByQuestionsServlet extends HttpServlet {
    @Inject
    LogRepositoryDao logRepositoryDao;
    @Inject
    UsersRepositoryDao usersRepositoryDao;

    public FindByQuestionsServlet() throws IOException {
    }

    @EJB
    private TreeOperationsRepositoryDao dao;

    private Logger logger = LoggerFactory.getLogger(FindByQuestionsServlet.class.getName());
    private WebFunctions webFunctions = new WebFunctions();
    private boolean findLog;

    private void doRecive(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (findLog == false) {
            logRepositoryDao.addSingleLog("Searching by form ",
                    (usersRepositoryDao.findUserByLogin(req.getSession().getAttribute("loggedUser").toString()).getId()), "link-generation");
        }

        /**     Step 1   */
        if (req.getParameter("step").equals("1")) {
            logger.debug("Web: invoke step 1");
            findLog = true;

            TopClass topClass = new TopClass();
            try {
                InitQuestionsParser initQuestionsParser = new InitQuestionsParser(topClass);
                topClass = initQuestionsParser.getTopClass();
            } catch (IOException e) {

            }
            List<String> questionaryName = new ArrayList<>();

            for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
                questionaryName.add(questionGroup.getName());
            }
            req.getSession().setAttribute("groupQuestions", questionaryName);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step1.jsp");
            requestDispatcher.forward(req, resp);

            /**     Step 2   */
        } else if (req.getParameter("step").equals("2")) {
            logger.debug("Web: invoke step 2");

            String getParam = req.getParameter("selected_1");
            List<Question> myQuestions = webFunctions.findQuestion(getParam);
            List<String> tempQuestion = new ArrayList<>();

            for (Question a : myQuestions) {
                tempQuestion.add(a.getDescripton());
            }
            req.getSession().setAttribute("questions", tempQuestion);
            req.getSession().setAttribute("selected", getParam);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step2.jsp");
            requestDispatcher.forward(req, resp);

            /**     Step 3   */
        } else if (req.getParameter("step").equals("3")) {
            logger.debug("Web: invoke step 3");

            String getParam = req.getParameter("selected_2");
            List<BreakDown> breakDown = webFunctions.findBreakDowns(getParam);
            List<String> breakDownView = new ArrayList<>();

            for (BreakDown breakDownTmp : breakDown) {
                breakDownView.add(breakDownTmp.getDescription());
            }
            req.getSession().setAttribute("selected", getParam);
            req.getSession().setAttribute("breakDown", breakDownView);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step3.jsp");
            requestDispatcher.forward(req, resp);

            /**     Step 4   */
        } else if (req.getParameter("step").equals("4")) {
            logger.debug("Web: invoke step 4");

            String getParam = req.getParameter("selected_3");
            List<Parts> parts = webFunctions.findParts(getParam);
            WebLinkGenerator webLinkGenerator = new WebLinkGenerator();
            Map<String, String> tempMap = new HashMap<>();

            for (Parts partsTmp : parts) {
                tempMap.put(webLinkGenerator.generateLink(partsTmp.getPart(), dao.getRepository()), partsTmp.getPart());
            }
            req.getSession().setAttribute("parts", tempMap);
            req.getSession().setAttribute("selected", getParam);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step4.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }
}
