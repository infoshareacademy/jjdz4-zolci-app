package pl.isa.autopartsJee.carToDatabase.dao;

import pl.isa.autopartsJee.carToDatabase.domain.CarData;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CarRepositoryDao {
    void addCar(CarData carData);

    List<CarData> findCarsByOwnerId(Long ownerId);

    CarData findCarById(Long carID);

    void deleteCar(Long carID);
}
