package az.developia.spring_project_14aprel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.repository.ComputerRepo;
import az.developia.spring_project_14aprel.requestdto.ComputerRequestDto;
import az.developia.spring_project_14aprel.responsedto.ComputerResponseDto;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepo computerRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ComputerResponseDto> getAll() {
        return computerRepo.findAll()
                .stream()
                .map(computer -> modelMapper.map(computer, ComputerResponseDto.class))
                .collect(Collectors.toList());
    }

    public ComputerResponseDto getById(Integer id) {
        Computer computer = computerRepo.findById(id).orElse(null);

        if (computer == null) {
            return null;
        }

        return modelMapper.map(computer, ComputerResponseDto.class);
    }

    public void add(ComputerRequestDto dto) {
        Computer computer = modelMapper.map(dto, Computer.class);
        computerRepo.save(computer);
    }

    public void update(ComputerRequestDto dto) {
        Computer computer = modelMapper.map(dto, Computer.class);
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

    public Page<ComputerResponseDto> getPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Computer> result = computerRepo.findAll(pageable);

        return result.map(computer -> modelMapper.map(computer, ComputerResponseDto.class));
    }
}