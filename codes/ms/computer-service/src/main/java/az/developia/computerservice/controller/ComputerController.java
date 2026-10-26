package az.developia.computerservice.controller;

import org.springframework.web.bind.annotation.*;

import az.developia.computerservice.response.ComputerListResponse;
import az.developia.computerservice.service.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/user/{userId}")
    public ComputerListResponse getComputersByUserId(
            @PathVariable Integer userId) {

        return new ComputerListResponse(
                computerService.getComputersByUserId(userId)
        );
    }
}