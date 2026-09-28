package az.developia.spring_project_14aprel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import az.developia.spring_project_14aprel.requestdto.ComputerRequestDto;
import az.developia.spring_project_14aprel.responsedto.ComputerResponseDto;
import az.developia.spring_project_14aprel.service.ComputerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/computers")
@Tag(name = "Computers", description = "Computer idarəetmə əməliyyatları")
public class ComputerController {

    @Autowired
    private ComputerService service;

    @GetMapping
    @Operation(summary = "Bütün computer-ləri gətirir")
    public List<ComputerResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "ID-yə görə computer gətirir")
    public ComputerResponseDto getById(
            @Parameter(description = "Computer ID-si")
            @PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Yeni computer əlavə edir")
    public String add(@RequestBody ComputerRequestDto dto) {
        service.add(dto);
        return "Computer elave edildi";
    }

    @PutMapping
    @Operation(summary = "Computer məlumatlarını yeniləyir")
    public String update(@RequestBody ComputerRequestDto dto) {
        service.update(dto);
        return "Computer yenilendi";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Computer-i silir")
    public String delete(
            @Parameter(description = "Silinəcək computer-in ID-si")
            @PathVariable Integer id) {
        service.delete(id);
        return "Computer silindi";
    }

    @GetMapping("/page")
    @Operation(summary = "Computer-ləri səhifələyərək gətirir")
    public Page<ComputerResponseDto> pagination(
            @Parameter(description = "Səhifə nömrəsi")
            @RequestParam int page,

            @Parameter(description = "Səhifədəki element sayı")
            @RequestParam int size) {

        return service.getPagination(page, size);
    }
}