package az.developia.spring_project_14aprel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.service.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerService service;

    @GetMapping
    public List<Computer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Computer getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public String add(@RequestBody Computer computer) {
        service.add(computer);
        return "Computer elave edildi";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Computer silindi";
    }
}