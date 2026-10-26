package az.developia.computerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import az.developia.computerservice.entity.Computer;
import az.developia.computerservice.repository.ComputerRepository;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public List<Computer> getComputersByUserId(Integer userId) {
        return computerRepository.findAllByUserId(userId);
    }
}