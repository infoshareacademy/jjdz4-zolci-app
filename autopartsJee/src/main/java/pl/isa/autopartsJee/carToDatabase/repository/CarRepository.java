package pl.isa.autopartsJee.carToDatabase.repository;

import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.loginAndRegister.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CarRepository {
    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addCar(CarData carData) {
        entityManager.persist(carData);
    }

    public ArrayList<CarData> findCarsByOwnerId(int ownerId) {
        ArrayList<CarData> carDataList = new ArrayList<>();

        carDataList = (ArrayList<CarData>) entityManager.createQuery("from CarData u where u.ownerId=:ownerId")
                .setParameter("ownerId", ownerId).getResultList();
        return carDataList;

    }

}
