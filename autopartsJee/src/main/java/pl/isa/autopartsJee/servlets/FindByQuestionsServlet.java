package pl.isa.autopartsJee.servlets;

import pl.isa.autoparts.questions.*;
import pl.isa.autopartsJee.dao.TreeOperationsDao;
import pl.isa.autopartsJee.tools.WebLinkGenerator;

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
    TreeOperationsDao dao;
    InitQuestionsParser initialingQuestionsParser = new InitQuestionsParser();
    FunctionsWeb functionsWeb = new FunctionsWeb();

    private void doRecive(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        /**     Step 1   */
        if (req.getParameter("step").equals("1")) {
            TopClass topClass = initialingQuestionsParser.init();
            List<String> questionaryName = new ArrayList<>();

            for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
                questionaryName.add(questionGroup.getName());
            }
            req.setAttribute("groupQuestions", questionaryName);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step1.jsp");
            requestDispatcher.forward(req, resp);

            /**     Step 2   */
        } else if (req.getParameter("step").equals("2")) {

            List<Question> myQuestions = functionsWeb.groupJee(req.getParameter("selected"));
            List<String> tempQuestion = new ArrayList<>();

            for (Question a : myQuestions) {
                tempQuestion.add(a.getDescripton());
            }
            req.setAttribute("questions", tempQuestion);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step2.jsp");
            requestDispatcher.forward(req, resp);

            /**     Step 3   */
        } else if (req.getParameter("step").equals("3")) {

            List<BreakDown> breakDown = functionsWeb.breakDownsJee(req.getParameter("selected"));
            List<String> breakDownView = new ArrayList<>();

            for (BreakDown breakDownTmp : breakDown) {
                breakDownView.add(breakDownTmp.getDescription());
            }
            req.setAttribute("breakDown", breakDownView);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step3.jsp");
            requestDispatcher.forward(req, resp);

            /**     Step 4   */
        } else if (req.getParameter("step").equals("4")) {

            List<Parts> parts = functionsWeb.partsJee(req.getParameter("selected"));
            WebLinkGenerator webLinkGenerator = new WebLinkGenerator();
            Map<String, String> tempMap = new HashMap<>();

            for (Parts partsTmp : parts) {
                tempMap.put(webLinkGenerator.generateLink(partsTmp.getPart(), dao.getTreeOperations()), partsTmp.getPart());
            }
            req.setAttribute("parts", tempMap);
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
