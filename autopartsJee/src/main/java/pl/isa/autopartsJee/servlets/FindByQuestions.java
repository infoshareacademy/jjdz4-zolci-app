package pl.isa.autopartsJee.servlets;


import pl.isa.autoparts.questions.*;

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

        Questionary questionary = new Questionary();
        TopClass topClass = questionary.init();

        if (req.getParameter("step").equals("1")) {

            List<String> questionaryName = new ArrayList<>();
            for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
                questionaryName.add(questionGroup.getName());
            }

            req.setAttribute("groupQuestions", questionaryName);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step1.jsp");
            requestDispatcher.forward(req, resp);
        } else if (req.getParameter("step").equals("2")) {
//            System.out.println("b1");
//            System.out.println("step 2 " + req.getParameter("selected"));
            List<Question> myQuestions = questionary.tryWeb(req.getParameter("selected"));
            List<String> tempQuestion = new ArrayList<>();

            for (Question a : myQuestions) {
                System.out.println("c " + a.getDescripton());
                tempQuestion.add(a.getDescripton());
            }

            req.setAttribute("questions", tempQuestion);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step2.jsp");
            requestDispatcher.forward(req, resp);

        } else if (req.getParameter("step").equals("3")) {

            List<BreakDown> breakDown = new ArrayList<>();
            breakDown = questionary.breakDownsWeb(req.getParameter("selected"));


//            breakDown.add("kierownica");
//            breakDown.add("lusterko");
//            breakDown.add("wycieraczka");

//            req.setAttribute("breakDown", breakDown.get(1).getDescription());
            List<String> asd = new ArrayList<>();
//            req.setAttribute("breakDown", breakDown.get(1).getDescription());
            for(BreakDown breakDown1 : breakDown){
                asd.add(breakDown1.getDescription());
            }

            req.setAttribute("breakDown", asd);

            System.out.println(breakDown);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step3.jsp");
            requestDispatcher.forward(req, resp);

        } else if (req.getParameter("step").equals("4")) {

        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }
}
