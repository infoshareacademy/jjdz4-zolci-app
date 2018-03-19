package pl.isa.autopartsJee.linkGenerating.servlets;

import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autopartsJee.adminPanel.raportModule.rest.LogRequest;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("find-category")
public class CarsAndPartsSetter extends HttpServlet {
    @Inject
    CarRepositoryDao carRepository;
    private Logger logger = Logger.getLogger(CarsAndPartsSetter.class.getName());
    @Inject
    LogRequest logRequest;
    @Inject
    TreeOperationsRepositoryDao treeOperationsRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        setCarsList(req);

        setPartsNames(req);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/find-category.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void setCarsList(HttpServletRequest req) {
        req.getSession().setAttribute("cars",
                carRepository.findCarsByOwnerId(Long.parseLong(req.getSession().getAttribute("userId").toString())));
        logRequest.createLog("cars-displayed", (Long) req.getSession().getAttribute("userId"), "cars-display");
        logger.info("Cars of users id: " + req.getSession().getAttribute("userID") + " found");
    }

    private void setPartsNames(HttpServletRequest req) {

        List<ItemParentName> partsNames = new ArrayList<>();

        for(AllegroItem allegroItem:treeOperationsRepositoryDao.getRepository().getPartsList()){

            AllegroItem parent = treeOperationsRepositoryDao.getRepository().findParent(allegroItem);
            ItemParentName itemParentName = new ItemParentName();
            itemParentName.setItemName(allegroItem.getName().substring(0, 1).toUpperCase()
                    + allegroItem.getName().substring(1).toLowerCase());
            itemParentName.setParentName(parent.getName().substring(0, 1).toUpperCase()
                    + parent.getName().substring(1).toLowerCase());
            partsNames.add(itemParentName);
        }


//        List<String> partsNames = treeOperationsRepositoryDao.getRepository()
//                .getPartsList().stream().map(AllegroItem::getName)
//                .sorted()
//                .collect(toList());
//        logger.info(partsNames.get(1));
        req.getSession().setAttribute("partsNames", partsNames);
    }
}
