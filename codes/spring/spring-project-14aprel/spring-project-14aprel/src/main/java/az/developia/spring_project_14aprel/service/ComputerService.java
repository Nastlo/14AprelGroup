package az.developia.spring_project_14aprel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.repository.ComputerRepo;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepo repository;

    public List<Computer> getAll() {
        return repository.findAll();
    }

    public Computer getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void add(Computer computer) {
        repository.save(computer);
    }

    public void update(Computer computer) {

        if (computer.getId() == null || computer.getId() <= 0) {
            throw new IllegalArgumentException("ID boş, null və ya 0 ola bilməz!");
        }

        repository.save(computer);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}