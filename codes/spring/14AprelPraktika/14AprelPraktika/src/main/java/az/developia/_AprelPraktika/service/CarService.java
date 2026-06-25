package az.developia._AprelPraktika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia._AprelPraktika.entity.Car;
import az.developia._AprelPraktika.repository.CarRepo;

@Service
public class CarService {

    @Autowired
    private CarRepo repo;

    public void addCar(Car car) {
        repo.save(car);
    }

    public List<Car> getAllCars() {
        return repo.findAll();
    }

    public Car getCarById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Car updateCar(Long id, Car newCar) {
        Car existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setMarka(newCar.getMarka());
            existing.setModel(newCar.getModel());
            existing.setYear(newCar.getYear());
            return repo.save(existing);
        }

        return null;
    }

    public void deleteCar(Long id) {
        repo.deleteById(id);
    }
}