package pl.isa.autopartsJee.carToDatabase.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.aztec.AtenaSessionReader;
import pl.isa.autoparts.aztec.AztecVehicle;
import pl.isa.autopartsJee.adminPanel.raportModule.rest.LogRequest;
import pl.isa.autopartsJee.carToDatabase.dao.CarRepositoryDao;
import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.loginAndRegister.dao.UsersRepositoryDao;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete-car-servlet")
public class DeleteCarServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(DeleteCarServlet.class.getName());
    @Inject
    CarRepositoryDao carRepository;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long carID = Long.parseLong(req.getParameter("carID"));
        carRepository.deleteCar(carID);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cars");
        dispatcher.forward(req, resp);
    }


}
