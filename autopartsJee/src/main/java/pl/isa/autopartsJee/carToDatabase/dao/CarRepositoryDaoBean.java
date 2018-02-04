package pl.isa.autopartsJee.carToDatabase.dao;

import pl.isa.autopartsJee.carToDatabase.domain.CarData;
import pl.isa.autopartsJee.carToDatabase.repository.CarRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class CarRepositoryDaoBean implements CarRepositoryDao {
    @EJB
    CarRepository carRepository;
    @Override
    public void addCar(CarData carData) {
        carRepository.addCar(carData);
    }

    @Override
    public ArrayList<CarData> findCarsByOwnerId(int ownerId) {
        return carRepository.findCarsByOwnerId(ownerId);
    }
}
