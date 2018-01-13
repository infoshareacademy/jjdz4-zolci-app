package pl.isa.autopartsJee.servlets;


import pl.isa.autoparts.questions.Question;
import pl.isa.autoparts.questions.QuestionGroup;
import pl.isa.autoparts.questions.Questionary;
import pl.isa.autoparts.questions.TopClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;

@WebServlet("find-questions")
public class FindByQuestions extends HttpServlet {

//    String myName = null;
//    String myFind;

    private void doRecive(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        RequestDispatcher requestDispatcher;
        Questionary questionary = new Questionary();
        TopClass topClass = questionary.init();

        if (req.getParameter("step").equals("1")) {
            System.out.println("a1");
//            TopClass topClass = questionary.init();

            List<String> questionaryName = new ArrayList<>();
            for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
                questionaryName.add(questionGroup.getName());
            }

            req.setAttribute("groupQuestions", questionaryName);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form.jsp");
                requestDispatcher.forward(req, resp);

//            myName = req.getParameter("name");
        }

//        int tempStep = Integer.parseInt(req.getParameter("step").substring(0,1));
//        else if (req.getParameter("step").equals(String.valueOf(tempStep))) {
//        else if (!req.getParameter("step").equals("1")) {
        else if (req.getParameter("step").substring(0, 1).equals("2")) {
            System.out.println("b1");
//            List<Question> myQuestions = questionary.tryWeb(req.getParameter("name"));
            System.out.println("krzys " + req.getParameter("token"));
            List<Question> myQuestions = questionary.tryWeb(req.getParameter("step").substring(1));
            List<String> tempQuestion = new ArrayList<>();
            for (Question a : myQuestions) {
                System.out.println("c " + a.getDescripton());
                tempQuestion.add(a.getDescripton());
            }
//            req.getSession().invalidate();
            req.setAttribute("questions", tempQuestion);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step1.jsp");
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
