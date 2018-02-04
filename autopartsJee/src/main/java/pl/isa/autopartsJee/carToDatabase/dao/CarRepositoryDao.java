package pl.isa.autopartsJee.carToDatabase.dao;

import pl.isa.autopartsJee.carToDatabase.domain.CarData;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface CarRepositoryDao {
    void addCar(CarData carData);

    ArrayList<CarData> findCarsByOwnerId(int ownerId);
}
