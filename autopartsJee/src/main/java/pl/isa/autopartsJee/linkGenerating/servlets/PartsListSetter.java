package pl.isa.autopartsJee.linkGenerating.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autopartsJee.linkGenerating.dao.TreeOperationsRepositoryDao;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@WebServlet("/set-parts-list")
public class PartsListSetter extends HttpServlet {
    @Inject
    TreeOperationsRepositoryDao treeOperationsRepositoryDao;
    Logger logger = LoggerFactory.getLogger(PartsListSetter.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<String> partsNames = new ArrayList<>();
        treeOperationsRepositoryDao.getRepository().findCarPartCategoryList("");
        partsNames = treeOperationsRepositoryDao.getRepository()
                .getSimilarList().stream().map(AllegroItem::getName)
                .collect(toList());
        logger.info(partsNames.get(1));
        req.getSession().setAttribute("partsNames", partsNames);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category-by-name.jsp");
        requestDispatcher.forward(req, resp);
        treeOperationsRepositoryDao.getRepository().clearList();
    }
}
