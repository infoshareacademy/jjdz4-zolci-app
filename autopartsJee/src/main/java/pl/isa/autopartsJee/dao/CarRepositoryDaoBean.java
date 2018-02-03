package pl.isa.autopartsJee.dao;

import pl.isa.autopartsJee.domain.CarData;
import pl.isa.autopartsJee.repository.CarRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CarRepositoryDaoBean implements CarRepositoryDao{
    @EJB
    CarRepository carRepository;
    @Override
    public void addCar(CarData carData) {
        carRepository.addCar(carData);
    }
}
