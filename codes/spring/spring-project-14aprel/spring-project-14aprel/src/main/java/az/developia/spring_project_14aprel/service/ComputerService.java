package az.developia.spring_project_14aprel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.repository.ComputerRepository;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository repository;

    public List<Computer> getAll() {
        return repository.getAll();
    }

    public Computer getById(Integer id) {
        return repository.getById(id);
    }

    public void add(Computer computer) {
        repository.add(computer);
    }

    public void update(Computer computer) {

        if (computer.getId() == null || computer.getId() <= 0) {
            throw new IllegalArgumentException("ID boş, null və ya 0 ola bilməz!");
        }

        repository.update(computer);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}