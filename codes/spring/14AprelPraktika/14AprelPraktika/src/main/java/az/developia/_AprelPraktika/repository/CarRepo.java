package az.developia._AprelPraktika.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import az.developia._AprelPraktika.entity.Car;

public interface CarRepo extends JpaRepository<Car, Long> {

}