package pl.isa.autopartsJee.carToDatabase.dao;

import pl.isa.autopartsJee.carToDatabase.domain.CarData;

import javax.ejb.Local;

@Local
public interface CarRepositoryDao {
    void addCar(CarData carData);
}
