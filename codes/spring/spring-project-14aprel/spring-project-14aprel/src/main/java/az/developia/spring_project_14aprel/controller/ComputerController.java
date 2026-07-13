package az.developia.spring_project_14aprel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ComputerResponseDto getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public String add(@RequestBody ComputerRequestDto dto) {
        service.add(dto);
        return "Computer elave edildi";
    }

    @PutMapping
    public String update(@RequestBody ComputerRequestDto dto) {
        service.update(dto);
        return "Computer yenilendi";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Computer silindi";
    }

    @GetMapping("/page")
    public Page<ComputerResponseDto> pagination(
            @RequestParam int page,
            @RequestParam int size) {

        return service.getPagination(page, size);
    }
}