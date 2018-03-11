package pl.isa.autopartsJee.carToDatabase.repository;

import pl.isa.autopartsJee.carToDatabase.domain.CarData;

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

    public List<CarData> findCarsByOwnerId(Long ownerId) {
        List<CarData> carDataList = new ArrayList<>();

        carDataList = (List<CarData>) entityManager.createQuery("from CarData u where u.ownerId=:ownerId")
                .setParameter("ownerId", ownerId).getResultList();
        return carDataList;

    }

    public CarData findCarById(Long carID) {
        return entityManager.find(CarData.class, carID);
    }

}
