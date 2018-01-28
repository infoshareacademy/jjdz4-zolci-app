package pl.isa.autopartsJee.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarRepository implements ICarRepository {
    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addCar(CarData carData) {
        entityManager.persist(carData);
    }

}
