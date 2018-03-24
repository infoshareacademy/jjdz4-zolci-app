package pl.isa.autopartsJee.linkGenerating.servlets;

import pl.isa.autopartsJee.adminPanel.raportModule.rest.LogRequest;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
import pl.isa.autopartsJee.linkGenerating.WebLinkGenerator;
import pl.isa.autopartsJee.linkGenerating.dao.TreeOperationsRepositoryDao;
import pl.isa.autopartsJee.linkGenerating.domain.ItemParentName;

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
    @Inject
    CarRepositoryDao carRepositoryDao;
    @Inject
    LogRequest logRequest;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebLinkGenerator linkGenerator = new WebLinkGenerator();
        String search = req.getParameter("search").toLowerCase();

        if (search == null || search.isEmpty()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-by-name-result.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        linkGenerator.generateLinkMap(search, carRepositoryDao.findCarById(Long.parseLong(req.getParameter("carID"))), dao.getRepository());
        Map<String, ItemParentName> linkMap = linkGenerator.getLinkAndNames();
        logRequest.createLog("searching-manually",
                (Long) req.getSession().getAttribute("userId"), "link-generation");

        req.setAttribute("link", linkMap);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-by-name-result.jsp");
        requestDispatcher.forward(req, resp);

    }
}