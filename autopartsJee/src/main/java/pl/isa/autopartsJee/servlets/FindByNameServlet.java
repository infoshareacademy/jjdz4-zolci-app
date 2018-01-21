package pl.isa.autopartsJee.servlets;

import pl.isa.autoparts.categories.TreeOperations;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/find-by-name")
public class FindByNameServlet extends HttpServlet {
    @Inject
    TreeOperationsDao dao;
    /*
    * TODO: servlet ktory wykona sie jednoczesnie z jsp findByName ktory zbuduje obiekt TreeOperations i przechowa go w sesji,
    * TODO następnie ten servlet go wczyta i przekaże do generateLink w argumencie dzięki czemu nie bedzie sie wczytywalo przy
    * TODO kazdym wyszukaniu //inna sprawa ze i tak dziala dosc szybko
    */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkGenerator linkGenerator = new LinkGenerator();
        String link = linkGenerator.generateLink(req.getParameter("search"), dao.getTreeOperations());
        Map<String, String> searchedLink = new HashMap<>();

//        searchedLink.put(linkGenerator.generateLink(req.getParameter("search")), req.getParameter("search"));
        if (link.equals("Category not found")) {
            searchedLink.put("null", "Nie znaleziono kategorii!");
        } else {
            searchedLink.put(link, linkGenerator.getItemName().substring(0,1).toUpperCase() + linkGenerator.getItemName().substring(1));
        }
        req.setAttribute("link", searchedLink);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-by-name-result.jsp");
        requestDispatcher.forward(req, resp);

    }
}