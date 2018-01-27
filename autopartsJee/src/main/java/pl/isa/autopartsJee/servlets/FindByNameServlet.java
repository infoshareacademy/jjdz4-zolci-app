package pl.isa.autopartsJee.servlets;

import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autopartsJee.dao.TreeOperationsRepositoryDao;
import pl.isa.autopartsJee.repository.TreeOperationsRepository;
import pl.isa.autopartsJee.tools.WebLinkGenerator;

import javax.inject.Inject;
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
    @Inject
    TreeOperationsRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebLinkGenerator linkGenerator = new WebLinkGenerator();
        linkGenerator.generateLinkMap(req.getParameter("search"), dao.getRepository());
        Map<String, String> link = linkGenerator.getNameLink();

        req.setAttribute("link", link);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-by-name-result.jsp");
        requestDispatcher.forward(req, resp);

    }
}