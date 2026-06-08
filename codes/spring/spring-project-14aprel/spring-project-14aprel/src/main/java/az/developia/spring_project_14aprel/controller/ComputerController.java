package az.developia.spring_project_14aprel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project_14aprel.entity.Computer;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    private List<Computer> computers = new ArrayList<>();

    public ComputerController() {
        computers.add(new Computer(1, "Asus", "TUF"));
        computers.add(new Computer(2, "HP", "Pavilion"));
        computers.add(new Computer(3, "Dell", "Inspiron"));
        computers.add(new Computer(4, "Asus", "ROG"));
    }

    @GetMapping
    public List<Computer> getAll() {
        return computers;
    }

    @GetMapping("/search")
    public List<Computer> searchByBrand(@RequestParam String brand) {

        List<Computer> result = new ArrayList<>();

        for (Computer c : computers) {
            if (c.getBrand().equalsIgnoreCase(brand)) {
                result.add(c);
            }
        }

        return result;
    }
}