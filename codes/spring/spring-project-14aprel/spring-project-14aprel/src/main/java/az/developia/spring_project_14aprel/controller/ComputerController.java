package az.developia.spring_project_14aprel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.requestdto.ComputerRequestDto;
import az.developia.spring_project_14aprel.responsedto.ComputerResponseDto;
import az.developia.spring_project_14aprel.service.ComputerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerService service;

    @GetMapping
    public List<ComputerResponseDto> getAll() {

        List<Computer> computers = service.getAll();
        List<ComputerResponseDto> response = new ArrayList<>();

        for (Computer c : computers) {
            response.add(
                    new ComputerResponseDto(
                            c.getId(),
                            c.getBrand(),
                            c.getModel()));
        }

        return response;
    }

    @GetMapping("/{id}")
    public ComputerResponseDto getById(@PathVariable Integer id) {

        Computer c = service.getById(id);

        return new ComputerResponseDto(
                c.getId(),
                c.getBrand(),
                c.getModel());
    }

    @PostMapping
    public String add(@RequestBody ComputerRequestDto dto) {

        Computer computer = new Computer();

        computer.setId(dto.getId());
        computer.setBrand(dto.getBrand());
        computer.setModel(dto.getModel());
        computer.setPrice(dto.getPrice());

        service.add(computer);

        return "Computer elave edildi";
    }

    @PutMapping
    public String update(@RequestBody ComputerRequestDto dto) {

        Computer computer = new Computer();

        computer.setId(dto.getId());
        computer.setBrand(dto.getBrand());
        computer.setModel(dto.getModel());
        computer.setPrice(dto.getPrice());

        service.update(computer);

        return "Computer yenilendi";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Computer silindi";
    }

    @GetMapping("/search")
    public List<Computer> searchByBrand(@RequestParam String brand) {
        return service.findByBrand(brand);
    }

    @GetMapping("/price")
    public List<Computer> searchByPrice(
            @RequestParam(name = "minPrice") Double a,
            @RequestParam(name = "maxPrice") Double b) {
        return service.findByPriceRange(a, b);
    }
}