package az.developia.computerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import az.developia.computerservice.entity.Computer;
import az.developia.computerservice.repository.ComputerRepository;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final ObservationRegistry observationRegistry;

    public ComputerService(
            ComputerRepository computerRepository,
            ObservationRegistry observationRegistry) {
        this.computerRepository = computerRepository;
        this.observationRegistry = observationRegistry;
    }

    public List<Computer> getComputersByUserId(Integer userId) {

        return Observation.createNotStarted(
                "computer.getComputersByUserId",
                observationRegistry
        ).observe(() -> computerRepository.findAllByUserId(userId));
    }
}