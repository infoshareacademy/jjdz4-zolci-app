package pl.isa.autopartsJee.repository;

import javax.ejb.Local;

@Local
public interface ICarRepository {
    void addCar(CarData carData);
}
