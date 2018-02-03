package pl.isa.autopartsJee.repository;

import pl.isa.autopartsJee.domain.CarData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarRepository {
    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addCar(CarData carData) {
        entityManager.persist(carData);
    }

}
