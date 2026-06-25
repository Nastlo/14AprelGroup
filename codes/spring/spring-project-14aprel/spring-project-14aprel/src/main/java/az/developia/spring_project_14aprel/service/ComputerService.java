package az.developia.spring_project_14aprel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.repository.ComputerRepo;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepo computerRepo;

    public List<Computer> getAll() {
        return computerRepo.findAll();
    }

    public Computer getById(Integer id) {
        return computerRepo.findById(id).orElse(null);
    }

    public void add(Computer computer) {
        computerRepo.save(computer);
    }

    public void update(Computer computer) {
        computerRepo.save(computer);
    }

    public void delete(Integer id) {
        computerRepo.deleteById(id);
    }

    public List<Computer> findByBrand(String brand) {
        return computerRepo.findByBrandContaining(brand);
    }

    public List<Computer> findByPriceRange(Double a, Double b) {
        return computerRepo.findComputersByPriceRange(a, b);
    }
}