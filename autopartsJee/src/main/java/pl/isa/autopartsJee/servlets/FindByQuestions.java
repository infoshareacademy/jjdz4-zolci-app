package pl.isa.autopartsJee.servlets;


import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autoparts.questions.*;
import pl.isa.autoparts.tools.LinkGenerator;
import pl.isa.autopartsJee.dao.TreeOperationsDao;
import pl.isa.autopartsJee.tools.WebLinkGenerator;
import sun.reflect.generics.tree.Tree;


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
public class FindByQuestions extends HttpServlet {
    @Inject
    TreeOperationsDao dao;
    Questionary questionary = new Questionary();

    private void doRecive(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if(req.getParameter("step").equals("1")){

            TopClass topClass = questionary.init();
            List<String> questionaryName = new ArrayList<>();

            for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
                questionaryName.add(questionGroup.getName());
            }

            req.setAttribute("groupQuestions", questionaryName);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step1.jsp");
            requestDispatcher.forward(req, resp);
        }
        else if(req.getParameter("step").equals("2")){

            List<Question> myQuestions = questionary.groupJee(req.getParameter("selected"));
            List<String> tempQuestion = new ArrayList<>();

            for (Question a : myQuestions) {
                tempQuestion.add(a.getDescripton());
            }

            req.setAttribute("questions", tempQuestion);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step2.jsp");
            requestDispatcher.forward(req, resp);
        }
        else if (req.getParameter("step").equals("3")) {

            List<BreakDown> breakDown = questionary.breakDownsJee(req.getParameter("selected"));
            List<String> breakDownView = new ArrayList<>();

            for (BreakDown breakDownTmp : breakDown) {
                breakDownView.add(breakDownTmp.getDescription());
            }

            req.setAttribute("breakDown", breakDownView);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step3.jsp");
            requestDispatcher.forward(req, resp);
        }
        else if (req.getParameter("step").equals("4")) {
            List<Parts> parts = questionary.partsJee(req.getParameter("selected"));
            WebLinkGenerator linkGenerator = new WebLinkGenerator();
            Map<String, String> tempMap = new HashMap<>();

            for(Parts partsTmp : parts){
               tempMap.put(linkGenerator.generateLink(partsTmp.getPart()), partsTmp.getPart());
            }

            req.setAttribute("parts", tempMap);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step4.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }
}
