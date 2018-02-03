package pl.isa.autopartsJee.dao;

import pl.isa.autopartsJee.domain.CarData;

import javax.ejb.Local;

@Local
public interface CarRepositoryDao {
    void addCar(CarData carData);
}
