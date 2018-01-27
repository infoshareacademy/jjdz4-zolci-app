package pl.isa.autopartsJee.servlets;

import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autopartsJee.tools.WebLinkGenerator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/find-by-name")
public class FindByNameServlet extends HttpServlet {
    //@Inject
   // TreeOperationsDao dao;
    /*
    * TODO: servlet ktory wykona sie jednoczesnie z jsp findByName ktory zbuduje obiekt TreeOperations i przechowa go w sesji,
    * TODO następnie ten servlet go wczyta i przekaże do generateLinkMap w argumencie dzięki czemu nie bedzie sie wczytywalo przy
    * TODO kazdym wyszukaniu //inna sprawa ze i tak dziala dosc szybko
    */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebLinkGenerator linkGenerator = new WebLinkGenerator();
        TreeOperations treeOperations = new TreeOperations();
        linkGenerator.generateLinkMap(req.getParameter("search"), treeOperations);
        Map<String, String> link = linkGenerator.getNameLink();

//        if (link.equals("Category not found")) {
//            searchedLink.put("", "Nie znaleziono kategorii!");
//        } else {
//            searchedLink.put(link, linkGenerator.getItemName().substring(0,1).toUpperCase() + linkGenerator.getItemName().substring(1));
//        }
        req.setAttribute("link", link);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-by-name-result.jsp");
        requestDispatcher.forward(req, resp);

    }
}