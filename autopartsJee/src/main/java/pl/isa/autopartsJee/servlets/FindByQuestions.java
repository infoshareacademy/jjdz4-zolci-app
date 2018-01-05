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

    String myName;

    private void doRecive(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;


//        if (req.getParameter("step").equals("1")) {
//            req.getSession().setAttribute("name", req.getParameter("name"));

        Questionary questionary = new Questionary();
        TopClass topClass = questionary.init();


//            String questionaryName = (String) req.getSession().getAttribute("name");
        List<String> questionaryName = new ArrayList<>();
        for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
            questionaryName.add(questionGroup.getName());
        }

        req.setAttribute("elements", questionaryName);

        requestDispatcher = req.getRequestDispatcher("/find-category-by-form.jsp");
        requestDispatcher.forward(req, resp);

        String myFind = req.getParameter("name");
//        String userName = request.getParameter("userName");

//        System.out.println(myFind);

        if(myFind != null) {
            System.out.println(myFind);
            System.out.println("ha ha");
        }


//            for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
//
//
//
//                if (questionaryName.equals(questionGroup.getName())) {
//                    myName = questionGroup.getName();
//
//
//
//                    requestDispatcher = req.getRequestDispatcher("/find-category-by-form-step1.jsp");
//                    requestDispatcher.forward(req, resp);
//                }
//            }


//            if ((String) req.getSession().getAttribute("name") != null) {
////                do something
////                functions
//            }
//            else {
//                requestDispatcher = req.getRequestDispatcher("/find1");
//                requestDispatcher.forward(req, resp);
//            }
//    }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doRecive(req, resp);
    }
}
