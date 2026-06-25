package az.developia._AprelPraktika.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import az.developia._AprelPraktika.entity.Car;
import az.developia._AprelPraktika.service.CarService;

@RestController
@RequestMapping("/cars")   
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping
    public void addCar(@RequestBody Car car) {
        service.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return service.getCarById(id);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return service.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        service.deleteCar(id);
    }
}